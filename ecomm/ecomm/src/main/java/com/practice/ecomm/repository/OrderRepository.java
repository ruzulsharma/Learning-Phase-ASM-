package com.practice.ecomm.repository;

import com.practice.ecomm.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
