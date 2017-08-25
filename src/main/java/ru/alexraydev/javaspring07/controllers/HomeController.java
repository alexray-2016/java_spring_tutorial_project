package ru.alexraydev.javaspring07.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexraydev.javaspring07.dao.Offer;
import ru.alexraydev.javaspring07.service.OffersService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private OffersService offersService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
        List<Offer> offers = offersService.getCurrent();

        model.addAttribute("offers", offers);

        boolean hasOffer = false;

        if (principal != null) {
            hasOffer = offersService.hasOffer(principal.getName());
        }

        model.addAttribute("hasOffer", hasOffer);

		return "home";
	}
}
