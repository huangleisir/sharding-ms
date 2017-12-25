package com.steven.service;

import com.steven.bean.Order;
import com.steven.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donghongchen
 * @create 2017-12-06 18:06
 **/
@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Integer insert(Order order) {
        return orderDao.insert(order);
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public List<Order> findByUserIds(String code) {
        return orderDao.findByUserIds(code);
    }

    public Integer count() {
        return orderDao.count();
    }

}
