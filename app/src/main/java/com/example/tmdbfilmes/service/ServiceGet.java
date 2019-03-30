package com.example.tmdbfilmes.service;

import com.example.tmdbfilmes.model.MovePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceGet {

    @GET("/3/movie/{category}")
    Call<MovePojo> getMovies(
            @Path("category")String category,
            @Query("api_key")String api_Key,
            @Query("language")String language,
            @Query("page")int page,
            @Query("region") String region

    );
}
