package com.ph.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
List<ModelClass> data;
AdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     recyclerView=findViewById(R.id.Rv);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitApi retrofitApi=retrofit.create(RetrofitApi.class);
        Call<List<ModelClass>> call=retrofitApi.getModelClass();
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
            data=response.body();
            adapterClass=new AdapterClass(data);



            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "There is an error", Toast.LENGTH_SHORT).show();
            }
        });




    }
}