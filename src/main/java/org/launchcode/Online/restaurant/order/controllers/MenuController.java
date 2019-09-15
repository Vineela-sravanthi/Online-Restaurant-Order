package org.launchcode.Online.restaurant.order.controllers;

import org.launchcode.Online.restaurant.order.models.Menu;
import org.launchcode.Online.restaurant.order.models.data.MenuDao;
import org.launchcode.Online.restaurant.order.models.data.CategoryDao;
import org.launchcode.Online.restaurant.order.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
@RequestMapping("menu")
public class MenuController {


    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value="")
    public String index(Model model){


        model.addAttribute("items", menuDao.findAll());

        model.addAttribute("title","Thai Restaurant Menu");
        return "menu/index";

    }

    @RequestMapping(value="usermenu")
    public String displaymenu(Model model){


        model.addAttribute("items", menuDao.findAll());

        model.addAttribute("title","Thai Restaurant Menu");
        return "menu/usermenu";

    }


    @RequestMapping(value="adminmenu")
    public String displayadmenu(Model model){


        model.addAttribute("items", menuDao.findAll());

        model.addAttribute("title","Thai Restaurant Menu");
        return "menu/adminmenu";

    }

    @RequestMapping(value="add" ,method= RequestMethod.GET)
    public String displayAddItemForm(Model model){
        model.addAttribute("title","Add Item");
        model.addAttribute(new Menu());
        model.addAttribute("categories", categoryDao.findAll());
        return "menu/add";
    }
    @RequestMapping(value="add" ,method= RequestMethod.POST)
    public String processAddItemForm(@ModelAttribute @Valid Menu newItem , Errors errors,@RequestParam int categoryId, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title","Add Item");
            return "menu/add";
        }
        Category cat = categoryDao.findOne(categoryId);
        newItem.setCategory(cat);
        menuDao.save(newItem);
        return "redirect:";

    }
    @RequestMapping(value="remove" ,method= RequestMethod.GET)
    public String removeItem(Model model) {
        model.addAttribute("items", menuDao.findAll());
        model.addAttribute("title", "Remove Cheese");

        return "menu/remove";
    }
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] itemIds){


        for (int itemId : itemIds) {
            menuDao.delete(itemId);
        }

        return "redirect:";
    }

}



