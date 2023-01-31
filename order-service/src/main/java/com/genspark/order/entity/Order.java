package com.genspark.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private int orderId;
    @ElementCollection
    private List<Integer> orderProdIds;
    private String orderDate;
    private String orderStatus;
}
