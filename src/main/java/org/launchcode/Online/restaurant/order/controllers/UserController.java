package org.launchcode.Online.restaurant.order.controllers;

import org.launchcode.Online.restaurant.order.models.forms.User;
import org.launchcode.Online.restaurant.order.models.data.UserDao;
import org.launchcode.Online.restaurant.order.services.SecurityService;
import org.launchcode.Online.restaurant.order.services.UserService;
import org.launchcode.Online.restaurant.order.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "register")
    public String displayregister(Model model) {

        model.addAttribute(new User());
        model.addAttribute("registerForm", new User());
        model.addAttribute("title", "Register");
        return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registration(HttpSession session, @ModelAttribute("registerForm") User userForm,
                               BindingResult bindingResult){

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/register";
        }

        String password = userForm.getPassword();
        userForm.setActive(Boolean.TRUE);
        userService.save(userForm);
        securityService.login(userForm.getEmail(), password);
        session.setAttribute("userName", userForm.getEmail());

        return "user/index";
    }

    @RequestMapping(value = "login")
    public String displaylogin(Model model) {

        model.addAttribute("userForm",new User());
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String authenticate(HttpSession session, @ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult) {

        userValidator.validateLoginInfo(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        securityService.login(userForm.getEmail(), userForm.getPassword());
        session.setAttribute("userName", userForm.getEmail());
        return "user/home";
    }

    @RequestMapping(value = "home")
    public String index() {

        return "user/home";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session, Model model) {
        securityService.logout();
        session.removeAttribute("userName");
        {
            return "user/login";
        }

    }
}
