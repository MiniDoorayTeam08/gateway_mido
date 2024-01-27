package com.nhnacademy.midoo.gateway.domain.account.request;

import lombok.Value;

@Value
public class LoginRequest {
    String id;
    String password;
}
