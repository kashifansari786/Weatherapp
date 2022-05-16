package com.strawnetwork.weatherlocus.fragments.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.strawnetwork.weatherlocus.OnClickInterface;
import com.strawnetwork.weatherlocus.R;
import com.strawnetwork.weatherlocus.fragments.ListFragment;
import com.strawnetwork.weatherlocus.models.ListData;
import com.strawnetwork.weatherlocus.models.MainListData;
import com.strawnetwork.weatherlocus.utils.Utils;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListData> data;
    private Context context;
    private OnClickInterface clickInterface;

    public void onClickAdapter(OnClickInterface inter)
    {
        this.clickInterface=inter;
    }
    public ListAdapter(Activity activity, List<ListData> listData) {
        this.context=activity;
        this.data=listData;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.data_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListData listData=data.get(position);
        int temp=listData.getMain().getTemp().intValue();
        holder.temp.setText(temp+" °C");
        holder.weather.setText(listData.getWeather().get(0).getMain());
        holder.wind.setText(listData.getWind().getSpeed()+" Kmph");
        holder.update.setText("Updated At:- "+ Utils.convertDateTime(listData.getDt()));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.OnClickAdapter(v,listData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView temp,weather,wind,update;
        private RelativeLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
            temp=itemView.findViewById(R.id.temp);
            weather=itemView.findViewById(R.id.weather);
            wind=itemView.findViewById(R.id.wind);
            update=itemView.findViewById(R.id.update);
        }
    }
}
