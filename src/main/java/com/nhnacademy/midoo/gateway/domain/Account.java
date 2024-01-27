package com.nhnacademy.midoo.gateway.domain;

import lombok.Data;

@Data
public class Account {
    private String id;
    private String name;
    private String password;
    private String email;
    private String status;

}
