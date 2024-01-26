package com.nhnacademy.midoo.gateway.service.account;

import com.nhnacademy.midoo.gateway.domain.account.request.AccountCreateRequest;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountStatusModifyRequest;
import com.nhnacademy.midoo.gateway.domain.account.request.LoginRequest;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountsResponse;
import java.util.List;

public interface AccountService {

    AccountResponse getAccountById(String accountId);

    List<AccountsResponse> getAccountsAll();

    Boolean existAccount(String accountId);

    AccountResponse matchIdPwd(LoginRequest request);

    String createAccount(AccountCreateRequest request);

    void putAccount(String accountId, AccountStatusModifyRequest request);


}
