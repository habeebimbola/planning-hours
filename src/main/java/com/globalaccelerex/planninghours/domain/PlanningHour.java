package com.globalaccelerex.planninghours.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonPropertyOrder({"friday","saturday","sunday","monday","tuesday","wednesday","thursday"})
public class PlanningHour {

    @JsonProperty("friday")
    private List<PlanningPeriod> friday;

    @JsonProperty("saturday")
    private List<PlanningPeriod> saturday;

    @JsonProperty("sunday")
    private List<PlanningPeriod> sunday;

    @JsonProperty("monday")
    private List<PlanningPeriod> monday;

    @JsonProperty("tuesday")
    private List<PlanningPeriod> tuesday;

    @JsonProperty("wednesday")
    private List<PlanningPeriod> wednesday;

    @JsonProperty("thursday")
    private List<PlanningPeriod> thursday;

    @JsonProperty("friday")
    public List<PlanningPeriod> getFriday() {
        return friday;
    }
    @JsonProperty("friday")
    public void setFriday(List<PlanningPeriod> friday) {
        this.friday = friday;
    }

    @JsonProperty("saturday")
    public List<PlanningPeriod> getSaturday() {
        return saturday;
    }

    @JsonProperty("saturday")
    public void setSaturday(List<PlanningPeriod> saturday) {
        this.saturday = saturday;
    }

    @JsonProperty("sunday")
    public List<PlanningPeriod> getSunday() {
        return sunday;
    }

    @JsonProperty("sunday")
    public void setSunday(List<PlanningPeriod> sunday) {
        this.sunday = sunday;
    }

    @JsonProperty("monday")
    public List<PlanningPeriod> getMonday() {
        return monday;
    }

    @JsonProperty("monday")
    public void setMonday(List<PlanningPeriod> monday) {
        this.monday = monday;
    }

    @JsonProperty("tuesday")
    public List<PlanningPeriod> getTuesday() {
        return tuesday;
    }

    @JsonProperty("tuesday")
    public void setTuesday(List<PlanningPeriod> tuesday) {
        this.tuesday = tuesday;
    }

    @JsonProperty("wednesday")
    public List<PlanningPeriod> getWednesday() {
        return wednesday;
    }
    @JsonProperty("wednesday")
    public void setWednesday(List<PlanningPeriod> wednesday) {
        this.wednesday = wednesday;
    }
    @JsonProperty("thursday")
    public List<PlanningPeriod> getThursday() {
        return thursday;
    }

    @JsonProperty("thursday")
    public void setThursday(List<PlanningPeriod> thursday) {
        this.thursday = thursday;
    }
}
