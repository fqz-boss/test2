package com.agile.agiletest.traintickets.service;

import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
     //登陆处理
      public abstract Result  loginIn(User userDate);

    /**
     * 更新用户信息
     */
    public abstract Result updateUser(User userData, String  passwordNew);

    /**
     * Resist user info
     */
     public abstract Result registUser(User userData);
}
