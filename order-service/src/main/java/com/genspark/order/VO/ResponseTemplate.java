package com.genspark.order.VO;

import com.genspark.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private Order order;
    private List<Product> products;
}
