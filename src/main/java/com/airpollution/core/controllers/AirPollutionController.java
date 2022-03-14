package com.airpollution.core.controllers;

import com.airpollution.core.services.AirPollutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AirPollutionController {

    @Autowired
    private AirPollutionService airPollutionService;

    private static Logger logger = LoggerFactory.getLogger(AirPollutionController.class);

    @GetMapping("/air-quality/city")
    public String getAirQualityForCity(@RequestParam MultiValueMap queryParams) {
        logger.info("inside AirPollutionController");
        return airPollutionService.getAirQuality(queryParams);
    }
}
