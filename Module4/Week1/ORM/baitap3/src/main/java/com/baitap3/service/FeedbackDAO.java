package com.baitap3.service;

import com.baitap3.model.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class FeedbackDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public FeedbackDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Feedback feedback) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(feedback);
    }

    public List<Feedback> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Feedback", Feedback.class).getResultList();
    }

    public Feedback findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Feedback.class, id);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Feedback feedback = session.byId(Feedback.class).load(id);
        if (feedback != null) {
            session.delete(feedback);
        }
    }
}
