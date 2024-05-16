package com.practice.ecomm.controller;

import com.practice.ecomm.model.Order;
import com.practice.ecomm.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.practice.ecomm.middlewares.ValidationMiddleware;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/orders")
@Validated
    public class OrderController {
        @Autowired
        private OrderService orderService;
        @Autowired
        private ValidationMiddleware validationMiddleware;

        @GetMapping
        public List<Order> getAllOrders() {
            return orderService.getAllOrders();
        }

        @GetMapping("/{id}")
        public Order getOrderById(@PathVariable String id) {
            return orderService.getOrderById(id);
        }

        @PostMapping
        public ResponseEntity<Object> createOrder(@Valid @RequestBody Order order)
        {
            // Validating the order using the ValidationMiddleware
            boolean isValidOrder = validationMiddleware.isValidOrder(order);
            if (!isValidOrder) {
                return new ResponseEntity<>("Invalid order data", HttpStatus.BAD_REQUEST);
            }

            if (order.getOrderDate() == null) {
                order.setOrderDate(new Date()); // Using java.util.Date for simplicity, consider using java.time.LocalDateTime
            }
            // Creation of the order
            Order createdOrder = orderService.createOrder(order);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
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






