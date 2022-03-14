package com.airpollution.core.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class State {

    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
