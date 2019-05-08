package com.algorithmicefficiency.controller;

import com.algorithmicefficiency.model.Reverse;
import com.algorithmicefficiency.model.Shuffle;
import com.algorithmicefficiency.model.Sort;
import com.algorithmicefficiency.repository.*;
import com.algorithmicefficiency.repository.SortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	private final SortRepository sortRepository;
	private final ReverseRepository reverseRepository;
	private final ShuffleRepository shuffleRepository;

	@Autowired
	public HomeController(SortRepository sortRepository, ReverseRepository reverseRepository, ShuffleRepository shuffleRepository) {
		this.sortRepository = sortRepository;
		this.reverseRepository = reverseRepository;
		this.shuffleRepository = shuffleRepository;
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
		return new RedirectView("/sortgraph");
	}

	@GetMapping(value = "/reverse")
	public RedirectView reverse(RedirectAttributes redirAttrs) {
		Reverse reverse = new Reverse();
		reverseRepository.deleteAll();
		reverse.start();
		reverseRepository.save(reverse);
		redirAttrs.addFlashAttribute("message", "Reverse Data Refreshed: ");
		redirAttrs.addFlashAttribute("newdata", ""+ reverseRepository.findAll() +"");
		return new RedirectView("/reversegraph");
	}

	@GetMapping(value = "/shuffle")
	public RedirectView shuffle(RedirectAttributes redirAttrs) {
		Shuffle shuffle = new Shuffle();
		shuffleRepository.deleteAll();
		shuffle.start();
		shuffleRepository.save(shuffle);
		redirAttrs.addFlashAttribute("message", "Shuffle Data Refreshed: ");
		redirAttrs.addFlashAttribute("newdata", ""+ shuffleRepository.findAll() +"");
		return new RedirectView("/shufflegraph");
	}

	@GetMapping(value = "/all")
	public RedirectView all(RedirectAttributes redirAttrs) {
		Reverse reverse = new Reverse();
		reverseRepository.deleteAll();
		reverse.start();
		reverseRepository.save(reverse);
		Sort sort = new Sort();
		sortRepository.deleteAll();
		sort.start();
		sortRepository.save(sort);
		Shuffle shuffle = new Shuffle();
		shuffleRepository.deleteAll();
		shuffle.start();
		shuffleRepository.save(shuffle);
		redirAttrs.addFlashAttribute("message", "All Data Refreshed: ");
		return new RedirectView("/");
	}

	@GetMapping(value = "/sortgraph")
	public String sortGraph() {
		return "sort";
	}

	@GetMapping(value = "/reversegraph")
	public String reverseGraph() {
		return "reverse";
	}

	@GetMapping(value = "/shufflegraph")
	public String shuffleGraph() {
		return "shuffle";
	}

}
