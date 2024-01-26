package com.nhnacademy.midoo.gateway.domain.account.request;


import lombok.Value;

@Value
public class AccountCreateRequest {
    private String id;
    private String pwd;
    private String email;
    private String accountStatus;

}
