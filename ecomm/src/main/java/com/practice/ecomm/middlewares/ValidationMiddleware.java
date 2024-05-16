package com.practice.ecomm.middlewares;

import com.practice.ecomm.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ValidationMiddleware {

    public boolean isValidOrder(Order order) {
        return order != null &&
                isValidString(order.getCustomerName()) &&
                isValidString(order.getCustomerEmail()) &&
                isValidString(order.getShippingAddress()) &&
                isValidOrderDate(order.getOrderDate()) &&
                isValidOrderItems(order.getOrderItems());
    }

    private boolean isValidString(String value) {
        return !StringUtils.isEmpty(value);
    }

    private boolean isValidOrderDate(Date orderDate) {
        return orderDate != null && orderDate.before(new Date());
    }

    private boolean isValidOrderItems(List<String> orderItems) {
        return orderItems != null && !orderItems.isEmpty();
    }
}
