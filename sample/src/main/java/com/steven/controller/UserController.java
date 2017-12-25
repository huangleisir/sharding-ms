package com.steven.controller;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.google.gson.Gson;
import com.steven.bean.User;
import com.steven.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author donghongchen
 * @create 2017-12-04 16:47
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    IdGenerator idGenerator;
//    http://localhost:8080/user/add
    @RequestMapping("/add")
    public String addUser(){
        User user = new User();
        user.setName("steven");
        user.setAge(25L);
        user.setUserId(System.currentTimeMillis());
        return userService.insert(user)>0 ? "success":"fail";
    }


    @RequestMapping("/list")
    public String list(){
        Map map = new HashMap(2);
        List list = userService.findAll();
        map.put("data",list);
        map.put("count",list.size());
        return new Gson().toJson(map);
    }

    @RequestMapping("/count")
    public String count(){
        return userService.count()+"";
    }


    @RequestMapping("/ids")
    public String getByIds(@Param("ids") String ids){
        Map map = new HashMap(2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(864026624);
        List lists = userService.findListByIds(list);
        map.put("data",lists);
        map.put("count",lists.size());
        return new Gson().toJson(map);
    }

}
