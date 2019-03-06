package com.nathann.fetchImageToRecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    final String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeros();

}
