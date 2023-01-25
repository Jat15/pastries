package com.example.pastries.dao;

import com.example.pastries.dao.entity.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class PastryDao implements Dao<Pastry> {
    private EntityManager em;
    public PastryDao() {
        em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    }

    @Override
    public Pastry get(Long id) {
        return em.createQuery("SELECT p FROM Pastry p WHERE p.id = ?1 ", Pastry.class).setParameter(1, id).getSingleResult();
    }

    public List<Pastry> findByName(String name) {
        return em.createQuery("SELECT p FROM Pastry p WHERE p.name LIKE ?1 ", Pastry.class).setParameter(1, '%' + name + '%').getResultList();
    }

    @Override
    public List<Pastry> getAll() {
        List<Pastry> pastries = new ArrayList<>();

        try {
            pastries =  em.createQuery("select p from Pastry  p", Pastry.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

        return pastries;
    }

    @Override
    public void create(Pastry pastry) {
        try {
            em.getTransaction().begin();
            em.persist(pastry);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Pastry pastry) {

    }

    @Override
    public void delete(Pastry pastry) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(pastry) ? pastry : em.merge(pastry));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

        } finally {
            em.close();
        }
    }

}
