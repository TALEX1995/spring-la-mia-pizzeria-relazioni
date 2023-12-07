package org.java.spring.controller;

import org.java.spring.Pizza;
import org.java.spring.SpecialOffer;
import org.java.spring.db.serv.PizzaService;
import org.java.spring.db.serv.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpecialOfferController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialOfferService specialOfferService;
	
	@GetMapping("/pizzas/{id}/offer")
	public String createOffer(Model model, @PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		SpecialOffer offer = new SpecialOffer();
		model.addAttribute("pizza", pizza);
		model.addAttribute("offer", offer);
		return "offer-form";
	}
	
	@PostMapping("/pizzas/{id}/offer")
	public String storeOffer(@PathVariable int id, @ModelAttribute SpecialOffer specialOffer) {
		
		Pizza pizza = pizzaService.findById(id);
		
		SpecialOffer newOffer = new SpecialOffer(specialOffer.getOfferStart(), specialOffer.getOfferEnd(), specialOffer.getTitle(), pizza);
		
		specialOfferService.save(newOffer);
		
		return "redirect:/pizzas";
	}
}
