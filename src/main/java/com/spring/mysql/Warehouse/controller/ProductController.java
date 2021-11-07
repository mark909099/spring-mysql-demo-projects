package com.spring.mysql.Warehouse.controller;

import com.spring.mysql.Warehouse.entity.Product;
import com.spring.mysql.Warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/warehouse")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("products")
    public ResponseEntity list() {
        try {
            List<Product> products = productService.listAllProducts();
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("products")
    public ResponseEntity add(@RequestBody Product product) {
        try {
            productService.addProduct(product);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("products/{id}")
    public ResponseEntity<HttpStatus> edit(@PathVariable Integer id, @RequestBody Product product ) {
        try {
            Product currentProduct = productService.getProduct(id);
            currentProduct.setQuantity(product.getQuantity());
            productService.saveProduct(currentProduct);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
