package com.bigelmo.spring.lesson4springboot.market;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductJpaRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
