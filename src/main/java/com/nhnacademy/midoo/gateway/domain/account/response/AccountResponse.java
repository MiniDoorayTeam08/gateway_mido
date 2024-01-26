package com.nhnacademy.midoo.gateway.domain.account.response;

import lombok.Value;

@Value
public class AccountResponse {
    String id;
    String pwd;
    String email;
    String accountStatus;

}
