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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	private final PostRepository postRepository;
	private final UserRepository userRepository;

	private  User currentUser = null;

	@Autowired
	public HomeController(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/")
	public String index() {
		System.out.println(this.currentUser);
		return "index";
	}

	@GetMapping(value = "/post")
	public ModelAndView post(Model model) {
		if (this.currentUser != null) {
			model.addAttribute("post", new PostForm("Content"));
			return new ModelAndView("post");
		} else {
			return new ModelAndView(new RedirectView("/user/new"));		}
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

	@GetMapping(value = "user/signin")
	public String signIn(Model model) {
		model.addAttribute("user", new SignInForm("email", "password"));
		return "signin";
	}

	@PostMapping(value = "user/authentication")
	public RedirectView signIn(@ModelAttribute SignInForm user) {
		if (SignIn.checkPassword(user.getPassword(),userRepository.findByEmailIn(user.getEmail()).getPassword())){
			this.currentUser = userRepository.findByEmailIn(user.getEmail());
		}
		else {
			this.currentUser = null;
			System.out.println("does not match");
		}
		return new RedirectView("/");
	}

}
