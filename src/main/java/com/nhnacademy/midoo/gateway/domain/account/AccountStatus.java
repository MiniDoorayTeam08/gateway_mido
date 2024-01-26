package com.nhnacademy.midoo.gateway.domain.account;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum AccountStatus {
    가입, 탈퇴, 휴먼;


    public String getName() {
        return this.name();
    }
}
