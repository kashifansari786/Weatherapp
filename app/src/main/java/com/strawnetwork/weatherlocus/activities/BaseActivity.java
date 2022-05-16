package com.strawnetwork.weatherlocus.activities;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.strawnetwork.weatherlocus.R;

public class BaseActivity extends AppCompatActivity {

    public void changeStatusColor(Activity activity)
    {
        Window window = activity.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(activity, R.color.primary_dark));
    }
}
