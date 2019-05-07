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
	public String index() {
		return "index";
	}

	@GetMapping(value = "/sort")
	public RedirectView sort() {
		Sort sort = new Sort();
		sortRepository.deleteAll();
		sort.start();
		sortRepository.save(sort);
		System.out.println(sortRepository.findAll());
		return new RedirectView("/");
	}


}
