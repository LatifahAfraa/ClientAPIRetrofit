package com.example.clientapilatifahafra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clientapilatifahafra.R;
import com.example.clientapilatifahafra.api.APIRequestBarang;
import com.example.clientapilatifahafra.api.BaseUrlApi;
import com.example.clientapilatifahafra.model.RetroModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    EditText etnama, etketerangan, etharga;
    Button btntambah;
    String nama, keterangan, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        etnama = findViewById(R.id.etnama);
        etketerangan = findViewById(R.id.etketerangan);
        etharga = findViewById(R.id.etharga);
        btntambah = findViewById(R.id.btntambah);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = etnama.getText().toString();
                keterangan = etketerangan.getText().toString();
                harga = etharga.getText().toString();
                if (nama.equals("")){
                    etnama.setError("Nama Harus diisi");
                } else if (keterangan.equals("")) {
                    etketerangan.setError("Keterangan Harus diisi");
                } else if (harga.equals("")) {
                    etharga.setError("Harga Harus diisi");
                } else {
                    insertData();
                }
            }
        });
    }

    protected void insertData(){
        APIRequestBarang apiTambah = BaseUrlApi.connectRetro().create(APIRequestBarang.class);
        Call<RetroModel> tambah = apiTambah.insert(nama, keterangan, harga);
        tambah.enqueue(new Callback<RetroModel>() {
            @Override
            public void onResponse(Call<RetroModel> call, Response<RetroModel> response) {
                int kode = response.body().getKode();
                if(kode == 1){
                    Toast.makeText(TambahActivity.this, "Data Sudah Ditambah", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<RetroModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}