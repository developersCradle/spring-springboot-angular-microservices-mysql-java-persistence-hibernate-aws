package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
