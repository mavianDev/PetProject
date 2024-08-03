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
    private NewsService service;

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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new NewsEntity());
        return "news/create";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute NewsEntity article) {
        article.setCreatedAt(LocalDateTime.now());
        service.saveArticle(article);
        return "redirect:/news";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        service.deleteArticle(id);
        return "redirect:/news";
    }
}