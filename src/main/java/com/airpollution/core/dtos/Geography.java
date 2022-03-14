package com.airpollution.core.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geography {

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
