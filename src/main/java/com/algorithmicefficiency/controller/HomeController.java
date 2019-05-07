package com.algorithmicefficiency.controller;

import com.algorithmicefficiency.*;
import com.algorithmicefficiency.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	@Autowired
	public HomeController() {

	}

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("test", "Test");
		return "index";
	}

}
