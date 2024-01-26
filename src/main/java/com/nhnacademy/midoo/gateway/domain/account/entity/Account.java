package com.nhnacademy.midoo.gateway.domain.account.entity;


import lombok.Data;

@Data
public class Account {
    private String id;

    private String password;
    private String email;
    private String accountStatus;
}
