package com.steven.service;

import com.steven.bean.User;
import com.steven.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author donghongchen
 * @create 2017-12-04 16:41
 **/
@Service
public class UserService {

    @Resource
    UserDao userDao;

    public Integer insert(User user) {
        return userDao.insert(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<User> findListByIds(List<Integer> ids) {
        return userDao.findByUserIds(ids);
    }


    public Integer count(){
        return userDao.count();
    }

}
