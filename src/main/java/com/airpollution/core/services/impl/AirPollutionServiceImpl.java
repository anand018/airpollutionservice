package com.airpollution.core.services.impl;

import com.airpollution.core.constants.GlobalConstants;
import com.airpollution.core.exception.AirVisualServiceException;
import com.airpollution.core.services.AirPollutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AirPollutionServiceImpl implements AirPollutionService {

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(AirPollutionServiceImpl.class);

    @Override
    public String getAirQuality(MultiValueMap queryParams) {
        return processHttpRequest(GlobalConstants.URICITY, queryParams);
    }

    private String processHttpRequest(String uri, MultiValueMap<String, String> queryParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        queryParams.add("key", GlobalConstants.APIKEY);
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(GlobalConstants.URICITY).queryParams(queryParams).build();
        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, String.class);
            logger.info("fetched successfully");
        } catch (Exception e) {
            logger.error("exception in downstream. error: {}", e.getMessage());
            throw new AirVisualServiceException("Exception in downstream service call");
        }
        return responseEntity.getBody();
    }
}
