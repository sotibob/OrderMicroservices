package com.genspark.product.controller;

import com.genspark.product.entity.Product;
import com.genspark.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") int id) {
        return productService.selectProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product selectProductByName(@PathVariable("name") String name) {
        return productService.selectProductByName(name);
    }

    @GetMapping("/")
    public List<Product> selectProducts() {
        return productService.selectProducts();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }
}
