package com.globalaccelerex.planninghours.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type","value"})
public class PlanningPeriod {
    final DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("h:mma");

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonProperty("value")
    public String getValue() {
        return value;
    }
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = LocalTime.ofSecondOfDay(Long.parseLong(value)).format(dateTimeFormatter);
    }
}
