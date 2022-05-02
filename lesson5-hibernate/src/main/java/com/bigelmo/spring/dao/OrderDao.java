package com.bigelmo.spring.dao;

import com.bigelmo.spring.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDao implements Dao<Order> {

    private final EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select o from Order o", Order.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();
        try {
            em.remove(findById(id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при удалении: " + e.getMessage());
        }
    }

    @Override
    public Order saveOrUpdate(Order order) {
        em.getTransaction().begin();
        try {
            em.merge(order);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
        return order;
    }
}
