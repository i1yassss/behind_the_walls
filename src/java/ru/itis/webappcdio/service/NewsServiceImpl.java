package ru.itis.webappcdio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.webappcdio.dao.NewsDao;
import ru.itis.webappcdio.model.News;

import java.util.List;

/**
 * Created by 1 on 05.05.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    @Transactional
    public void addNews(News news) {
        this.newsDao.addNews(news);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        this.newsDao.updateNews(news);
    }

    @Override
    @Transactional
    public void removeNews(Long id) {
        this.newsDao.removeNews(id);
    }

    @Override
    @Transactional
    public News getNewsById(Long id) {
        return this.newsDao.getNewsByID(id);
    }

    @Override
    @Transactional
    public List<News> listNews() {
        return this.newsDao.listNews();
    }
}
