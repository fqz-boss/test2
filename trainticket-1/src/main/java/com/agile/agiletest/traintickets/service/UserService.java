package com.agile.agiletest.traintickets.service;

import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.dao.PersonDao;
import com.agile.agiletest.traintickets.dao.UserDao;
import com.agile.agiletest.traintickets.pojo.Person;
import com.agile.agiletest.traintickets.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.agile.agiletest.traintickets.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public PersonDao personDao;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User users = userDao.getUserByUsername(username);
        System.out.println(users);
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println(1);
        // 创建List集合，用来保存用户权限，GrantedAuthority对象代表赋予给当前用户的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 获得当前用户权限集合
        List<Role> roles = users.getRoles();
        for (Role role : roles) {
            // 将关联对象Role的authority属性保存为用户的认证权限
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        // 此处返回的是org.springframework.security.core.userdetails.User类，该类是Spring Security内部的实现
        return new org.springframework.security.core.userdetails.User(users.getUsername(),users.getPassword(),authorities);
    }


    @Transactional
    public Result updateUserInfo(Person person) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("更新个人信息"+username);
        User user = userDao.getUserByUsername(username);
        Result result = new Result();
        result.setMsg("update fail, please update again");
        result.setStateCode(404);
        result.setData(false);
        System.out.println("个人信息id"+user.getPerson_id());
        if (user != null ) {
            if( user.getPerson_id()> 0) {
                System.out.println(user.getUser_id());
                person.setId(user.getPerson_id());
                int i = personDao.updateUserInfo(person);
                if (i == 1) {
                    result.setMsg("update success");
                    result.setStateCode(200);
                    result.setData(true);
                }
            } else {
                int i =  personDao.insertUserInfo(person);
                if (i == 1){
                    user.setPerson_id(person.getId());
                    int j = userDao.updateUserRegisterInfo(user);
                    if (j == 1){
                        result.setMsg("update success");
                        result.setStateCode(200);
                        result.setData(true);
                    }
                }
            }
        }
        return result;
    }


    public Result getPersonInfo(String username) {
        Result result = new Result();
        Person person = personDao.getPersonInfo1(username);
        if (person == null) {
            result.setStateCode(400);
            result.setMsg("未填写个人信息，请完善个人信息");
            result.setData(null);
        } else {
            result.setStateCode(200);
//            result.setStateCode();
            result.setMsg("查询成功，已填写个人信息");
            result.setData(person);
        }
        return result;
    }
}
