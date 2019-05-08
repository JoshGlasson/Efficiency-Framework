package com.algorithmicefficiency.controller;

import com.algorithmicefficiency.model.Sort;
import com.algorithmicefficiency.repository.SortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	private final SortRepository sortRepository;

	@Autowired
	public HomeController(SortRepository sortRepository) {
		this.sortRepository = sortRepository;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/sort")
	public RedirectView sort(RedirectAttributes redirAttrs) {
		Sort sort = new Sort();
		sortRepository.deleteAll();
		sort.start();
		sortRepository.save(sort);
		redirAttrs.addFlashAttribute("message", "Sort Data Refreshed: ");
		redirAttrs.addFlashAttribute("newdata", ""+ sortRepository.findAll() +"");
		return new RedirectView("/");
	}


}
