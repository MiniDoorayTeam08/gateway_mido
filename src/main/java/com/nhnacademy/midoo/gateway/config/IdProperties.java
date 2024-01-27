package com.nhnacademy.midoo.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhnacademy.midoo")
@Getter
@Setter
public class IdProperties {
    String id;
}
