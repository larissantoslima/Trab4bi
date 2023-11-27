package com.example.trab4bi.retrofit;

import com.example.trab4bi.service.DeputadoService;
import com.example.trab4bi.service.DespesaService;

import retrofit2.converter.jackson.JacksonConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitConfig {

    private final Retrofit retrofit;

    private static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
    public DeputadoService deputadoService(){
        return this.retrofit.create(DeputadoService.class);
    }
    public DespesaService despesaService(){
        return this.retrofit.create(DespesaService.class);
    }
}
