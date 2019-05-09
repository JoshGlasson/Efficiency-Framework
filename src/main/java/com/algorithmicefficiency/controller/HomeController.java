package com.algorithmicefficiency.controller;

import com.algorithmicefficiency.model.*;
import com.algorithmicefficiency.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.math.MathContext;

@Controller
public class HomeController {

	private final SortRepository sortRepository;
	private final ReverseRepository reverseRepository;
	private final ShuffleRepository shuffleRepository;
	private final LastRepository lastRepository;
	private final DuplicatesRepository duplicatesRepository;

	@Autowired
	public HomeController(SortRepository sortRepository, ReverseRepository reverseRepository, ShuffleRepository shuffleRepository, LastRepository lastRepository, DuplicatesRepository duplicatesRepository) {
		this.sortRepository = sortRepository;
		this.reverseRepository = reverseRepository;
		this.shuffleRepository = shuffleRepository;
		this.lastRepository = lastRepository;
		this.duplicatesRepository = duplicatesRepository;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/sort")
	public RedirectView sort(RedirectAttributes redirAttrs) {
		Sort sort = new Sort();
		System.out.println("Class Created");
		sortRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		long start = System.nanoTime();
		sort.start();
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		System.out.println("Data Run. Saving...");
		sortRepository.save(sort);
		System.out.println("Finished Updating");

		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();

		redirAttrs.addFlashAttribute("message", "Sort Data Refreshed in " + rounded/1000000000 + " Seconds");
//		redirAttrs.addFlashAttribute("newdata", ""+ sortRepository.findAll() +"");
		return new RedirectView("/sortgraph");
	}

	@GetMapping(value = "/reverse")
	public RedirectView reverse(RedirectAttributes redirAttrs) {
		Reverse reverse = new Reverse();
		System.out.println("Class Created");
		reverseRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		long start = System.nanoTime();
		reverse.start();
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		System.out.println("Data Run. Saving...");
		reverseRepository.save(reverse);
		System.out.println("Finished Updating");

		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();

		redirAttrs.addFlashAttribute("message", "Reverse Data Refreshed in " + rounded/1000000000 + " Seconds");
//		redirAttrs.addFlashAttribute("newdata", ""+ reverseRepository.findAll() +"");
		return new RedirectView("/reversegraph");
	}

	@GetMapping(value = "/shuffle")
	public RedirectView shuffle(RedirectAttributes redirAttrs) {
		Shuffle shuffle = new Shuffle();
		System.out.println("Class Created");
		shuffleRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		long start = System.nanoTime();
		shuffle.start();
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		System.out.println("Data Run. Saving...");
		shuffleRepository.save(shuffle);
		System.out.println("Finished Updating");

		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();

		redirAttrs.addFlashAttribute("message", "Shuffle Data Refreshed in " + rounded/1000000000 + " Seconds");
//		redirAttrs.addFlashAttribute("newdata", ""+ shuffleRepository.findAll() +"");
		return new RedirectView("/shufflegraph");
	}

	@GetMapping(value = "/last")
	public RedirectView last(RedirectAttributes redirAttrs) {
		Last last = new Last();
		System.out.println("Class Created");
		lastRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		long start = System.nanoTime();
		last.start();
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		System.out.println("Data Run. Saving...");
		lastRepository.save(last);
		System.out.println("Finished Updating");

		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();

		redirAttrs.addFlashAttribute("message", "Last Data Refreshed in " + rounded/1000000000 + " Seconds");
//		redirAttrs.addFlashAttribute("newdata", ""+ lastRepository.findAll() +"");
		return new RedirectView("/lastgraph");
	}

	@GetMapping(value = "/duplicates")
	public RedirectView duplicates(RedirectAttributes redirAttrs) {
		Duplicates duplicates = new Duplicates();
		System.out.println("Class Created");
		duplicatesRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		long start = System.nanoTime();
		duplicates.start();
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		System.out.println("Data Run. Saving...");
		duplicatesRepository.save(duplicates);
		System.out.println("Finished Updating");

		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();

		redirAttrs.addFlashAttribute("message", "Duplicates Data Refreshed in " + rounded/1000000000 + " Seconds");
//		redirAttrs.addFlashAttribute("newdata", ""+ duplicatesRepository.findAll() +"");
		return new RedirectView("/duplicatesgraph");
	}

	@GetMapping(value = "/all")
	public RedirectView all(RedirectAttributes redirAttrs) {

		long start = System.nanoTime();

		reverseRepository.deleteAll();
		sortRepository.deleteAll();
		shuffleRepository.deleteAll();
		lastRepository.deleteAll();
		duplicatesRepository.deleteAll();
		System.out.println("Previous Data Deleted");

		Reverse reverse = new Reverse();
		Shuffle shuffle = new Shuffle();
		Duplicates duplicates = new Duplicates();
		Sort sort = new Sort();
		Last last = new Last();
		System.out.println("Classes Created");

		System.out.println("Starting Refresh");

		System.out.println("Running Reverse");
		reverse.start();
		System.out.println("Reverse Run. Saving...");
		reverseRepository.save(reverse);
		System.out.println("Reverse Updated");

		System.out.println("Running Sort");
		sort.start();
		System.out.println("Sort Run. Saving...");
		sortRepository.save(sort);
		System.out.println("Sort Updated");

		System.out.println("Running Shuffle");
		shuffle.start();
		System.out.println("Shuffle Run. Saving...");
		shuffleRepository.save(shuffle);
		System.out.println("Shuffle Updated");

		System.out.println("Running Last");
		last.start();
		System.out.println("Last Run. Saving...");
		lastRepository.save(last);
		System.out.println("Last Updated");

		System.out.println("Running Duplicates");
		duplicates.start();
		System.out.println("Duplicates Run. Saving...");
		duplicatesRepository.save(duplicates);
		System.out.println("Duplicates Updated");
		System.out.println("All Run");

		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		// Round to milliseconds
		BigDecimal bd = new BigDecimal(timeElapsed);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();
		System.out.println(rounded/1000000000 + " Seconds");

		redirAttrs.addFlashAttribute("message", "All Data Refreshed  in " + rounded/1000000000 + " Seconds");
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

	@GetMapping(value = "/lastgraph")
	public String lastGraph() {
		return "last";
	}

	@GetMapping(value = "/duplicatesgraph")
	public String duplicatesGraph() {
		return "duplicates";
	}

}
