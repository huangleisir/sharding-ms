package com.steven.controller;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.google.gson.Gson;
import com.steven.bean.Order;
import com.steven.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author donghongchen
 * @create 2017-12-06 18:08
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    IdGenerator idGenerator;


    @RequestMapping("/add")
    public String addOrder() {
        Order order = new Order();
        order.setCode(Math.abs(idGenerator.generateId().intValue()) + "");
        order.setUserName("steven");
        orderService.insert(order);
        return "success";
    }


    @RequestMapping("/list")
    public String list() {
        Map map = new HashMap(2);
        List list = orderService.findAll();
        map.put("data", list);
        map.put("count", list.size());
        return new Gson().toJson(map);
    }

    @RequestMapping("/count")
    public String count() {
        return orderService.count() + "";
    }

}
