package com.nhnacademy.midoo.gateway.domain.account.request;


import lombok.Value;

@Value
public class AccountCreateRequest {
    String id;
    String password;
    String email;
    String accountStatus;
}
