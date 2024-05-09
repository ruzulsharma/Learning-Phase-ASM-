package com.practice.ecomm.service;

import com.practice.ecomm.model.Order;
import com.practice.ecomm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
        @Autowired
        private OrderRepository orderRepository;

        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public Order getOrderById(String id) {
            return orderRepository.findById(id).orElse(null);
        }

        public Order createOrder(Order order) {
            return orderRepository.save(order);
        }

        public Order updateOrder(String id, Order order) {
            if (orderRepository.existsById(id)) {
                order.setOrderId(id);
                return orderRepository.save(order);
            } else {
                return null;
            }
        }

        public void deleteOrder(String id) {
            orderRepository.deleteById(id);
        }
    }


