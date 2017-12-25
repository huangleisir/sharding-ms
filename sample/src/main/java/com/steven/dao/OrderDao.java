package com.steven.dao;

import com.steven.bean.Order;

import java.util.List;

/**
 * @author donghongchen
 * @create 2017-12-06 18:05
 **/
public interface OrderDao {

    Integer insert(Order order);

    List<Order> findAll();

    List<Order> findByUserIds(String code);

    Integer count();


}
