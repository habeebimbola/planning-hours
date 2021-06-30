package com.globalaccelerex.planninghours.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ListIterator;

@JsonSerialize
@JsonPropertyOrder({"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"})
public class FormattedPlanningHour {

    private static final Logger logger = LoggerFactory.getLogger(FormattedPlanningHour.class);

    @JsonIgnore
    private PlanningHour planningHour;
    private static final java.lang.String CLOSED = "CLOSED";
    private static final String CLOSE = "close";
    private static final String OPEN = "open";

    @JsonProperty("monday")
    private String monday;

    @JsonProperty("tuesday")
    private String tuesday;

    @JsonProperty("wednesday")
    private String wednesday;

    @JsonProperty("thursday")
    private String thursday;

    @JsonProperty("friday")
    private String friday;

    @JsonProperty("saturday")
    private String saturday;

    @JsonProperty("sunday")
    private String sunday;

    public FormattedPlanningHour(PlanningHour planningHour) {
        this.planningHour = planningHour;
    }

    @JsonProperty("monday")
    public String getMonday() {

        if (this.planningHour.getMonday().isEmpty()) {
            monday = CLOSED;
        }else{
        ListIterator<PlanningPeriod> listIterator = this.planningHour.getMonday().listIterator();
        StringBuilder mondayBuilder = new StringBuilder();

        int  pairCount = 0; boolean isOpen = false;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (planningPeriod.getType().equalsIgnoreCase(OPEN)) {
                mondayBuilder.append(planningPeriod.getValue());
                isOpen = true;
            }

            if(planningPeriod.getType().equalsIgnoreCase(CLOSE))
            {
                mondayBuilder.append("-").append(planningPeriod.getValue());
            }

            pairCount++;

            if((pairCount % 2 ) == 0)
            {
                mondayBuilder.append(",");
            }
        }
        monday = mondayBuilder.toString();}
        return monday;
    }

    @JsonProperty("tuesday")
    public String getTuesday() {
        if (this.planningHour.getTuesday().isEmpty()) {
            tuesday = CLOSED;
        }
        else{
        StringBuilder tuesdayBuilder = new StringBuilder();

        ListIterator<PlanningPeriod> listIterator = this.planningHour.getTuesday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (planningPeriod.getType().equalsIgnoreCase(OPEN)) {
                tuesdayBuilder.append(planningPeriod.getValue());
            }

            if(planningPeriod.getType().equalsIgnoreCase(CLOSE))
            {
                tuesdayBuilder.append("-").append(planningPeriod.getValue());
            }
            pairCount++;

            if( (pairCount%2) == 0 )
            {
                tuesdayBuilder.append(",");
            }
        }
        tuesday = tuesdayBuilder.toString();}
        return tuesday;
    }

    @JsonProperty("wednesday")
    public String getWednesday() {
        if (this.planningHour.getWednesday().isEmpty()) {
            wednesday = CLOSED;
        }else{
        StringBuilder wednesdayBuilder = new StringBuilder();

        ListIterator<PlanningPeriod> listIterator = this.planningHour.getWednesday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (!planningPeriod.getType().equalsIgnoreCase(CLOSE)) {
                wednesdayBuilder.append(planningPeriod.getValue());

            } else {
                wednesdayBuilder.append("-").append(planningPeriod.getValue());
            }
            pairCount++;

            if(pairCount % 2 == 0)
            {
                wednesdayBuilder.append(",");
            }
        }
        wednesday = wednesdayBuilder.toString();}
        return wednesday;
    }


    @JsonProperty("thursday")
    public String getThursday() {
        if (this.planningHour.getThursday().isEmpty()) {
            thursday = CLOSED;
        }else{
        StringBuilder thursdayBuilder = new StringBuilder();
        ListIterator<PlanningPeriod> listIterator = this.planningHour.getThursday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (!planningPeriod.getType().equalsIgnoreCase(CLOSE)) {
                thursdayBuilder.append(planningPeriod.getValue());
            } else {
                thursdayBuilder.append("-").append(planningPeriod.getValue());
            }
            pairCount++;

            if(pairCount % 2 == 0 )
            {
                thursdayBuilder.append(",");
            }
        }
        thursday = thursdayBuilder.toString();}
        return thursday;
    }


    @JsonProperty("friday")
    public String getFriday() {
        if (this.planningHour.getFriday().isEmpty()) {
            friday = CLOSED;
        }
else{
        StringBuilder fridayBuilder = new StringBuilder();
        ListIterator<PlanningPeriod> listIterator = this.planningHour.getFriday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (!planningPeriod.getType().equalsIgnoreCase(CLOSE)) {
                fridayBuilder.append(planningPeriod.getValue());

            } else {
                fridayBuilder.append("-").append(planningPeriod.getValue());
            }
            pairCount++;
            if( pairCount % 2 == 0 )
            {
                fridayBuilder.append(",");
            }
        }
        friday = fridayBuilder.toString();
}
        return friday;
    }


    @JsonProperty("saturday")
    public String getSaturday() {
        if (this.planningHour.getSaturday().isEmpty()) {
            saturday = CLOSED;
        }
else{
        StringBuilder saturdayBuilder = new StringBuilder();

        ListIterator<PlanningPeriod> listIterator = this.planningHour.getSaturday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if(planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                saturdayBuilder.append(planningPeriod.getValue());
            }else {
                saturdayBuilder.append("-").append(planningPeriod.getValue());
            }
            ++pairCount;
            if(pairCount % 2 == 0 )
            {
                saturdayBuilder.append(",");
            }
        }
        saturday = saturdayBuilder.toString();
}
        return saturday;
    }


    @JsonProperty("sunday")
    public String getSunday() {
        if (this.planningHour.getSunday().isEmpty()) {
            sunday = CLOSED;
        }else{
        StringBuilder sundayBuilder = new StringBuilder();

        ListIterator<PlanningPeriod> listIterator = this.planningHour.getSunday().listIterator();
        int pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();
            if(planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                sundayBuilder.append(planningPeriod.getValue());
            }
            else
                {
                    sundayBuilder.append("-").append(planningPeriod.getValue());
                }
            ++pairCount;
            if(pairCount % 2 == 0 )
            {
                sundayBuilder.append(",");
            }
        }
        sunday = sundayBuilder.toString();
        }
        return sunday;
    }

}
