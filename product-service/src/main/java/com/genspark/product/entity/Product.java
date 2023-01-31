package com.genspark.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private String prodBrand;
    private String prodDesc;
    private Integer prodQuantity;
    private Double prodPrice;
    private String prodImg;
}
