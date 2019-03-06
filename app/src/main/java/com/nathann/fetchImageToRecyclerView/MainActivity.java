package com.nathann.fetchImageToRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImageUrl  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Call<List<Hero>> call = api.getHeros();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                Toast.makeText(getApplicationContext(),"SUCCESS READING FROM API",Toast.LENGTH_LONG).show();
                List<Hero> list = response.body();

                //test
                for(Hero h : list){
                    mImageUrl.add(h.imageurl);
                }

                //create rec view stuff
                RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImageUrl,MainActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"FAILURE READING FROM API",Toast.LENGTH_LONG).show();
            }
        });

    }



}
