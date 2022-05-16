package com.strawnetwork.weatherlocus.fragments;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.SearchRecentSuggestions;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.strawnetwork.weatherlocus.R;
import com.strawnetwork.weatherlocus.models.MainListData;
import com.strawnetwork.weatherlocus.utils.Utils;
import com.strawnetwork.weatherlocus.viewmodels.MainViewModel;

public class SearchCityFragment extends Fragment {

    private MainViewModel mViewModel;
    private SearchView searchView;
    private TextView button;
    private static String TAG="searchfrag";
    private ProgressBar progressBar;
    private View buttonView;
    public static SearchCityFragment newInstance() {
        return new SearchCityFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.search_city_layout, container, false);
        progressBar=view.findViewById(R.id.progressBar);
        searchView=view.findViewById(R.id.searchViewN);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryRefinementEnabled(true);
        searchView.requestFocus(1);
        button=view.findViewById(R.id.search_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=searchView.getQuery().toString();
                if(str.equals("")||str.equals(null)||str.length()==0)
                    Toast.makeText(getActivity(),"Please enter city name",Toast.LENGTH_SHORT).show();
                else{
                    if(str.matches("\\s+"))
                    {
                        str = str.trim();
                        // Replace All space (unicode is \\s) to %20
                        str = str.replaceAll("\\s", "%20");
                    }
                    buttonView=v;
                    getData(str.trim());
                }
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                  Log.i(TAG, "onQueryTextSubmit: Query was submitted"+query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("inside_text","text: -"+newText);
                return false;
            }
        });
        return view;
    }


    private void getData(CharSequence query) {
        progressBar.setVisibility(View.VISIBLE);
        Utils.hideKeyBoard(getActivity());
        LiveData<MainListData> data= mViewModel.getCityData(query.toString());
        data.observe(getActivity(), new Observer<MainListData>() {
            @Override
            public void onChanged(MainListData mainListData) {
                progressBar.setVisibility(View.GONE);
                try{
                    if(mainListData.getCod()!=null)
                    {
                        SearchCityFragmentDirections.ActionSearchCityFragmentToListLayout action=SearchCityFragmentDirections.actionSearchCityFragmentToListLayout(mainListData);
                        Navigation.findNavController(buttonView).navigate(action);
                    }
                }catch (Exception e)
                {
                    Log.d("inside_excep","ex:- "+e.getLocalizedMessage());
                    Toast.makeText(getActivity(),"Please enter valid city name.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}