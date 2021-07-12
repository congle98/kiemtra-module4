package com.example.kiemtrathuchanh.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Không dược để trống.")
    private String name;

    @Min(value = 0,message = "Phải là số dương")
    private int acreage;

    @Min(value = 0,message = "Phải là số dương")
    private int population;

    @Min(value = 0,message = "Phải là số dương")
    private int gdp;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

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

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
