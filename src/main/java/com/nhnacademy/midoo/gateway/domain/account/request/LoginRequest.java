package com.nhnacademy.midoo.gateway.domain.account.request;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class LoginRequest {
    String id;
    String password;
}
