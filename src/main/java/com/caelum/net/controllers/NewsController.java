package com.caelum.net.controllers;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/news")
    public String news (Model model) {
        model.addAttribute("title", "Caelum Networks | Новости");
        Iterable<NewsEntity> news = newsRepository.findAll();
        model.addAttribute("news", news);
        return "news";
    }
}
