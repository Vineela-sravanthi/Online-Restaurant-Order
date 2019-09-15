package org.launchcode.Online.restaurant.order.controllers;

import org.launchcode.Online.restaurant.order.models.OrderCart;
import org.launchcode.Online.restaurant.order.models.data.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value="view", method= RequestMethod.GET)
    public String viewcart(Model model) {
        model.addAttribute("orders", orderDao.findAll());
        model.addAttribute("title", "View Order");
        return "order/view";
    }

    @RequestMapping(value="view", method= RequestMethod.POST)
    public String processcart() {

        return "order/placeorder";

    }

    @RequestMapping(value="add" ,method= RequestMethod.GET)
    public String displayAddcart(Model model){
        model.addAttribute("title","Add to cart");
        model.addAttribute(new OrderCart());
        return "order/add";
    }

    @RequestMapping(value="add" ,method= RequestMethod.POST)
    public String processAddcart(@ModelAttribute @Valid OrderCart newOrder , Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add to cart");
            return "order/add";
        }
        orderDao.save(newOrder);
        model.addAttribute("orders", orderDao.findAll());
        return "order/view";

    }
}