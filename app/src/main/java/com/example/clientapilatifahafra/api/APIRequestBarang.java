package com.example.clientapilatifahafra.api;

import com.example.clientapilatifahafra.model.RetroModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestBarang {
    @GET("selectbarang.php")
    Call<RetroModel> callBarang();

    @FormUrlEncoded
    @POST("insertbarang.php")
    Call<RetroModel> insert(
            @Field("nama") String nama,
            @Field("keterangan") String keterangan,
            @Field("harga") String harga
    );

}
