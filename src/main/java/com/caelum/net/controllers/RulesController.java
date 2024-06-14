package com.caelum.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RulesController {
    @GetMapping("/rules")
    public String rulesPage (Model model) {
        model.addAttribute("title", "Caelum Networks | Правила");
        return "rules";
    }
}
