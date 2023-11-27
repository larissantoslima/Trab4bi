package com.example.trab4bi.service;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DespesaService {

        @GET("deputado/{id}/despesa")
        Call<Despesa> getDespesas(@Path("id")Long id);

}
