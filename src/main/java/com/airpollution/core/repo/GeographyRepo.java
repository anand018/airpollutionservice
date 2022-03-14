package com.airpollution.core.repo;

import com.airpollution.core.entities.GeographyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeographyRepo extends JpaRepository<GeographyEntity, Integer> {


}
