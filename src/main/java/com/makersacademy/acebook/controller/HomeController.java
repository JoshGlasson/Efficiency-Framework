package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.*;
import com.makersacademy.acebook.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

@Controller
public class HomeController extends HttpServlet {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;

	@Autowired
	public HomeController(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
	}

	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("current user") != null) {
			User user = (User) session.getAttribute("current user");
			System.out.println(user.getId());
			model.addAttribute("user_id", user.getId());
			model.addAttribute("post", new PostForm("", user.getId()));
		}
		model.addAttribute("user", new SignInForm("", ""));
		System.out.println(session.getAttribute("current user"));
		return "index";
	}
//
//	@GetMapping(value = "/post")
//	public ModelAndView post(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("current user") != null) {
//			model.addAttribute("post", new PostForm("Content", ));
//			System.out.println(session.getAttribute("current user"));
//			return new ModelAndView("post");
//		} else {
//			System.out.println(session.getAttribute("current user"));
//			return new ModelAndView(new RedirectView("/user/new"));
//		}
//	}

	@PostMapping(value = "/post")
	public RedirectView post(@ModelAttribute Post post) {
		postRepository.save(post);
		return new RedirectView("/");
	}

	@GetMapping(value = "user/new")
	public String user(Model model) {
		model.addAttribute("user", new UserForm("", "", ""));
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
	public RedirectView signIn(@ModelAttribute SignInForm user, HttpServletRequest request) {
		if (SignIn.checkPassword(user.getPassword(),userRepository.findByEmailIn(user.getEmail()).getPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("current user", userRepository.findByEmailIn(user.getEmail()));
		}
		else {
			System.out.println("does not match");
		}
		return new RedirectView("/");
	}

	@GetMapping(value = "user/signout")
	public RedirectView signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("current user", null);
		return new RedirectView("/");
	}
//
//	@GetMapping(value = "/post/{post_id}/comment")
//	public ModelAndView comment(Model model, HttpServletRequest request, @PathVariable Long post_id) {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("current user") != null) {
//			System.out.println(post_id);
//			model.addAttribute("comment", new CommentForm("Content", post_id));
//			System.out.println(post_id);
//			System.out.println(session.getAttribute("current user"));
//			return new ModelAndView("comment");
//		} else {
//			System.out.println(session.getAttribute("current user"));
//			return new ModelAndView(new RedirectView("/user/new"));
//		}
//	}

	@PostMapping(value = "/comment")
	public RedirectView comment(@ModelAttribute Comment comment) {
		System.out.println(comment);
		commentRepository.save(comment);
		return new RedirectView("/");
	}

}
