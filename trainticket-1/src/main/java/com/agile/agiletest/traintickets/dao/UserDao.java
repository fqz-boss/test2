package com.agile.agiletest.traintickets.dao;


import com.agile.agiletest.traintickets.pojo.Role;
import com.agile.agiletest.traintickets.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserDao {

    //根据用户名查出所有用户信息，同时查出用户的权限
     @Select("select * from user where username=#{username}")
     @Results({
             @Result(id=true,column = "user_id",property = "user_id"),
             @Result(column = "username",property = "username"),
             @Result(column = "password",property = "password"),
             @Result(column = "person_id",property = "person_id"),
             @Result(column = "user_id",property = "roles",
                     many = @Many(select = "findRoleByUser",
                             fetchType = FetchType.EAGER ))
     })
          User getUserByUsername (String username);

    // 根据用户id关联查询用户的所有权限
    @Select("select r.role from role r where r.role_id in " +
            "(select u.role_id from user_role u where u.user_id = #{user_id})")
    List<Role> findRoleByUser(Integer user_id);

    @Insert("insert into user (username, password, person_id) values(#{username}, #{password}, #{person_id})")
    public abstract int insertUserRegisterInfo(User user);

    /**
     *  更新用户账户信息
     */
    public abstract int updateUserRegisterInfo(User user);

}
