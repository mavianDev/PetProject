package com.caelum.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main (Model model) {
        model.addAttribute("title", "Caelum Networks | Главная");
        return "main";
    }

    @GetMapping("/shop")
    public String shop (Model model) {
        model.addAttribute("title", "Caelum Networks | Магазин");
        return "shop";
    }

    @GetMapping("/news")
    public String news (Model model) {
        model.addAttribute("title", "Caelum Networks | Новости");
        return "news";
    }

    @GetMapping("/about-us")
    public String aboutUs (Model model) {
        model.addAttribute("title", "Caelum Networks | О нас");
        return "about-us";
    }

    @GetMapping("/founders")
    public String founders (Model model) {
        model.addAttribute("title", "Caelum Networks | Создатели");
        return "founders";
    }

    @GetMapping("/partners")
    public String partners (Model model) {
        model.addAttribute("title", "Caelum Networks | Наши Партнёры");
        return "partners";
    }

}
