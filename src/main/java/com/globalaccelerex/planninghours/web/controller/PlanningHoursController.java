package com.globalaccelerex.planninghours.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalaccelerex.planninghours.domain.FormattedPlanningHour;
import com.globalaccelerex.planninghours.domain.PlanningHour;
import com.globalaccelerex.planninghours.domain.PlanningPeriod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/planningHours")
public class PlanningHoursController {

    private final Logger logger = LoggerFactory.getLogger(PlanningHoursController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    public PlanningHoursController() {
    }

    @PostMapping()
    public ResponseEntity<FormattedPlanningHour> getPlanningHours(@RequestBody JsonNode requestBodyJson) throws JsonProcessingException {
        PlanningHour planningHour =  mapper.readValue(requestBodyJson.toPrettyString(), PlanningHour.class);
        logger.info("Input JSON {}",requestBodyJson.toPrettyString());
        ResponseEntity<FormattedPlanningHour> hourResponseEntity = new ResponseEntity<>( new FormattedPlanningHour(planningHour), HttpStatus.OK );
        return hourResponseEntity;
    }
}
