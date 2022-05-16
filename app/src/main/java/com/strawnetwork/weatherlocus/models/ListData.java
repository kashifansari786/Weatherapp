package com.strawnetwork.weatherlocus.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("sys")
@JsonPropertyOrder({
        "dt",
        "main",
        "weather",
        "clouds",
        "wind",
        "visibility",
        "pop",
        "dt_txt"
})
public class ListData implements Serializable {
    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }
    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("pop")
    private Integer pop;
    @JsonProperty("dt_txt")
    private String dtTxt;

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("pop")
    public Integer getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}
