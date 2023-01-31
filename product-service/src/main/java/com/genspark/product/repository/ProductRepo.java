package com.genspark.product.repository;

import com.genspark.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findByProdId(int id);

    Product findByProdName(String name);
}
