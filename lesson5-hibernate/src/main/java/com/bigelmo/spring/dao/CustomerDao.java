package com.bigelmo.spring.dao;

import com.bigelmo.spring.model.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDao implements Dao<Customer> {
    private final EntityManager em;

    public CustomerDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class)
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
    public Customer saveOrUpdate(Customer customer) {
        em.getTransaction().begin();
        try {
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
        return customer;
    }
}
