package com.nhnacademy.midoo.gateway.domain.response;

import lombok.Value;

@Value
public class MilestoneResponse {
    long milestoneId;
    String milestoneName;
    long projectId;
}
