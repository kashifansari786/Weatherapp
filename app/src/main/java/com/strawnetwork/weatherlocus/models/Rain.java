package com.strawnetwork.weatherlocus.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "3h"
})
public class Rain {
    @JsonProperty("3h")
    private float rainfall=0;

    @JsonProperty("3h")
    public float getAll() {
        return rainfall;
    }

    @JsonProperty("3h")
    public void setAll(float all) {
        this.rainfall = all;
    }
}
