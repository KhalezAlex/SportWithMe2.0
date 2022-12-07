package com.swm.sportwithme.model;

import javax.persistence.*;
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    //    @Column(name = "city_id")
//    @OneToMany
//    private Set<City> cities;
    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public Country(String name, Set<City> cities) {
//        this.name = name;
//        this.cities = cities;
//    }
}