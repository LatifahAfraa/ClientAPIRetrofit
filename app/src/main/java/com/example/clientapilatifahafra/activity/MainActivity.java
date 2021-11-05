package com.example.clientapilatifahafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.clientapilatifahafra.R;
import com.example.clientapilatifahafra.adapter.BarangAdapter;
import com.example.clientapilatifahafra.api.APIRequestBarang;
import com.example.clientapilatifahafra.api.BaseUrlApi;
import com.example.clientapilatifahafra.model.BarangModel;
import com.example.clientapilatifahafra.model.RetroModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerviewadapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<BarangModel> barang;
    private FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyler);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        fab = findViewById(R.id.tambah);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tampilData();
    }
    protected void tampilData(){
        APIRequestBarang apiTampil = BaseUrlApi.connectRetro().create(APIRequestBarang.class);
        Call<RetroModel> tampil = apiTampil.callBarang();
        tampil.enqueue(new Callback<RetroModel>() {
            @Override
            public void onResponse(Call<RetroModel> call, Response<RetroModel> response) {
                int kode = response.body().getKode();
                Toast.makeText(MainActivity.this, "Kode : " + kode, Toast.LENGTH_SHORT).show();
                barang = response.body().getHasil();
                recyclerviewadapter = new BarangAdapter(MainActivity.this, barang);
                recyclerView.setAdapter(recyclerviewadapter);
                recyclerviewadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RetroModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal : " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}