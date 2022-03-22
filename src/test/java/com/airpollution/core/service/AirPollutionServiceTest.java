package com.airpollution.core.service;

import com.airpollution.core.services.impl.AirPollutionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;

@SpringBootTest
public class AirPollutionServiceTest {

    @MockBean
    private AirPollutionServiceImpl  airPollutionService;

    @BeforeEach
    public void before() {
        Mockito.when(airPollutionService.getAirQuality(new LinkedMultiValueMap())).thenReturn("ok");
    }

    @Test
    public void testGetAirQuality() {
        String actual = airPollutionService.getAirQuality(new LinkedMultiValueMap());
        Assert.isTrue(actual.equals("ok"), "should be air quality");
    }
}
