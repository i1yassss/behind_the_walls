package ru.itis.webappcdio.dao;

import ru.itis.webappcdio.model.News;

import java.util.List;

/**
 * Created by 1 on 05.05.2017.
 */
public interface NewsDao {

    public void addNews(News news);
    public void updateNews(News news);
    public void removeNews(Long id);

    public News getNewsByID(Long id);

    public List<News> listNews();

}
