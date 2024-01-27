package com.nhnacademy.midoo.gateway.domain.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@Setter
@ToString

public class AccountDto {

    private String id;
    private String email;
    private String password;
    private String name;
    private String status;

    public AccountDto(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
