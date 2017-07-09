package com.walmart.shopify.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walmart.shopify.model.Seller;
import com.walmart.shopify.repository.SellerRepository;
import com.walmart.shopify.repository.SellerSearchRepository;


@Controller
public class ShopifyController {
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	SellerSearchRepository sellerSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model){
	 model.addAttribute("sellerList", sellerRepository.findAll());
	 return "home";
	}

@RequestMapping(value = "/addSeller", method = RequestMethod.POST)
public String addSeller(@ModelAttribute Seller seller) {
	sellerRepository.save(seller);
	System.out.println("Seller data saved successfully");
	return "redirect:home";
}

@RequestMapping(value = "/search")
public String search(Model model, @RequestParam String search) {
	model.addAttribute("sellerList", sellerSearchRepository.searchSellers(search));
	model.addAttribute("search", search);
	return "home";
}

	
	


}
