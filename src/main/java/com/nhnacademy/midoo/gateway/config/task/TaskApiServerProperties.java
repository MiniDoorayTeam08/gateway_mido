package com.nhnacademy.midoo.gateway.config.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.task")
@Getter
@Setter
public class TaskApiServerProperties {
    String url;
}
