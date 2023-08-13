package com.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MControl {
@GetMapping("/wel")
public String wel(Model model) {
	String s="Welcome kanhaiya";
	model.addAttribute("msg",s);
	return "home";
}
}
