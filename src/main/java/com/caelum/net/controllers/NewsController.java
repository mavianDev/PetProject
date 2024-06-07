package com.caelum.net.controllers;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String newsAdd (Model model) {
        model.addAttribute("title", "Caelum Networks | Создание новости");
        return "create-news";
    }

    @PostMapping("/admin-panel-of-caelum-network/create-new-news-on-caelum-networks")
    public String newsCreatePost (@RequestParam String title, @RequestParam String shortDesc, @RequestParam String fullText, Model model) {
        NewsEntity newsEntity = new NewsEntity(title, shortDesc, fullText);
        newsRepository.save(newsEntity);
        return "redirect:/news";
    }

    @GetMapping("/admin-panel-of-caelum-network/news-settings-on-caelum-networks")
    public String newsSettings (Model model) {
        model.addAttribute("title", "Caelum Networks | Настройки новостей");
        return "news-settings";
    }

    @PostMapping("/admin-panel-of-caelum-network/news-settings-on-caelum-networks")
    public String showNewsInSettings (@RequestParam String title, @RequestParam String shortDesc, @RequestParam String fullText, Model model) {
        NewsEntity newsEntity = new NewsEntity(title, shortDesc, fullText);
        newsRepository.save(newsEntity);
        return "redirect:/admin-panel-of-caelum-network/news-settings-on-caelum-networks";
    }
}
