package com.nhnacademy.midoo.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class MilestonePutRequest {
    int milestoneId;
    String milestoneName;
    int projectId;
}
