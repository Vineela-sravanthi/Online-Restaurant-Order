package org.launchcode.Online.restaurant.order.controllers;

import org.launchcode.Online.restaurant.order.models.Admin;
import org.launchcode.Online.restaurant.order.models.data.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminDao adminDao;


    @RequestMapping(value = "register")
    public String displayregister(Model model) {

        model.addAttribute(new Admin());
        model.addAttribute("title","Register");
        return "admin/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processregister(Model model, @ModelAttribute @Valid Admin admin, Errors errors, String verify){
        if(errors.hasErrors()){
            model.addAttribute("admin",admin);
            return "admin/register";
        }

        if((admin.getPassword()== null) || verify == null || (!admin.getPassword().equals(verify))) {
            String err = "Passwords Don't match";
            model.addAttribute("verify",err);
            admin.setPassword("");
            return "admin/register";
        }

        adminDao.save(admin);
        return "admin/index";
    }

    @RequestMapping(value = "login")
    public String displaylogin(Model model) {

        model.addAttribute(new Admin());
        model.addAttribute("title", "Login");
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processlogin(Model model, @ModelAttribute @Valid Admin admin, Errors errors) {
        if(errors.hasErrors()){
            model.addAttribute("admin",admin);
            return "admin/login";
        }
        adminDao.save(admin);
        return "admin/home";
    }

    @RequestMapping(value = "home")
    public String index() {

        return "admin/home";
    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "admin/login";
    }

}
