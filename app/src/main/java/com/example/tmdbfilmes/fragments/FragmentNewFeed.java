package com.example.tmdbfilmes.fragments;


import android.media.midi.MidiOutputPort;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmdbfilmes.R;
import com.example.tmdbfilmes.adapter.AdapterRecyclerView;
import com.example.tmdbfilmes.model.MovePojo;
import com.example.tmdbfilmes.model.Result;
import com.example.tmdbfilmes.service.RetrofitConfig;
import com.example.tmdbfilmes.service.ServiceGet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNewFeed extends Fragment {

    View view;
    public String API_kEY = "dd18aa9abf33b4094e0408957731ae35";
    public String Language = "pt-Br";
    public String category = "now_playing";
    public String region = "BR";
    public int page = 1;
    public List<Result> resultList;


    public FragmentNewFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment_new_feed,container,false);
        ServiceGet service = RetrofitConfig.getRetrofit().create(ServiceGet.class);
        Call<MovePojo> call = service.getMovies(category,API_kEY,Language,page,region);

        call.enqueue(new Callback<MovePojo>() {
            @Override
            public void onResponse(Call<MovePojo> call, Response<MovePojo> response) {

                resultList = response.body().getResults();
                RecyclerView recyclerView = view.findViewById(R.id.recycler_feed);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                AdapterRecyclerView adapterRecyclerview = new AdapterRecyclerView(resultList,view.getContext());
                recyclerView.setAdapter(adapterRecyclerview);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<MovePojo> call, Throwable t) {

            }
        });
        return view;
    }

}


