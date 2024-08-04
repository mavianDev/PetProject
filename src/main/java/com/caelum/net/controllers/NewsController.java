package com.caelum.net.controllers;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.repositories.NewsRepository;
import com.caelum.net.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllArticles(Model model) {
        model.addAttribute("articles", service.getAllArticles());
        return "news/list";
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        NewsEntity newsEntity = service.getArticleById(id);
        model.addAttribute("article", service.getArticleById(id));
        return "news/detail";
    }
}