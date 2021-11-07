package com.spring.mysql.Warehouse.service;

import com.spring.mysql.Warehouse.entity.Product;
import com.spring.mysql.Warehouse.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts() { return productRepository.findAll(); }

    public void addProduct(Product product) { productRepository.save(product); }

    public Product getProduct(Integer id) { return productRepository.getById(id); }

    public void saveProduct(Product product) { productRepository.save(product); }

    public void deleteProduct(Integer id) { productRepository.deleteById(id); }
}
