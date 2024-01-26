package com.nhnacademy.midoo.gateway.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "com.nhn.api")
@Configuration
public class ServerProperties {
    private String accountPort;
    private String taskPort;
}