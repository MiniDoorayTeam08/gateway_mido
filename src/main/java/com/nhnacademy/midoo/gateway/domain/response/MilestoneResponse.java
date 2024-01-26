package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class MilestoneResponse {
    int milestoneId;
    String milestoneName;
    int projectId;
}
