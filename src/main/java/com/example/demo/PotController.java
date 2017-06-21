package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class PotController {

    @Autowired
    PotRepository potRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("potItem", new PotItem());
        return "index";
    }

    @PostMapping("/givePot")
    public String getPot(@Valid PotItem potItem, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        potRepository.save(potItem);

        model.addAttribute("list", potRepository.findAll());
        model.addAttribute("name", potItem.getName());

        return "gavePot";
    }

}
