package com.example.clientapilatifahafra.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseUrlApi {
    private static final String baseURL="https://projeklatifahafra.000webhostapp.com/";
    private static Retrofit retro;
    public static Retrofit connectRetro(){
        if(retro==null){
            retro =new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

}
