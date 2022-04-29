package com.bigelmo.spring;

import com.bigelmo.spring.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao implements Dao<Product> {

    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("from Product p", Product.class)
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
    public Product saveOrUpdate(Product product) {
        em.getTransaction().begin();
        try {
            em.merge(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
        return product;
    }
}
