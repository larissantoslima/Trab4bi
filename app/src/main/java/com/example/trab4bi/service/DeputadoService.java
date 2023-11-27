package com.example.trab4bi.service;

import com.example.trab4bi.model.Deputado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DeputadoService {

    @GET("deputados")
    Call<List<Deputado>> getDeputados();
}
