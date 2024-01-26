package com.nhnacademy.midoo.gateway.model;


import lombok.Data;

@Data
public class AccountCreateRequest {
    private String id;
    private String name;
    private String pwd;
    private String email;
    private String status;

}
