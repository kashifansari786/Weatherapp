package com.strawnetwork.weatherlocus.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.strawnetwork.weatherlocus.models.MainListData;
import com.strawnetwork.weatherlocus.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<MainListData> mainList=new MutableLiveData<>();
    public LiveData<MainListData> getCityData(String query){
        Call<MainListData> call=RetrofitClient.getInstance().getMyApi().getWeatherData(query,"65d00499677e59496ca2f318eb68c049");
        call.enqueue(new Callback<MainListData>() {
            @Override
            public void onResponse(Call<MainListData> call, Response<MainListData> response) {
                Log.d("inside_changed","onresponce");
                mainList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<MainListData> call, Throwable t) {
                Log.d("inside_changed","onfail:- "+t.getLocalizedMessage());
                mainList.postValue(null);
            }
        });

        return mainList;
    }
}