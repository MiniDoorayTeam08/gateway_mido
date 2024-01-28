package com.nhnacademy.midoo.gateway.domain.account.response;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AccountResponse {
    String id;
    String password;
    String email;
    String accountStatus;

}
