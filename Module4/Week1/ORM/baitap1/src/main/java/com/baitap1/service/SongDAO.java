package com.baitap1.service;

import com.baitap1.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public SongDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Song song) {
        Session session = sessionFactory.getCurrentSession();
        session.save(song);
    }

    public List<Song> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Song", Song.class).list();
    }

    public Song getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Song.class, id);
    }

    public void update(Song song) {
        Session session = sessionFactory.getCurrentSession();
        session.update(song);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Song song = session.get(Song.class, id);
        if (song != null) {
            session.delete(song);
        }
    }
}
