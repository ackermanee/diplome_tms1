package by.dao;

import by.entity.Orders;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class OrdersDao extends AbstractEntityDao{
    public List<Orders> getList() {
        List<Orders> OrdersList;
        Session session = getSessionFactory().openSession();
        OrdersList = session.createQuery("FROM Orders ").list();
        session.close();
        return OrdersList;
    }
}
