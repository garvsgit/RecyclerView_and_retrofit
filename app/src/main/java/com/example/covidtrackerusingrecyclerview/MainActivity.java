package com.example.covidtrackerusingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.covid19india.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Request request = retrofit.create(Request.class);
//        List<Tested> testedList = new ArrayList<Tested>();
//        testedList.add(new Tested("14/09/2002","100000","3000"));

//                recyclerView.setAdapter(new DataAdapter(MainActivity.this, testedList));
        Call<Data> call = request.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                List<Tested> testedList = response.body().getTestedList();
                for(Tested t:testedList){
                    Log.i("Debug", t.getTotalpositivecases().toString());
                }
                recyclerView.setAdapter(new DataAdapter(MainActivity.this, testedList));

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.i("Failure",t.toString());
            }
        });

    }
}