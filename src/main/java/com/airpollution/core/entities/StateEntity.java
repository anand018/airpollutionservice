package com.airpollution.core.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "state")
@Entity
public class StateEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "state_id")
    @Column
    private List<CityEntity> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }
}
