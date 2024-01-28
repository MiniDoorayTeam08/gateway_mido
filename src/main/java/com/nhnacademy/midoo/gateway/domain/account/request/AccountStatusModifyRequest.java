package com.nhnacademy.midoo.gateway.domain.account.request;

import com.nhnacademy.midoo.gateway.domain.account.AccountStatus;
import lombok.Value;


@Value
public class AccountStatusModifyRequest {
    String id;
    AccountStatus status;
}
