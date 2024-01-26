package com.nhnacademy.midoo.gateway.domain.task.request.register;

import lombok.Data;

@Data
public class TagCreateDto {

    private Integer projectId;
    private String name;
}
