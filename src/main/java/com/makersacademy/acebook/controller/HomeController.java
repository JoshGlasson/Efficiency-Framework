package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.*;
import com.makersacademy.acebook.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	private final PostRepository postRepository;
	private final UserRepository userRepository;


	@Autowired
	public HomeController(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/post")
	public String post(Model model) {
		model.addAttribute("post", new PostForm("Content"));
		return "post";
	}

	@PostMapping(value = "/post")
	public RedirectView post(@ModelAttribute Post post) {
		postRepository.save(post);
		return new RedirectView("/");
	}

	@GetMapping(value = "user/new")
	public String user(Model model) {
		model.addAttribute("user", new UserForm("name", "email", "password"));
		return "register";
	}

	@PostMapping(value = "user")
	public RedirectView user(@ModelAttribute User user) {
		userRepository.save(user);
		return new RedirectView("/");
	}


}
