package ru.alexraydev.javaspring07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alexraydev.javaspring07.service.OffersService;

@Controller
public class OffersController {

    @Autowired
    private OffersService service;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id") String id) {
        System.out.println("Id is: " + id);
        return "home";
    }

    @RequestMapping("/offers")
     public String showOffers(Model model) {
        model.addAttribute("offers", service.getCurrent());
        return "offers";
    }

    @RequestMapping("/createoffer")
    public String createOffer(Model model) {
        return "createoffer";
    }
}
