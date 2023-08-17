package by.dao;

import by.entity.Review;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class ReviewDao extends AbstractEntityDao{
    public List<Review> getList() {
        List<Review> ReviewList;
        Session session = getSessionFactory().openSession();
        ReviewList = session.createQuery("FROM Review ").list();
        session.close();
        return ReviewList;
    }
}
