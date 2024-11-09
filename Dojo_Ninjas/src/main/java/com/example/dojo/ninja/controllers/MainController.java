package com.example.dojo.ninja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojo.ninja.models.Dojo;
import com.example.dojo.ninja.models.Ninja;
import com.example.dojo.ninja.services.DojoService;
import com.example.dojo.ninja.services.NinjaService;

@Controller
public class MainController {
	
	// Services
	@Autowired
	private NinjaService ninjas;
	@Autowired
	private DojoService dojos;
	
	// All Rendering GET Routes
	
	@GetMapping("/dojos/new")
	public String newDojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojoForm.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "newNinjaForm.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		System.out.printf("dojo id from url: %s",id);
		Dojo dojo = dojos.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "showDojo.jsp";
	}
	
	// All processing POST / Redirect routes
	
	@PostMapping("/dojos")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		Dojo newDojo = dojos.createDojo(dojo);
		System.out.printf("new id: %s", dojo.getId());
		
		return String.format("redirect:/dojos/%s",newDojo.getId());
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
		ninja = ninjas.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
	
}