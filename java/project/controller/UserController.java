package project.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.DAO.CourseDAO;
import project.DAO.LabDAO;
import project.DAO.UserDAO;
import project.DAO.UserRoleDAO;
import project.DAO.User_CourseDAO;
import project.entities.Course;
import project.entities.User;
import project.entities.User_Course;
import project.entities.User_Role;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDAO UserDAO;
	@Autowired
	private UserRoleDAO UserRoleDAO;
	@Autowired
	private LabDAO LabDAO;
	@Autowired
	private CourseDAO CourseDAO;
	@Autowired
	private User_CourseDAO User_CourseDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping("/user")
	public String userPage(Model model, Authentication authentication, HttpServletRequest request) {
		model.addAttribute("mess", "Welcome user page");
		User u = new User();
		Principal principal = request.getUserPrincipal();
		u = (User) UserDAO.searchByName(principal.getName());
		model.addAttribute("u",u);
		HttpSession session = request.getSession();
		session.setAttribute("Id",u.getId());
		List<Course> listCourse = CourseDAO.getAvailableCourse();
		model.addAttribute("list", listCourse);
		return "frontend_listCourses";
	}
	
	@RequestMapping("/searchCourse")
	public String searchReader(@RequestParam("courseName")String courseName,@RequestParam("minPrice")float minPrice,@RequestParam("maxPrice")float maxPrice, Model model) {
		List<Course> listCourse = CourseDAO.searchCourse(courseName,minPrice,maxPrice);
		model.addAttribute("list", listCourse);
		return "frontend_listCourses";
	}
	
	@RequestMapping("/registerCourse")
	public String registerCourse(@RequestParam("id") int courseId,HttpServletRequest request, Model model) {
		User_Course UC = new User_Course();
		Course c = new Course();
		c.setId(courseId);
		HttpSession session = request.getSession();
		UC.setCourseId(c);
		User u = UserDAO.getUserByUserId((int) session.getAttribute("Id"));
		UC.setUserId(u);
		boolean bl = User_CourseDAO.insertUser_Course(UC);
		boolean bl1 = CourseDAO.take1StillEmpty(courseId);
		if (bl&&bl1) {
			model.addAttribute("mess", "Register successfuly!");
			return "redirect:/user/user";
		} else {
			model.addAttribute("mess", "Register failed!");
			return "redirect:/user/user";
		}
	}
	@RequestMapping("/listCoursesRegisted")
    public String listCoursesRegisted(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	List<Course> listCU = User_CourseDAO.getListUserCourse((int) session.getAttribute("Id"));
		model.addAttribute("list", listCU);
        return "frontend_listCoursesRegisted";
    }
	@RequestMapping("/deleteUserCourse")
	public String deleteUserCourse(@RequestParam("id") int id, Model model) {
		boolean bl = User_CourseDAO.deleteUserCourse(id);
		boolean bl1 = CourseDAO.add1StillEmpty(id);
		if (bl&&bl1) {
			model.addAttribute("mess", "Delete successfuly!");
			return "redirect:/user/listCoursesRegisted";
		} else {
			model.addAttribute("mess", "Delete failed!");
			return "redirect:/user/listCoursesRegisted";
		}
	}
	@RequestMapping("/initUpdateUser")
	public String initUpdateUser(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int Id = (int) session.getAttribute("Id");
		User userbyId = UserDAO.getUserByUserId(Id);
		model.addAttribute("u", userbyId);
		return "frontend_updateUser";
	}

	@RequestMapping("/updateUserForm")
	public String updateUserForm(@Valid @ModelAttribute("u") User u, @RequestParam("gender") Boolean gender,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("imageUrl") MultipartFile multipartFile,
			@RequestParam("oldImageUrl") String oldImageUrl, Model model, HttpServletRequest request,
			BindingResult result) {
		String mess = "";
		u.setGender(gender);
		if (result.hasErrors()) {
			model.addAttribute("mess", "Update Failed!");
			model.addAttribute("u", u);
			return "redirect:/user/initUpdateUser";
		} else {
			if (u.getPassword().equals(confirmPassword)) {
				if (multipartFile == null) {
					u.setAvatar(oldImageUrl);
				} else {
					String path = request.getServletContext().getRealPath("resources/images");
					File f = new File(path);
					File dest = new File(f.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
					if (!dest.exists()) {
						try {
							Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					u.setAvatar(multipartFile.getOriginalFilename());
				}
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(confirmPassword);
				u.setPassword(hashedPassword);
				Boolean bl = UserDAO.updateUser(u);
				if (bl) {
					model.addAttribute("mess", "Update success!");
					return "redirect:/user/user";
				} else {
					model.addAttribute("mess", "Update Failed!");
					model.addAttribute("u", u);
					return "redirect:/user/initUpdateUser";
				}
			} else {
				mess = "Confirm password is wrong!";
				model.addAttribute("mess", mess);
				return "redirect:/user/initUpdateUser";
			}
		}
	}
	
	

}
