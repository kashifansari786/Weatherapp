package com.strawnetwork.weatherlocus.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.strawnetwork.weatherlocus.R;
import com.strawnetwork.weatherlocus.fragments.SearchCityFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusColor(this);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            NavController navController = Navigation.findNavController(MainActivity.this, R.id.activity_root__fragment__nav_host);
            navController.navigateUp();
            navController.navigate(R.id.SearchCityFragment);
        }
    }
}