package com.agile.agiletest.traintickets.pojo;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private int user_id;
    private int person_id;
    private String username;
    private String password;

    private List<Role> roles;

}
