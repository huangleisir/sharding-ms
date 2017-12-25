package com.steven.dao;

import com.steven.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donghongchen
 * @create 2017-12-04 16:39
 **/
@Repository
public interface UserDao {

    Integer insert(User user);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> ids);

    Integer count();

}
