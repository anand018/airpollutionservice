package com.airpollution.core.services;

import org.springframework.util.MultiValueMap;

public interface AirPollutionService {

    String getAirQuality(MultiValueMap queryParams);
}
