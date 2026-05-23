package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /* =====================
       HOMEPAGE
    ===================== */
    @GetMapping("/")
    public String home(Model model) {

        List<Article> articles = articleService.getAllArticles();

        model.addAttribute("articles", articles);

        return "index";
    }

    /* =====================
       SINGLE ARTICLE PAGE
    ===================== */
    @GetMapping("/article/{id}")
    public String articlePage(@PathVariable Long id, Model model) {

        List<Article> articles = articleService.getAllArticles();

        Article foundArticle = articles.stream()
                .filter(article -> article.getId() != null && article.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundArticle == null) {
            return "redirect:/";
        }

        model.addAttribute("article", foundArticle);

        return "article";
    }

    /* =====================
       ADMIN DASHBOARD
    ===================== */
    @GetMapping("/admin")
    public String dashboard(Model model) {

        List<Article> articles = articleService.getAllArticles();

        model.addAttribute("articles", articles);

        return "admin/dashboard";
    }

    /* =====================
       SHOW CREATE PAGE
    ===================== */
    @GetMapping("/admin/create")
    public String createPage() {
        return "admin/create";
    }

    /* =====================
       CREATE ARTICLE
    ===================== */
    @PostMapping("/admin/create")
    public String createArticle(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String imageUrl
    ) {

        List<Article> articles = articleService.getAllArticles();

        Long newId = (long) (articles.size() + 1);

        Article newArticle = new Article(
                newId,
                title,
                "May 22, 2026",
                content,
                imageUrl
        );

        articles.add(newArticle);

        articleService.saveArticles(articles);

        return "redirect:/admin";
    }

    /* =====================
       DELETE ARTICLE
    ===================== */
    @GetMapping("/admin/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {

        List<Article> articles = articleService.getAllArticles();

        articles.removeIf(a -> a.getId().equals(id));

        articleService.saveArticles(articles);

        return "redirect:/admin";
    }

    /* =====================
       SHOW EDIT PAGE
    ===================== */
    @GetMapping("/admin/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {

        Article article = articleService.getAllArticles()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("article", article);

        return "admin/edit";
    }

    /* =====================
       UPDATE ARTICLE
    ===================== */
    @PostMapping("/admin/edit/{id}")
    public String updateArticle(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String imageUrl
    ) {

        List<Article> articles = articleService.getAllArticles();

        for (Article a : articles) {
            if (a.getId().equals(id)) {
                a.setTitle(title);
                a.setContent(content);
                a.setImageUrl(imageUrl);
                break;
            }
        }

        articleService.saveArticles(articles);

        return "redirect:/admin";
    }
}