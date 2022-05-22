package project.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import project.entities.User;
import project.entities.User_Role;

@Controller
public class LoginController {
	@Autowired
	private UserDAO UserDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	@RequestMapping(value = { "/", "/login" })
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("mess", "Login failed!");
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "login";
	}
	@RequestMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("u", user);
		return "register";
	}
	@RequestMapping("/registerForm")
	public String registerForm(@Valid @ModelAttribute("u")User u,@RequestParam("gender")Boolean gender, @RequestParam("confirmPassword")String confirmPassword,@RequestParam("imageUrl")MultipartFile multipartFile, Model model,HttpServletRequest request, BindingResult result) {
		String mess ="";
		u.setGender(gender);
		User_Role userRole = new User_Role();
		if(result.hasErrors()) {
			model.addAttribute("mess","Register Failed!");
			model.addAttribute("u",u);
			return "register";
		}else {
			if(u.getPassword().equals(confirmPassword)) {
				String path = request.getServletContext().getRealPath("resources/images");
				File f = new File(path);
				File dest = new File(f.getAbsolutePath()+"/"+multipartFile.getOriginalFilename());
				if(!dest.exists()) {
					try {
						Files.write(dest.toPath(),multipartFile.getBytes(), StandardOpenOption.CREATE);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				u.setAvatar(multipartFile.getOriginalFilename());
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(confirmPassword);
				u.setPassword(hashedPassword);
				Boolean bl = UserDAO.insertUser(u);
				if(bl) {
					userRole.setUserId(u.getId());
					userRole.setRoleId(2);
					bl = userRoleDAO.insertUserRole(userRole);
					if(bl) {
						model.addAttribute("mess","Register success!");
						return "redirect:/login";
					}
					else {
						model.addAttribute("mess","Register Failed!");
						model.addAttribute("u",u);
						return "register";
					}
				}else {
					model.addAttribute("mess","Register Failed!");
					model.addAttribute("u",u);
					return "register";
				}
			}else {
				mess="Confirm password is wrong!";
				model.addAttribute("mess",mess);
				return "register";
			}
		}
	}
}
