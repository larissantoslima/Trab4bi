package com.example.trab4bi.service;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Partido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PartidoService {
    @GET("partidos")
    Call<Partido> getPartidos();
}
