package com.nhnacademy.midoo.gateway.service.account;

import com.nhnacademy.midoo.gateway.config.account.AccountApiServerProperties;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountCreateRequest;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountGetRequest;
import com.nhnacademy.midoo.gateway.domain.account.request.AccountStatusModifyRequest;
import com.nhnacademy.midoo.gateway.domain.account.request.LoginRequest;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountResponse;
import com.nhnacademy.midoo.gateway.domain.account.response.AccountsResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountServiceImpl implements AccountService {
    private final RestTemplate template;
    private final String accountUrl;

    @Autowired
    public AccountServiceImpl(RestTemplate template, AccountApiServerProperties accountApiServerProperties) {
        this.template = template;
        accountUrl = accountApiServerProperties.getUrl();
    }

    @Override
    public void putAccount(AccountStatusModifyRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts/status";

        HttpEntity<AccountStatusModifyRequest> requestEntity = new HttpEntity<>(request, httpHeaders);
        template.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }


    @Override
    public AccountResponse getAccountById(String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts/" + accountId;

        HttpEntity<Void> accountRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<AccountResponse> responseEntity = template.exchange(
                url,
                HttpMethod.GET,
                accountRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public List<AccountsResponse> getAccountsAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts";

        HttpEntity<Void> accountsRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<AccountsResponse>> responseEntity = template.exchange(
                url,
                HttpMethod.GET,
                accountsRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public Boolean existAccount(String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts/" + accountId;

        HttpEntity<AccountGetRequest> accountRequestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<AccountResponse> responseEntity = template.exchange(
                url,
                HttpMethod.GET,
                accountRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean matchIdPwd(LoginRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts/login";

        HttpEntity<LoginRequest> accountRequestEntity = new HttpEntity<>(request, httpHeaders);

        ResponseEntity<AccountResponse> responseEntity = template.exchange(
                url,
                HttpMethod.POST,
                accountRequestEntity,
                new ParameterizedTypeReference<>() {
                });

        return HttpStatus.OK == responseEntity.getStatusCode();
    }

    @Override
    public String createAccount(AccountCreateRequest request) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        String url = accountUrl + "/accounts/register";

        HttpEntity<AccountCreateRequest> requestEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<String> responseEntity = template.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        }
        return "Register Fail";
    }


}

