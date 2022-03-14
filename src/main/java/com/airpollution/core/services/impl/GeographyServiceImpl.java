package com.airpollution.core.services.impl;

import com.airpollution.core.dtos.City;
import com.airpollution.core.dtos.Geography;
import com.airpollution.core.dtos.State;
import com.airpollution.core.entities.GeographyEntity;
import com.airpollution.core.repo.GeographyRepo;
import com.airpollution.core.services.GeographyService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeographyServiceImpl implements GeographyService {

    @Autowired
    private GeographyRepo geographyRepo;

    @Override
    public List<Geography> findCountries() throws InvocationTargetException, IllegalAccessException {
        List<GeographyEntity> geographyEntities = geographyRepo.findAll();
        List<Geography> geographies = new ArrayList<>();

        for (GeographyEntity geographyEntity : geographyEntities) {
            Geography geography = new Geography();
            BeanUtils.copyProperties(geography, geographyEntity);
            geographies.add(geography);
        }
        return geographies;
    }

    @Override
    public List<State> findStates(String country) {
        return null;
    }

    @Override
    public List<City> findCity(String state) {
        return null;
    }

    @Override
    public void addGeography(Geography geography) throws InvocationTargetException, IllegalAccessException {
        GeographyEntity geographyEntity = new GeographyEntity();
        BeanUtils.copyProperties(geographyEntity, geography);
        geographyRepo.save(geographyEntity);
    }
}
