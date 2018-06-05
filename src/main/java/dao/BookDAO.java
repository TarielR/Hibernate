package dao;

import models.BookEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class BookDAO {

    public BookEntity findById(Long id) {
        Session session = HibernateUtils.getSession();
        //session.beginTransaction();

        BookEntity book = session.get(BookEntity.class, id);

        if (session != null && session.isOpen()) {
            session.close();
        }
        return book;
    }

    public List<BookEntity> findAll() {
        Session session = HibernateUtils.getSession();

        List<BookEntity> books;
        Query query = session.createQuery("from " + BookEntity.class.getName());
        books = query.list();

        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

    public void create(BookEntity book) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void update(BookEntity book) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.update(book);

        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void delete(BookEntity book) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.delete(book);

        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
