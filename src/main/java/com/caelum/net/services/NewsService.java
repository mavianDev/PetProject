package com.caelum.net.services;

import com.caelum.net.entities.NewsEntity;
import com.caelum.net.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository repository;

    @Autowired
    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<NewsEntity> getAllArticles() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public NewsEntity getArticleById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public NewsEntity saveArticle(NewsEntity article) {
        return repository.save(article);
    }

    public void deleteArticle(Long id) {
        repository.deleteById(id);
    }
}
