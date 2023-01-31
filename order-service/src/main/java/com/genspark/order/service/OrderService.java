package com.genspark.order.service;

import com.genspark.order.VO.Product;
import com.genspark.order.VO.ResponseTemplate;
import com.genspark.order.entity.Order;
import com.genspark.order.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Order selectOrderById(int id) {
        return orderRepo.findByOrderId(id);
    }
//
//    public List<Order> selectOrders() {
//        return orderRepo.findAll();
//    }

    public Order addOrder(Order order) {
//        for(Order i : order) {
//            i.setOrderId(a.get(a.size() -1) + 1);
//            orderRepo.save(i);
//        }
        if(!(findAllOrders().size() > 0)) {
            order.setOrderId(1);
        } else {
            order.setOrderId(findAllOrders().get(findAllOrders().size() -1).getOrderId() + 1);
        }
        order.setOrderDate(Date.valueOf(LocalDate.now()).toString());
        order.setOrderStatus("Processing");
        return orderRepo.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(int id, Order order) {
        Order o = orderRepo.findByOrderId(id);
//        for(int k = 0; k < order.size(); k++) {
//            if (o.listIterator().hasNext()){
//                o.get(k).setOrderDate(order.get(k).getOrderDate());
//                o.get(k).setOrderProdId(order.get(k).getOrderProdId());
//                orderRepo.save(o.get(k));
//            }
//            else {
//                o.add(order.get(k));
//                orderRepo.save(o.get(k));
//            }
//        }
        if((order.getOrderProdIds() != null) && !(order.getOrderProdIds().equals(o.getOrderProdIds()))){
            o.setOrderProdIds(order.getOrderProdIds());
        }
        if((order.getOrderStatus() != null) && (order.getOrderStatus() != o.getOrderStatus())){
            o.setOrderStatus(order.getOrderStatus());
        }
        orderRepo.save(o);
        return o;
    }

    public Order deleteOrder(int id) {
        Order o = orderRepo.findByOrderId(id);
//        for(Order h: o) {
//            orderRepo.delete(h);
//        }
        orderRepo.delete(o);
        return o;
    }

    public ResponseTemplate selectOrderByIdWithProducts(int id) {
        ResponseTemplate vo = new ResponseTemplate();
        List<Product> prods = new ArrayList<Product>();
        Order ord = orderRepo.findByOrderId(id);
        for(Integer d : ord.getOrderProdIds()) {
            Product p = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + d, Product.class);
            prods.add(p);
        }
        vo.setOrder(ord);
        vo.setProducts(prods);
        return vo;
    }

    public List<ResponseTemplate> selectOrdersWithProducts() {
        List<ResponseTemplate> voL = new ArrayList<ResponseTemplate>();
        List<Order> a = findAllOrders();
//        for(Order o : orderRepo.findAll()) {
//            s.add(o.getOrderId());
//        }
//        for(Integer id : s) {
//            a.add(id);
//        }
        for(int x = 0; x < a.size(); x++) {
            ResponseTemplate vo = new ResponseTemplate();
            List<Product> prods = new ArrayList<Product>();
            Order ord = orderRepo.findByOrderId(a.get(0).getOrderId());
            for(Integer d : ord.getOrderProdIds()) {
                Product p = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + d, Product.class);
                prods.add(p);
            }

            vo.setOrder(ord);
            vo.setProducts(prods);
            voL.add(vo);
        }
        return voL;
    }

//    public Order selectOrderByIds(int oId, int pId) {
//        List<Order> ord = orderRepo.findByOrderId(oId);
//        Order e = new Order();
//        for(Order g : ord) {
//            if(g.getProdId() == pId) {
//                e = g;
//            }
//        }
//        return e;
//    }

//    public ResponseTemplate selectOrderByIdWithProduct(int oId, int pId) {
//        ResponseTemplate r = new ResponseTemplate();
//        List<Order> ord = orderRepo.findByOrderId(oId);
//        List<Order> e = new ArrayList<>();
//        List<Product> p = new ArrayList<>();
//        for(Order g : ord) {
//            if(g.getOrderProdId() == pId) {
//                e.add(g);
//                Product prod = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + g.getOrderProdId(), Product.class);
//                p.add(prod);
//            }
//        }
//        r.setProduct(p);
//        r.setOrder(e);
//        return r;
//    }
}
