package com.strawnetwork.weatherlocus.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("coord")
@JsonPropertyOrder({
        "id",
        "name",
        "country",
        "population",
        "timezone",
        "sunrise",
        "sunset"
})
public class City implements Serializable {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("population")
    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @JsonProperty("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
