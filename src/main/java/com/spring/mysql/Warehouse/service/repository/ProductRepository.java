package com.spring.mysql.Warehouse.service.repository;

import com.spring.mysql.Warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
