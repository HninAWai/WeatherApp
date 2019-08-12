package com.haw.weatherapp.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseWeather implements Serializable {

   @SerializedName("weather")
   public List<Weather> weatherList;

   @SerializedName("main")
   public Main main;

}
