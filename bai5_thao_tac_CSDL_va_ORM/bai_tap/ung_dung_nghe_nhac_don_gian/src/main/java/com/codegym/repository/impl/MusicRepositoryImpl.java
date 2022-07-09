package com.codegym.repository.impl;


import com.codegym.entity.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements IMusicRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Modifying
    @Override
    public void create(Music music) {
        entityManager.persist(music);
    }

    @Modifying
    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Modifying
    @Override
    public void delete(String id) {
        Music music = findById(id);
        entityManager.remove(music);
    }

    @Override
    public List<Music> findAll() {
        // HQL
        List<Music> musicList = entityManager.createQuery("SELECT m from Music m").getResultList();
        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return musicList;
    }

    @Override
    public Music findById(String name) {
//        return entityManager.find(Music.class, name);
        TypedQuery<Music> query = entityManager.createQuery("select m from Music m where m.name=?1", Music.class);
        query.setParameter(1, name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
