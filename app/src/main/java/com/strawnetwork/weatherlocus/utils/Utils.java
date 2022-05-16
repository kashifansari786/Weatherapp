package com.strawnetwork.weatherlocus.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.strawnetwork.weatherlocus.R;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static void hideKeyBoard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private static String convertDateyear(String data)
    {
        String[] space=data.split("\\s+");
        String date=space[0];
        String time=space[1];

        String[] splitDate=date.split("-");
        String year=splitDate[0];
        String month=splitDate[1];
        String day=splitDate[2];

        String[] timesplit=time.split(":");
        String hour=timesplit[0];
        String min=timesplit[1];
        String sec=timesplit[2];

        String realMonth=null;
        switch (month)
        {
            case "01":
                realMonth="Jan";
                break;
            case "02":
                realMonth="Feb";
                break;
            case "03":
                realMonth="Mar";
                break;
            case "04":
                realMonth="Apr";
                break;
            case "05":
                realMonth="May";
                break;
            case "06":
                realMonth="Jun";
                break;
            case "07":
                realMonth="Jul";
                break;
            case "08":
                realMonth="Aug";
                break;
            case "09":
                realMonth="Sep";
                break;
            case "10":
                realMonth="Oct";
                break;
            case "11":
                realMonth="Nov";
                break;
            case "12":
                realMonth="Dec";
                break;
        }
        String ampm="AM";
        int hourset=Integer.parseInt(hour);
        String realhour=null;
        if(hourset>12)
        {
            ampm="PM";
            realhour=String.valueOf(hourset-12);

        }else
            realhour=hour;
        String dateof=day+" "+realMonth+" "+year+" "+realhour+":"+min+":"+sec+" "+ampm;
        return dateof;
    }
    public static String convertDateTime(long sunrise)
    {
        Timestamp timestamp = new Timestamp(sunrise* 1000L);
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        // S is the millisecond
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Log.d("inside_times","time:- "+simpleDateFormat.format(timestamp)+", "+simpleDateFormat.format(date)+", "+date+", "+simpleDateFormat.format(calendar.getTime())+", "+calendar);

        return convertDateyear(simpleDateFormat.format(timestamp));

    }
    public static int CreateDrawableFromdata(String condition)
    {
        Log.d("inside_condition","cond: -"+condition);
        int drawable=0;
        switch (condition)
        {
            case "Clear":
                drawable= R.mipmap.w_clear;
                break;
            case "Clouds":
                drawable=R.mipmap.w_cloud;
                break;
            case "Rain":
                drawable=R.mipmap.w_rain;
                break;
            case "Mist":
                drawable=R.mipmap.w_mist;
                break;
            case "Shower":
                drawable=R.mipmap.w_shower;
                break;
            case "Snow":
                drawable=R.mipmap.w_snow;
                break;
            default:
                drawable= R.mipmap.w_clear;
        }
        return drawable;
    }






}
