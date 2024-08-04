package com.caelum.net.controllers;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class AdminController {
    private final NewsService service;

    @Autowired
    public AdminController(NewsService service) {
        this.service = service;
    }

    @GetMapping("/admin-panel-of-caelum-network")
    public String adminPanel (Model model) {
        model.addAttribute("title", "Caelum | Администрация");
        return "admin/admin-page";
    }

    @GetMapping
    public String getAllArticles(Model model) {
        model.addAttribute("articles", service.getAllArticles());
        return "admin/news-settings";
    }

    @GetMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new NewsEntity());
        return "admin/news-create";
    }

    @PostMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String createArticle(@ModelAttribute NewsEntity article) {
        article.setCreatedAt(LocalDateTime.now());
        service.saveArticle(article);
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-network";
    }

    @PostMapping("/admin-panel-of-caelum-network/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        service.deleteArticle(id);
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-network";
    }

    @GetMapping("/admin-panel-of-caelum-network/news-settings-on-caelum-networks")
    public String newsSettings (Model model) {
        model.addAttribute("title", "Caelum Networks | Настройки новостей");
        Iterable<NewsEntity> news = service.getAllArticles();
        model.addAttribute("article", service);
        return "admin/news-settings";
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        NewsEntity newsEntity = service.getArticleById(id);
        model.addAttribute("article", service.getArticleById(id));
        return "news/detail";
    }

}
