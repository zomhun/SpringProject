package project.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import project.DAO.UserDAO;
import project.DAO.UserRoleDAO;
import project.DAO.User_CourseDAO;
import project.DAO.LabDAO;
import project.DAO.CourseDAO;
import project.entities.Course;
import project.entities.Lab;
import project.entities.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserDAO UserDAO;
	@Autowired
	private UserRoleDAO UserRoleDAO;
	@Autowired
	private User_CourseDAO User_CourseDAO;
	@Autowired
	private LabDAO LabDAO;
	@Autowired
	private CourseDAO CourseDAO;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("mess", "Welcome to admin page");
        List<User> listUser = UserDAO.getListUser();
		model.addAttribute("list", listUser);
        return "admin_listUser";
    }   
    @RequestMapping("/searchUser")
	public String searchUser(@RequestParam("username")String username, Model model) {
		List<User> listUser = UserDAO.searchUsername(username);
		model.addAttribute("list", listUser);
		return "admin_listUser";
	}
    @RequestMapping("/searchAdvanceUser")
	public String searchAdvanceUser(@RequestParam("username")String username,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address, Model model) {
		List<User> listUser = UserDAO.searchAdvanceUser(username,email,phone,address);
		model.addAttribute("list", listUser);
		return "admin_listUser";
	}
    @RequestMapping("/initUpdateUser")
	public String initUpdateUser(@RequestParam("id") int userId, Model model) {
		User userbyId = UserDAO.getUserByUserId(userId);
		model.addAttribute("u", userbyId);
		return "admin_updateUser";
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
			return "redirect:/admin/initUpdateUser";
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
					return "redirect:/admin/welcome";
				} else {
					model.addAttribute("mess", "Update Failed!");
					model.addAttribute("u", u);
					return "redirect:/admin/initUpdateUser";
				}
			} else {
				mess = "Confirm password is wrong!";
				model.addAttribute("mess", mess);
				return "redirect:/admin/initUpdateUser";
			}
		}
	}
    @RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") int userId, Model model) {
		boolean bl1 = UserRoleDAO.delete(userId);
		boolean bl = UserDAO.deleteUser(userId);
		if (bl || bl1) {
			model.addAttribute("mess", "Delete successfuly!");
			return "redirect:/admin/welcome";
		} else {
			model.addAttribute("mess", "Delete failed!");
			return "redirect:/admin/welcome";
		}
	}
    @RequestMapping("/listLab")
    public String listLab(Model model) {
        List<Lab> listLab = LabDAO.getListLab();
		model.addAttribute("list", listLab);
        return "admin_listLab";
    }  
    @RequestMapping("/initInsertLab")
	public String initInsertLab(Model model) {
		Lab l = new Lab();
		model.addAttribute("l", l);
		return "admin_insertLab";
	}
	@RequestMapping("/insertLabForm")
	public String insertLabForm(@ModelAttribute("l")Lab l, Model model) {
		boolean bl = LabDAO.insertLab(l);
		if(bl) {
			return "redirect:/admin/listLab";
		}else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("l", l);
			return "admin_insertLab";
		}
	}
    @RequestMapping("/initUpdateLab")
	public String initUpdateLab(@RequestParam("id") int id, Model model) {
		Lab labById = LabDAO.getLabById(id);
		model.addAttribute("l", labById);
		return "admin_updateLab";
	}
    @RequestMapping("/updateLabForm")
	public String updateLabForm(@Valid @ModelAttribute("l") Lab l, Model model, HttpServletRequest request) {
    	boolean bl = LabDAO.updateLab(l);
		if(bl) {
			model.addAttribute("mess", "Update successfuly!");
			return "redirect:/admin/listLab";
		}else {
			model.addAttribute("mess", "Update failed!");
			model.addAttribute("l", l);
			return "admin_updateLab";
		}
		
	}
    @RequestMapping("/deleteLab")
	public String deleteLab(@RequestParam("id") int id, Model model) {
		boolean bl = LabDAO.deleteLab(id); 
		boolean bl1 = LabDAO.deleteCourse(id);
		if (bl&&bl1) {
			model.addAttribute("success", "Delete successfuly!");
			return "redirect:/admin/listLab";
		} else {
			model.addAttribute("error", "Delete failed!");
			return "redirect:/admin/listLab";
		}
	}
    @RequestMapping("/listCourse")
    public String listCourse(Model model) {
        List<Course> listCourse = CourseDAO.getListCourse();
		model.addAttribute("list", listCourse);
        return "admin_listCourse";
    }
    @RequestMapping("/initInsertCourse")
	public String initInsertCourse(Model model) {
		Course c = new Course();
		model.addAttribute("c", c);
		List<Lab> listLab = LabDAO.getListLab();
		model.addAttribute("listOfLab", listLab);
		return "admin_insertCourse";
	}
	@RequestMapping("/insertCourseForm")
	public String insertCourseForm(@ModelAttribute("c")Course course, Model model) {
		boolean bl = CourseDAO.insertCourse(course);
		if(bl) {
			return "redirect:/admin/listCourse";
		}else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("c", course); 
			return "admin_insertCourse";
		}
	}
    @RequestMapping("/initUpdateCourse")
	public String initUpdateCourse(@RequestParam("id") int id, Model model) {
    	Course CourseById = CourseDAO.getCourseById(id);
    	List<Lab> listLab = LabDAO.getListLab();
		model.addAttribute("listOfLab", listLab);
		model.addAttribute("c", CourseById);
		return "admin_updateCourse";
	}
    @RequestMapping("/updateCourseForm")
	public String updateCourseForm(@Valid @ModelAttribute("c") Course course, Model model) {
    	boolean bl = CourseDAO.updateCourse(course);
		if(bl) {
			model.addAttribute("mess", "Update successfuly!");
			return "redirect:/admin/listCourse";
		}else {
			model.addAttribute("mess", "Update failed!");
			model.addAttribute("c", course);
			return "admin_updateCourse";
		}
		
	}
    @RequestMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("id") int id, Model model) {
		boolean bl = CourseDAO.deleteCourse(id);
		if (bl) {
			model.addAttribute("mess", "Delete successfuly!");
			return "redirect:/admin/listCourse";
		} else {
			model.addAttribute("errmessor", "Delete failed!");
			return "redirect:/admin/listCourse";
		}
	}
    @RequestMapping("/listCourseUser")
    public String listCourseUser(Model model,@RequestParam("id") int id) {
        List<User> listCU = User_CourseDAO.getListCourseUser(id);
		model.addAttribute("list", listCU);
        return "admin_listCourseUser";
    }
    @RequestMapping("/listUserCourse")
    public String listUserCourse(Model model,@RequestParam("id") int id) {
    	List<Course> listCU = User_CourseDAO.getListUserCourse(id);
		model.addAttribute("list", listCU);
        return "admin_listUserCourse";
    }
    @RequestMapping("/deleteCourseUser")
	public String deleteCourseUser(@RequestParam("id") int id,@RequestParam("courseId") int courseId, Model model) {
		boolean bl = User_CourseDAO.deleteUserCourse(id);
		boolean bl1 = CourseDAO.add1StillEmpty(courseId);
		if (bl&&bl1) {
			model.addAttribute("mess", "Delete successfuly!");
			return "redirect:/admin/listCourse";
		} else {
			model.addAttribute("mess", "Delete failed!");
			return "redirect:/admin/listCourse";
		}
	}
    @RequestMapping("/deleteUserCourse")
	public String deleteUserCourse(@RequestParam("id") int id,@RequestParam("courseId") int courseId, Model model) {
		boolean bl = User_CourseDAO.deleteUserCourse(id);
		boolean bl1 = CourseDAO.add1StillEmpty(courseId);
		if (bl&&bl1) {
			model.addAttribute("mess", "Delete successfuly!");
			return "redirect:/admin/welcome";
		} else {
			model.addAttribute("mess", "Delete failed!");
			return "redirect:/admin/welcome";
		}
	}
}


