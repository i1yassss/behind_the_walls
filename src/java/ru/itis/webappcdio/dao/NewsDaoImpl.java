package ru.itis.webappcdio.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.itis.webappcdio.model.News;

import java.util.List;

/**
 * Created by 1 on 05.05.2017.
 */
@Repository
public class NewsDaoImpl implements NewsDao {

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void addNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(news);
    }

    @Override
    public void updateNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(news);
    }

    @Override
    public void removeNews(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Long(id));

        if (news!=null){
            session.delete(news);
        }
    }

    @Override
    public News getNewsByID(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Long(id));
        return news;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> listNews() {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "FROM ru.itis.webappcdio.model.News";
        List<News> newsList = session.createQuery(hql).list();
        return newsList;
    }
}
