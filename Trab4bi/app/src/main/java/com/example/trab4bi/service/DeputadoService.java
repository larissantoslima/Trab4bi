package com.example.trab4bi.service;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeputadoService {

    @GET("deputados")
    Call<Deputado> getDeputados();

    @GET("deputados/{id}/despesas")
    Call<Despesa> getDespesas(@Path("id") int id);
}
