package com.airpollution.core.controllers;

import com.airpollution.core.dtos.City;
import com.airpollution.core.dtos.Geography;
import com.airpollution.core.dtos.State;
import com.airpollution.core.services.GeographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GeographyController {

    @Autowired
    private GeographyService geographyService;

    @GetMapping("/countries")
    public Geography findCountries() throws InvocationTargetException, IllegalAccessException {
        return geographyService.findCountries().get(0);
    }

    @GetMapping("/states")
    public List<State> findStates(String country) {
        return geographyService.findStates(country);
    }

    @GetMapping("/cities")
    public List<City> findCity(String state) {
        return geographyService.findCity(state);
    }

    @PostMapping("/countries")
    public void saveGeography(@RequestBody Geography geography) throws InvocationTargetException, IllegalAccessException {
        geographyService.addGeography(geography);
    }
}
