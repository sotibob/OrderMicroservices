package com.genspark.product.service;

import com.genspark.product.entity.Product;
import com.genspark.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product) {
        if(!(selectProducts().size() > 0)) {
            product.setProdId(1);
        } else {
            int val = selectProducts().size() - 1;
            int id = selectProducts().get(val).getProdId() + 1;
            product.setProdId(id);
            product.setProdQuantity(0);
        }
        return productRepo.save(product);
    }

    public Product selectProductById(int id) {
        return productRepo.findByProdId(id);
    }

    public List<Product> selectProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(int id, Product product) {
        Product p = selectProductById(id);
        if((product.getProdName() != null) && (product.getProdName() != p.getProdName())){
            p.setProdName(product.getProdName());
        }
        if((product.getProdBrand() != null) && (product.getProdBrand() != p.getProdBrand())){
            p.setProdBrand(product.getProdBrand());
        }
        if((product.getProdDesc() != null) && (product.getProdDesc() != p.getProdDesc())){
            p.setProdDesc(product.getProdDesc());
        }
        if((product.getProdQuantity() != null) && (product.getProdQuantity() != p.getProdQuantity())){
            p.setProdQuantity(product.getProdQuantity());
        }
        if((product.getProdPrice() != null) && (product.getProdPrice() != p.getProdPrice())){
            p.setProdPrice(product.getProdPrice());
        }
        if((product.getProdImg() != null) && (product.getProdImg() != p.getProdImg())){
            p.setProdImg(product.getProdImg());
        }
        return productRepo.save(p);
    }

    public Product deleteProduct(int id) {
        Product p = selectProductById(id);
        productRepo.delete(p);
        return p;
    }

    public Product selectProductByName(String name) {
        return productRepo.findByProdName(name);
    }
}
