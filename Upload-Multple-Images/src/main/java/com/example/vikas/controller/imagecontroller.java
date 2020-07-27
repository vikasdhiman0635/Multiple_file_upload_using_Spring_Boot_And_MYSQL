package com.example.vikas.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.vikas.model.UserFiles;
import com.example.vikas.model.UserModel;
import com.example.vikas.service.UserService;

@Controller
public class imagecontroller 
{
	@Autowired
	UserService userservice;
	
	@GetMapping(value="/")
	public String users(Model model)
	{
		List<UserModel> users=userservice.getallusers();
		model.addAttribute("users", users);
		model.addAttribute("user", new  UserModel());
		model.addAttribute("usersfiles", new ArrayList<UserFiles>());
		model.addAttribute("isAdd", true);
		return "view/user";
	}
	
	@PostMapping(value = "/save")
	public String save(@ModelAttribute UserModel user, RedirectAttributes redirectattribute, Model model)
	{
		UserModel dbUser=userservice.save(user);
		if(dbUser!=null)
		{
			redirectattribute.addFlashAttribute("Successfull", "User is save successfully");
			return "redirect:/";
		}
		else
		{
			model.addAttribute("errormessage","User is not save successfully, Please try again");
			model.addAttribute("user", user);
			return "view/user";
		}
	}
	
	@GetMapping(value = "/edituser/{userId}")
	public String editusers(@PathVariable Long userId, Model model)
	{
		UserModel user=userservice.findById(userId);
		List<UserFiles> userfile=userservice.findFilesById(userId);
		List<UserModel> users=userservice.getallusers();
		model.addAttribute("users", users);
		model.addAttribute("user", user);
		model.addAttribute("usersfiles", userfile);
		model.addAttribute("isAdd", false);
		return "view/user";
	}
	
}
