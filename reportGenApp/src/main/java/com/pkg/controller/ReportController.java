package com.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pkg.entity.CitizenPlan;
import com.pkg.request.SearchRequest;
import com.pkg.service.ReportService;


@Controller
public class ReportController {

	@Autowired
	private ReportService reportService; // Uncomment this line
	@PostMapping("/search")
	public String handelSearch(@ModelAttribute("search") SearchRequest search,Model model) {
//		System.out.println(search);
		model.addAttribute(search);
		List<CitizenPlan>plans=reportService.search(search);
		model.addAttribute("plan", plans);
		init(model);
		return "home";
	}
	@GetMapping("/")
	public String indexPage(Model model) {
	    model.addAttribute("search", new SearchRequest());
	    init(model);
	    return "home";
	}
	private void init(Model model) {
		model.addAttribute("names",reportService.getPlanNames());
	    model.addAttribute("status",reportService.getPlanStatus());
	}


}
