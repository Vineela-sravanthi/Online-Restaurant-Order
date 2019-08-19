package org.launchcode.Online.restaurant.order.controllers;

import org.launchcode.Online.restaurant.order.models.User;
import org.launchcode.Online.restaurant.order.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "register")
    public String displayregister(Model model) {

            model.addAttribute(new User());
            model.addAttribute("title","Register");
            return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processregister(Model model, @ModelAttribute @Valid User user, Errors errors, String verify){
            if(errors.hasErrors()){
                model.addAttribute("user",user);
                return "user/register";
            }

            if((user.getPassword()== null) || verify == null || (!user.getPassword().equals(verify))) {
                String err = "Passwords Don't match";
                model.addAttribute("verify",err);
                user.setPassword("");
                return "user/register";
            }

            userDao.save(user);
            return "user/index";
        }

    @RequestMapping(value = "login")
    public String displaylogin(Model model) {

        model.addAttribute(new User());
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processlogin(Model model, @ModelAttribute @Valid User user, Errors errors) {
        if(errors.hasErrors()){
            model.addAttribute("user",user);
            return "user/login";
        }
        userDao.save(user);
        return "user/home";
    }

    @RequestMapping(value = "home")
    public String index() {

        return "user/home";
    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "user/login";
    }

}
