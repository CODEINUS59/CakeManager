package com.maskbor.cakemanager.controller;

import com.maskbor.cakemanager.repository.CakeRepository;
import com.maskbor.cakemanager.model.Cake;
import com.maskbor.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CakeController {
    @Autowired
    private CakeService cakeService;

    public void setCakeService(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @RequestMapping(value = "cakes", method = RequestMethod.GET)
    public String listCakes(Model model){
        model.addAttribute("cake", new Cake());
//        model.addAttribute("listCakes", this.cakeService.listCakes());
        return "cakes";
    }

    @RequestMapping(value = "/cakes/add", method = RequestMethod.POST)
    public String addCake(@ModelAttribute("cake") Cake cake){
        if(cake.getId() == 0){
            this.cakeService.saveItem((CakeRepository) cake);
        }else {
            this.cakeService.saveItem((CakeRepository) cake);
        }
        return "redirect:/cakes";
    }

    @RequestMapping("/remove/{id}")
    public String removeCake(@PathVariable("id") int id){
        this.cakeService.removeItem((CakeRepository) cakeService.getItem(id));
        return "redirect:/cakes";
    }

    @RequestMapping("edit/{id}")
    public String editCake(@PathVariable("id") int id, Model model){
        model.addAttribute("cake", this.cakeService.getItem(id));
//        model.addAttribute("listCakes", this.cakeService.listBooks());
        return "cakes";
    }

    @RequestMapping("cakedata/{id}")
    public String cakeData(@PathVariable("id") int id, Model model){
        model.addAttribute("cake", this.cakeService.getItem(id));
        return "cakedata";
    }
}
