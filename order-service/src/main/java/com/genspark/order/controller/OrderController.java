package com.genspark.order.controller;

import com.genspark.order.VO.ResponseTemplate;
import com.genspark.order.entity.Order;
import com.genspark.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<ResponseTemplate> selectOrdersWithProducts() {
        return orderService.selectOrdersWithProducts();
    }

    @GetMapping("/{id}")
    public ResponseTemplate selectOrderByIdWithProducts(@PathVariable("id") int id) {
        return orderService.selectOrderByIdWithProducts(id);
    }

//    @GetMapping("/{oId}/{pId}")
//    public ResponseTemplate selectOrderByIdWithProduct(@PathVariable("oId") int oId, @PathVariable("pId") int pId) {
//        return orderService.selectOrderByIdWithProduct(oId, pId);
//    }

//    @GetMapping("/reg/{id}")
//    public List<Order> selectOrderById(@PathVariable("id") int id) {
//        return orderService.selectOrderById(id);
//    }
//
//    @GetMapping("/reg/{oId}/{pId}")
//    public Order selectOrderByIds(@PathVariable("id") int oId, @PathVariable("pId") int pId) {
//        return orderService.selectOrderByIds(oId, pId);
//    }
//
//    @GetMapping("/reg")
//    public List<Order> selectOrders() {
//        return orderService.selectOrders();
//    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public Order deleteOrder(@PathVariable("id") int id) {
        return orderService.deleteOrder(id);
    }
}
