package ca.sheridancollege.delcorem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.delcorem.beans.User;
import ca.sheridancollege.delcorem.database.DatabaseAccess;

/*
 * Author: Michael Delcore
 * 
 * I changed my port from 8080 to 8443, and I encrypted using BCrypt. Look for the p12 file.
 */
@Controller
public class HomeController {

	@Autowired
	@Lazy
	private DatabaseAccess da;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/secure")
	public String secureIndex(Authentication authentication, Model model) {
		String email = authentication.getName();
		List<String> roleList = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roleList.add(ga.getAuthority());
		}
		model.addAttribute("email", email);
		model.addAttribute("roleList", roleList);
		return "/secure/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/permission-denied")
	public String permissionDenied() {
		return "/error/permission-denied";
	}

	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}

	@PostMapping("/register")
	public String postRegister(@RequestParam String username, @RequestParam String password) {
		da.addUser(username, password);
		Long userId = da.findUserAccount(username).getUserId();
		da.addRole(userId, Long.valueOf(2));
		return "redirect:/";
	}
	
	@GetMapping("/secure/forum")
	public String index(Model model) {
		
		model.addAttribute("user", new User());
		
		model.addAttribute("userList", da.getUserList());
		
		return "/secure/forum";
	}
	
	@PostMapping("/insertUser")
	public String insertUser(Model model, @ModelAttribute User user, Authentication authentication) {
		String email = authentication.getName();
		user.setEmail(email);
		da.insertUser(user);
		
		model.addAttribute("user", new User());
		
		model.addAttribute("userList", da.getUserList());
		
		return "/secure/forum";
	}

}
