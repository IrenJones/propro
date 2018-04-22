package com.jcg.examples.controller;

import com.jcg.examples.model.Item;
import com.jcg.examples.service.CartService;
import com.jcg.examples.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/show_items", method = RequestMethod.GET)
    public ModelAndView showTransactions() {
        ModelAndView m = new ModelAndView("showItems");
        List<Item> itemsList;
        try {
            itemsList = itemService.selectAll();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            m.addObject("error", e.getMessage());
            return m;
        }
        m.addObject("items",itemsList);
        return m;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ModelAndView addItem() {
        return new ModelAndView("addItem");
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String addItem(Model m, @ModelAttribute("item") Item item) {
        try {
            itemService.save(item);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            m.addAttribute("error", e.getMessage());
            return "addItem";
        }
        return "redirect:/show_items";
    }

    @RequestMapping(value = "/update_item/{id}", method = RequestMethod.GET)
    public ModelAndView updateByAdmin(@PathVariable("id") long id) {
        ModelAndView m = new ModelAndView("updateItem");
        Item item = itemService.findById(id);
        m.addObject("item", item);
        return m;
    }

    @RequestMapping(value = "/update_item/{id}", method = RequestMethod.POST)
    public String submitUpdateByAdmin(Model m, @ModelAttribute("item") Item item) {
        try {
            itemService.update(item);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            m.addAttribute("error", e.getMessage());
            m.addAttribute("item", item);
            return "redirect:/show_items";
        }
        return "redirect:/show_items";
    }

    @RequestMapping(value = "/delete_item/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") long id ) {
        try {
            itemService.deleteById(id);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return "redirect:/show_items";
        }
        return "redirect:/show_items";
    }
}

