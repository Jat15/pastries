package com.example.pastries.dao;

import com.example.pastries.dao.entity.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PastryDao implements Dao<Pastry> {
    private EntityManager em;
    public PastryDao() {
        em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    }

    @Override
    public Optional<Pastry> get(Long id) {
        Optional <Pastry> pastry = Optional.empty();

        try {
            pastry = Optional.of(em.createQuery("SELECT p FROM Pastry p WHERE p.id = ?1 ", Pastry.class).setParameter(1, id).getSingleResult());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return pastry ;
    }

    public List<Pastry> findByName(String name) {
        List<Pastry> pastries = new ArrayList<>();

        try {
            pastries =  em.createQuery("SELECT p FROM Pastry p WHERE p.name LIKE ?1 ", Pastry.class).setParameter(1, '%' + name + '%').getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

        return pastries;
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
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(pastry);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
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
