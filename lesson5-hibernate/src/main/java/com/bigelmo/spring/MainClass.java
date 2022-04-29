package com.bigelmo.spring;

import com.bigelmo.spring.model.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = emFactory.createEntityManager();
        ProductDao pdao = new ProductDao(em);

        Scanner sc = new Scanner(System.in);
        boolean trigger = true;

        while (trigger) {
            System.out.println("Введите команду: (exit, find, all, new, delete, update)");
            String command = sc.nextLine();

            switch (command) {
                case ("exit"):
                    trigger = false;
                    break;

                case ("find"):
                    System.out.println("Введите id для поиска");
                    System.out.println(pdao.findById(Long.valueOf(sc.nextLine())));
                    break;

                case ("all"):
                    for (Product product : pdao.findAll()) {
                        System.out.println(product);
                    }
                    break;

                case ("new"):
                    System.out.println("Введите наименование:");
                    String name = sc.nextLine();
                    System.out.println("Введите стоимость");
                    int price = Integer.parseInt(sc.nextLine());
                    pdao.saveOrUpdate(new Product(name, price));
                    break;

                case ("update"):
                    System.out.println("Введите id товара для изменения:");
                    Product product = pdao.findById(Long.valueOf(sc.nextLine()));
                    System.out.println("Введите новое наименование:");
                    product.setName(sc.nextLine());
                    System.out.println("Введите новую стоимость");
                    product.setPrice(Integer.parseInt(sc.nextLine()));
                    pdao.saveOrUpdate(product);
                    break;

                case ("delete"):
                    System.out.println("Введите id товара для удаления:");
                    pdao.deleteById(Long.valueOf(sc.nextLine()));

                default:
                    break;
            }
        }
        em.close();
        emFactory.close();
    }
}
