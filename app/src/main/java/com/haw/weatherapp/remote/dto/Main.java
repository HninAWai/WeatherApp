package com.haw.weatherapp.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable {

    @SerializedName("temp")
    public float temp;

    @SerializedName("temp_min")
    public float tempMin;

    @SerializedName("temp_max")
    public float tempMax;

    public Main(float temp,
                float tempMin,
                float tempMax){

        this.temp=temp;
        this.tempMin=tempMin;
        this.tempMax=tempMax;
    }

}
