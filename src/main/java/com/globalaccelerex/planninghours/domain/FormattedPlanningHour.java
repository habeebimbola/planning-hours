package com.globalaccelerex.planninghours.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private boolean isOpen = false;
     private boolean didNotCloseSameDay = false;

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
        }else
            {
        ListIterator<PlanningPeriod> listIterator = this.planningHour.getMonday().listIterator();
        StringBuilder mondayBuilder = new StringBuilder();
        final int size = this.planningHour.getMonday().size();
        int  pairCount = 0;

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (planningPeriod.getType().equalsIgnoreCase(OPEN) && !isOpen) {
                mondayBuilder.append(planningPeriod.getValueStr());
                isOpen = true;
            }

            if(planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen )
            {
                mondayBuilder.append("-").append(planningPeriod.getValueStr());
                isOpen = false;
                didNotCloseSameDay = false;
            }

            pairCount++;


            if((pairCount % 2 ) == 0 && pairCount != size )
            {
                mondayBuilder.append(",");
            }

            if( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getTuesday().size();

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (planningPeriod.getType().equalsIgnoreCase(OPEN) && !isOpen) {
                tuesdayBuilder.append(planningPeriod.getValueStr());
                isOpen = true;
            }

            if(planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen )
            {
                tuesdayBuilder.append("-").append(planningPeriod.getValueStr());
                isOpen = false;
                didNotCloseSameDay = false;
            }
            pairCount++;

            if( (pairCount % 2 ) == 0 && pairCount != size )
            {
                tuesdayBuilder.append(",");
            }
            if(pairCount ==size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getWednesday().size();

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (!planningPeriod.getType().equalsIgnoreCase(CLOSE) && !isOpen) {
                wednesdayBuilder.append(planningPeriod.getValueStr());
                isOpen = true;

            }
                if(planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen)
                {
                    wednesdayBuilder.append("-").append(planningPeriod.getValueStr());
                    isOpen = false;
                }


            pairCount++;

            if(pairCount % 2 == 0 && pairCount < size )
            {
                wednesdayBuilder.append(",");
            }
            if ( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getThursday().size();

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (!planningPeriod.getType().equalsIgnoreCase(CLOSE) && !isOpen) {
                thursdayBuilder.append(planningPeriod.getValueStr());
                isOpen = true;
            }
            if(planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen) {
                thursdayBuilder.append("-").append(planningPeriod.getValueStr());
                isOpen = false;
                didNotCloseSameDay = false;
            }

            pairCount++;

            if(pairCount % 2 == 0 && pairCount < size )
            {
                thursdayBuilder.append(",");
            }
            if( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                 didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getFriday().size();

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if (planningPeriod.getType().equalsIgnoreCase(OPEN) ) {
                fridayBuilder.append(planningPeriod.getValueStr());
            }
            if( planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen) {
                fridayBuilder.append("-").append(planningPeriod.getValueStr());
                didNotCloseSameDay = false;
            }
            pairCount++;
            if( pairCount % 2 == 0 && pairCount < size)
            {
                fridayBuilder.append(",");
            }
            if( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getSaturday().size();

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if(planningPeriod.getType().equalsIgnoreCase(OPEN) )
            {
                saturdayBuilder.append(planningPeriod.getValueStr());
            }
            if(planningPeriod.getType().equalsIgnoreCase(CLOSE) && isOpen) {
                saturdayBuilder.append("-").append(planningPeriod.getValueStr());
                didNotCloseSameDay = false;
            }

            ++pairCount;

            if(pairCount % 2 == 0  && pairCount < size)
            {
                saturdayBuilder.append(",");
            }
            if( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
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
        int pairCount = 0, size = this.planningHour.getSunday().size();

        if(didNotCloseSameDay && size >= 1)
        {
            logger.info("Hitting this block!");
            PlanningPeriod planningPeriod = listIterator.next();

            if(planningPeriod.getType().equalsIgnoreCase(CLOSE))
            {
                saturday = new StringBuilder(getSaturday()).append("-").append(planningPeriod.getValueStr()).toString();
            }
        }

        while (listIterator.hasNext()) {
            PlanningPeriod planningPeriod = listIterator.next();

            if(planningPeriod.getType().equalsIgnoreCase(OPEN) )
            {
                sundayBuilder.append(planningPeriod.getValueStr());
            }
            if(planningPeriod.getType().equalsIgnoreCase(CLOSE) )
            {
                    sundayBuilder.append("-").append(planningPeriod.getValueStr());
                    didNotCloseSameDay = false;
                }
            ++pairCount;
            if(pairCount % 2 == 0 && pairCount < size )
            {
                sundayBuilder.append(",");
            }
            if( pairCount == size && planningPeriod.getType().equalsIgnoreCase(OPEN))
            {
                didNotCloseSameDay = true;
            }
        }
        sunday = sundayBuilder.toString();
        }
        return sunday;
    }

}
