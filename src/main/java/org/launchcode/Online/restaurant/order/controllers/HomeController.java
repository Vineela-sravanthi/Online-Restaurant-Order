package org.launchcode.Online.restaurant.order.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping(value = "")
    public String index() {

        return "home/index";
    }

    @RequestMapping(value = "contactus")
    public String contact() {
        return "home/contactus";
    }
}
