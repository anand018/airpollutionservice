package com.airpollution.core.services;

import com.airpollution.core.dtos.City;
import com.airpollution.core.dtos.Geography;
import com.airpollution.core.dtos.State;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface GeographyService {

     List<Geography> findCountries() throws InvocationTargetException, IllegalAccessException;
     List<State> findStates(String country);
     List<City> findCity(String state);
     void addGeography(Geography geography) throws InvocationTargetException, IllegalAccessException;

}
