package ru.itis.webappcdio.service;

import ru.itis.webappcdio.model.News;

import java.util.List;

/**
 * Created by 1 on 05.05.2017.
 */
public interface NewsService {

    void addNews(News news);

    void updateNews(News news);

    void removeNews(Long id);

    News getNewsById(Long id);


    List<News> listNews();

}
