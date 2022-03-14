package com.airpollution.core.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    private List<State> states;

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
