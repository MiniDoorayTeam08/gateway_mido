package com.nhnacademy.midoo.gateway.domain.account.request;

import lombok.Value;


@Value
public class AccountStatusModifyRequest {
    private String id;
    private String status;
}
