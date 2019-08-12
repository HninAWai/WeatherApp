package com.haw.weatherapp.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("main")
    public String main;

    @SerializedName("description")
    public String description;


    public Weather(String main,
                   String description){

        this.main= main;
        this.description= description;
    }
}
