package com.nhnacademy.midoo.gateway.domain.task.request.modify;


import lombok.Data;

@Data
public class TaskUpdateRequestDto {

    private String title;

    private String content;

}