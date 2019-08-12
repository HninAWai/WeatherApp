package com.haw.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.haw.weatherapp.remote.dto.ResponseWeather;
import com.haw.weatherapp.remote.retrofit.APIService;
import com.haw.weatherapp.remote.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWeatherData=findViewById(R.id.tvWeatherData);

        APIService service= RetrofitClientInstance.getRetrofitInstance().create(APIService.class);

        Call<ResponseWeather> call=service.getCurrentWeatherData("c1698c96e1mshf961475343744d0p126b00jsnea770a399e37",
                "\"metric\"or\"imperial\"",
                "xml,html",
                "Dawei,MM");

        call.enqueue(new Callback<ResponseWeather>() {
            @Override
            public void onResponse(@NonNull Call<ResponseWeather> call, @NonNull Response<ResponseWeather> response) {
                if (response.isSuccessful()) {
                    ResponseWeather responseWeather = response.body();
                    assert responseWeather != null;

                    Log.d("MainActivity", "weather main:" + responseWeather.weatherList.get(0).main);
                    Log.d("MainActivity", "weather description:" + responseWeather.weatherList.get(0).description);
                    Log.d("MainActivity", "weather temp:" + responseWeather.main.temp);
                    Log.d("MainActivity", "weather temp min:" + responseWeather.main.tempMin);
                    Log.d("MainActivity", "weather temp max:" + responseWeather.main.tempMax);

                    tvWeatherData.setText("weather main:" + responseWeather.weatherList.get(0).main + "\n"
                            + "weather description:" + responseWeather.weatherList.get(0).description + "\n"
                            + "Temp:" + responseWeather.main.temp + "\n"
                            + "Temp min:" + responseWeather.main.tempMin + "\n"
                            + "Temp max:" + responseWeather.main.tempMax + "\n");

                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseWeather> call, @NonNull Throwable t) {
                Log.d("MainActivity", String.format("Error: %s", t.getMessage()));
            }
        });
    }
}



