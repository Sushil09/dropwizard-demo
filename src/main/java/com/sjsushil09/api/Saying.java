package com.sjsushil09.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Saying {

    @JsonProperty
    private long id;

    @JsonProperty
    private String content;
}
