package com.genspark.order.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int prodId;
    private String prodName;
    private String prodBrand;
    private String prodDesc;
    private double prodPrice;
    private String prodImg;
}
