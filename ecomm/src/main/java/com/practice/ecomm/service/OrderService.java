package com.practice.ecomm.service;

import com.practice.ecomm.middlewares.ValidationMiddleware;
import com.practice.ecomm.model.Order;
import com.practice.ecomm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
        @Autowired
        private OrderRepository orderRepository; //Injecting repository to store data

        @Autowired
        private ValidationMiddleware validationMiddleware; //Injecting the validations

        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public Order getOrderById(String id) {
            return orderRepository.findById(id).orElse(null);
        }

        public Order createOrder(Order order) {
            if (validationMiddleware.isValidOrder(order)) { // Using the validation middleware
                return orderRepository.save(order);
            } else {
                throw new IllegalArgumentException("Invalid order data");
            }

        }

        public Order updateOrder(String id, Order order) {
            if (validationMiddleware.isValidOrder(order)) {
                if (orderRepository.existsById(id)) {
                    order.setOrderId(id);
                    return orderRepository.save(order);
                } else {
                    throw new IllegalArgumentException("Order not found");
                }
            } else {
                throw new IllegalArgumentException("Invalid order data");
            }
        }

        public void deleteOrder(String id) {
            orderRepository.deleteById(id);
        }
    }


