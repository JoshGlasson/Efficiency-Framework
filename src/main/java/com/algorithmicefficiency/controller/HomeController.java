package com.algorithmicefficiency.controller;

import com.algorithmicefficiency.model.Sort;
import com.algorithmicefficiency.repository.SortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	private final SortRepository sortRepository;

	@Autowired
	public HomeController(SortRepository sortRepository) {
		this.sortRepository = sortRepository;
	}

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("arraySize", new Sort(null));
		return "index";
	}

	@PostMapping(value = "/sort")
	public RedirectView sort(@ModelAttribute Sort sort) {
//		sortRepository.deleteAll();
		sortRepository.save(sort);
		return new RedirectView("/");
	}

//	@GetMapping(value = "/sort")
//	public RedirectView graph(@ModelAttribute Sort sort) {
//		sortRepository.deleteAll();
//		sortRepository.save(sort);
//		return new RedirectView("/");
//	}


}
