package com.strawnetwork.weatherlocus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.strawnetwork.weatherlocus.R;
import com.strawnetwork.weatherlocus.models.City;
import com.strawnetwork.weatherlocus.models.ListData;
import com.strawnetwork.weatherlocus.models.MainListData;
import com.strawnetwork.weatherlocus.utils.Utils;

import okhttp3.internal.Util;

public class DetailFragment extends Fragment {

    private ListData listData;
    private City cityData;
    private ImageView icon,weather_below,backbutton;
    private TextView date,cityName,temp,temp_min_max,feel_like,weather_desc,temp_min,temp_max,presure,sea_level,ground_level,humidity,weather,wind_speed,wind_deg,visibility,sun_rise,sun_set,cloud,rain;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listData=DetailFragmentArgs.fromBundle(getArguments()).getListData();
        cityData=DetailFragmentArgs.fromBundle(getArguments()).getClouddata();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detail_layout,container,false);
        cityName=view.findViewById(R.id.cityName);
        date=view.findViewById(R.id.date);
        backbutton=view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
        icon=view.findViewById(R.id.icon);
        rain=view.findViewById(R.id.rain);
        weather_below=view.findViewById(R.id.weather_below);
        temp=view.findViewById(R.id.temp);
        temp_min_max=view.findViewById(R.id.temp_min_max);
        feel_like=view.findViewById(R.id.feel_like);
        weather_desc=view.findViewById(R.id.weather_desc);
        temp_min=view.findViewById(R.id.temp_min);
        temp_max=view.findViewById(R.id.temp_max);
        presure=view.findViewById(R.id.presure);
        sea_level=view.findViewById(R.id.sea_level);
        ground_level=view.findViewById(R.id.ground_level);
        humidity=view.findViewById(R.id.humidity);
        weather=view.findViewById(R.id.weather);
        wind_speed=view.findViewById(R.id.wind_speed);
        wind_deg=view.findViewById(R.id.wind_deg);
        visibility=view.findViewById(R.id.visibility);
        sun_rise=view.findViewById(R.id.sun_rise);
        sun_set=view.findViewById(R.id.sun_set);
        cloud=view.findViewById(R.id.cloud);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cityName.setText(cityData.getName()+" ("+cityData.getCountry()+")");
        temp.setText(listData.getMain().getTemp().toString()+"°C");
        temp_min_max.setText(listData.getMain().getTempMin().toString()+"°/"+listData.getMain().getTempMax().toString()+"°");
        feel_like.setText("Feels like "+listData.getMain().getFeelsLike().toString()+"°");
        weather_desc.setText(listData.getWeather().get(0).getMain());
        temp_min.setText(listData.getMain().getTempMin().toString()+"°C");
        temp_max.setText(listData.getMain().getTempMax().toString()+"°C");
        presure.setText(listData.getMain().getPressure()+" mb");
        sea_level.setText(listData.getMain().getSeaLevel().toString()+" m");
        ground_level.setText(listData.getMain().getGrndLevel().toString()+" m");
        humidity.setText(listData.getMain().getHumidity()+"%");
        weather.setText(listData.getWeather().get(0).getMain()+" / "+listData.getWeather().get(0).getDescription());
        wind_speed.setText(listData.getWind().getSpeed()+" kph");
        wind_deg.setText(listData.getWind().getDeg()+"°");
        visibility.setText(listData.getVisibility()+" km");
        cloud.setText(listData.getClouds().getAll()+"%");
        date.setText(Utils.convertDateTime(listData.getDt()));
        sun_rise.setText(Utils.convertDateTime(Long.parseLong(cityData.getSunrise())));
        sun_set.setText(Utils.convertDateTime(Long.parseLong(cityData.getSunset())));
        int data=Utils.CreateDrawableFromdata(listData.getWeather().get(0).getMain());
        try{
                rain.setText(listData.getRain().getAll()+" mm");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        icon.setImageDrawable(getActivity().getDrawable(data));
        weather_below.setImageDrawable(getActivity().getDrawable(data));
    }
}
