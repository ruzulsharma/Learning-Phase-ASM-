package com.practice.ecomm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.practice.ecomm.model.Order;
import com.practice.ecomm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/orders")
    public class OrderController {
        @Autowired
        private OrderService orderService;

        @GetMapping
        public List<Order> getAllOrders() {
            return orderService.getAllOrders();
        }

        @GetMapping("/{id}")
        public Order getOrderById(@PathVariable String id) {
            return orderService.getOrderById(id);
        }

        @PostMapping
        public Order createOrder(@RequestBody Order order) {
            if (order.getOrderDate() == null) {
                order.setOrderDate(new Date()); // Using java.util.Date for simplicity, consider using java.time.LocalDateTime
            }
            return orderService.createOrder(order);


        }

        @PutMapping("/{id}")
        public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
            return orderService.updateOrder(id, order);
        }

        @DeleteMapping("/{id}")
        public void deleteOrder(@PathVariable String id) {
            orderService.deleteOrder(id);
        }
    }






