package com.airpollution.core.controllers;

import com.airpollution.core.constants.GlobalConstants;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirPollutionControllerTest {

    @LocalServerPort
    private int randomServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Disabled
    public void testGetAirQualityForCity() throws MalformedURLException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        String baseUrl = "/airpollution/service/api/v1/air-quality/city";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl).queryParam("key", GlobalConstants.APIKEY).queryParam("city", "Los Angeles").queryParam("state", "California").queryParam("country", "USA");
        String url = new URL("http://localhost:" + randomServerPort + builder.build()).toString();
        ResponseEntity<String> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        HttpStatus statusCode = result.getStatusCode();
        Assert.isTrue(HttpStatus.ACCEPTED == statusCode, "Should be a success status code");
    }
}
