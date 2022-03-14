package com.airpollution.core.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "country")
@Entity
public class CountryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "country_id")
    @Column
    private List<StateEntity> states;

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

    public List<StateEntity> getStates() {
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
}
