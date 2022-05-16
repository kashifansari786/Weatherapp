package com.strawnetwork.weatherlocus.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.strawnetwork.weatherlocus.OnClickInterface;
import com.strawnetwork.weatherlocus.R;
import com.strawnetwork.weatherlocus.fragments.adapter.ListAdapter;
import com.strawnetwork.weatherlocus.models.ListData;
import com.strawnetwork.weatherlocus.models.MainListData;

import java.util.List;

public class ListFragment extends Fragment implements OnClickInterface {

    private MainListData listData;
    private RecyclerView listRecycler;
    private TextView cityName;
    private ImageView backbutton;
    private ListAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listData=ListFragmentArgs.fromBundle(getArguments()).getDataList();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_layout,container,false);
        cityName=view.findViewById(R.id.cityName);
        cityName.setText(listData.getCity().getName());
        backbutton=view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
        listRecycler=view.findViewById(R.id.listRecycler);
        listRecycler.setHasFixedSize(true);
        listRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new ListAdapter(getActivity(), listData.getList());
        adapter.onClickAdapter(this::OnClickAdapter);
        listRecycler.setAdapter(adapter);
        return view;
    }

    @Override
    public void OnClickAdapter(View view,ListData data) {
        ListFragmentDirections.ActionListLayoutToDeatil action=ListFragmentDirections.actionListLayoutToDeatil(data,listData.getCity());
        Navigation.findNavController(view).navigate(action);
    }
}
