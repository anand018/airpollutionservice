package com.airpollution.core.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "geography")
@Entity
public class GeographyEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany
    @JoinColumn(name = "geography_id")
    @Column
    private List<CountryEntity> countries;

    public List<CountryEntity> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryEntity> countries) {
        this.countries = countries;
    }
}
