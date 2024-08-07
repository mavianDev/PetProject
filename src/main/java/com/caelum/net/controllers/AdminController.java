package com.caelum.net.controllers;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class AdminController {
    private final NewsService service;

    @Autowired
    public AdminController (NewsService service) {
        this.service = service;
    }

    @GetMapping("/admin-panel-of-caelum-network")
    public String adminPanel (Model model) {
        model.addAttribute("title", "Caelum | Администрация");
        return "admin/admin-page";
    }

    @GetMapping("/admin-panel-of-caelum-network/news-settings-on-caelum-networks")
    public String getAllArticles (Model model) {
        model.addAttribute("articles", service.getAllArticles());
        return "admin/news-settings";
    }

    @GetMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String showCreateForm (Model model) {
        model.addAttribute("article", new NewsEntity());
        model.addAttribute("title", "Caelum Networks | Создание новости");
        return "admin/news-create";
    }

    @PostMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String createArticle (Model model, @ModelAttribute NewsEntity article) {
        article.setCreatedAt(LocalDateTime.now());
        service.saveArticle(article);
        model.addAttribute("title", "Caelum Networks | Создание новости");
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-networks";
    }

    @GetMapping("/admin-panel-of-caelum-network/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<NewsEntity> article = Optional.ofNullable(service.getArticleById(id));
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return "admin/news-edit";
        } else {
            return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-networks";
        }
    }

    @PostMapping("/admin-panel-of-caelum-network/edit/{id}")
    public String updateNews(@PathVariable Long id, @ModelAttribute NewsEntity updatedArticle) {
        Optional<NewsEntity> article = Optional.ofNullable(service.getArticleById(id));
        if (article.isPresent()) {
            NewsEntity existingArticle = article.get();
            existingArticle.setTitle(updatedArticle.getTitle());
            existingArticle.setShortDesc(updatedArticle.getShortDesc());
            existingArticle.setContent(updatedArticle.getContent());
            existingArticle.setImgUrl(updatedArticle.getImgUrl());
            service.saveArticle(existingArticle);
        }
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-networks";
    }

    @PostMapping("/admin-panel-of-caelum-networks/delete/{id}")
    public String deleteArticle (Model model, @PathVariable Long id) {
        service.deleteArticle(id);
        model.addAttribute("title", "Caelum Networks | Создание новости");
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-networks";
    }

    // Disabled method
    /* @GetMapping("/admin-panel-of-caelum-network/news-settings-on-caelum-network")
    public String newsSettings (Model model) {
        model.addAttribute("title", "Caelum Networks | Настройки новостей");
        Iterable<NewsEntity> news = service.getAllArticles();
        model.addAttribute("article", service);
        return "admin/news-settings";
    } */
}
