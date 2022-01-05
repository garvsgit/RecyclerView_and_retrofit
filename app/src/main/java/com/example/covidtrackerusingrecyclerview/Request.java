package com.example.covidtrackerusingrecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Request {
    @GET("data.json")
    Call<Data> getData();
}
