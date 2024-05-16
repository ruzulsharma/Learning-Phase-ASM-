package com.practice.ecomm.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;

    @Document(collection = "orders")
    public class Order {
        @Id
            private String orderId;

            private Date orderDate;

            private String customerName;
            private String customerEmail;
            private String shippingAddress;
            private List<String> orderItems; //i have to change it to orderItem generic later
            private double totalAmount;
            private OrderStatus status;

            // Constructors
            public Order() {
                // Default constructor
            }


            public Order(String orderId, Date orderDate, String customerName, String customerEmail, String shippingAddress, List<String> orderItems, double totalAmount, OrderStatus status) {
                this.orderId= orderId;
                this.orderDate = orderDate;
                this.customerName = customerName;
                this.customerEmail = customerEmail;
                this.shippingAddress = shippingAddress;
                this.orderItems = orderItems;
                this.totalAmount = totalAmount;
                this.status = status;
            }

            // Getters and Setters
            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public Date getOrderDate() {
                return orderDate;
            }

            public void setOrderDate(Date orderDate) {
                this.orderDate = orderDate;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerEmail() {
                return customerEmail;
            }

            public void setCustomerEmail(String customerEmail) {
                this.customerEmail = customerEmail;
            }

            public String getShippingAddress() {
                return shippingAddress;
            }

            public void setShippingAddress(String shippingAddress) {
                this.shippingAddress = shippingAddress;
            }

            public List<String> getOrderItems() {
                return orderItems;
            }

            public void setOrderItems(List<String> orderItems) {
                this.orderItems = orderItems;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public OrderStatus getStatus() {
                return status;
            }

            public void setStatus(OrderStatus status) {
                this.status = status;
            }


    }



