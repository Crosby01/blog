package com.example.blog.service;

import com.example.blog.model.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final String FILE_PATH =
            "src/main/resources/data/articles.json";

    private final ObjectMapper objectMapper =
            new ObjectMapper();

    /* GET ALL ARTICLES */

    public List<Article> getAllArticles() {

        try {

            File file = new File(FILE_PATH);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            return objectMapper.readValue(
                    file,
                    new TypeReference<List<Article>>() {}
            );

        } catch (IOException e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    /* SAVE ARTICLES */

    public void saveArticles(List<Article> articles) {

        try {

            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            new File(FILE_PATH),
                            articles
                    );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}