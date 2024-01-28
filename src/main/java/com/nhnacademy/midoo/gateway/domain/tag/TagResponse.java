package com.nhnacademy.midoo.gateway.domain.tag;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class TagResponse {
    long tagId;
    String tagName;
}