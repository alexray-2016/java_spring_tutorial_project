package ru.alexraydev.javaspring07.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.alexraydev.javaspring07.dao.User;
import ru.alexraydev.javaspring07.service.UsersService;

import java.util.List;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        List<User> users = usersService.getAllUsers();

        model.addAttribute("users", users);
        return "admin";
    }

    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
    }

    @RequestMapping("/loggedout")
    public String showLoggedOut() {
        return "loggedout";
    }
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	

	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		try {
			usersService.createUser(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		
		return "accountcreated";
	}
}
