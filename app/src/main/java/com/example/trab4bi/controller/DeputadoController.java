package com.example.trab4bi.controller;
import android.content.Context;
import android.util.Log;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.retrofit.RetrofitConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {

    public interface DeputadoCallback {
        void onDeputadoReceived(Deputado deputado);
        void onDeputadoError(String errorMessage);
    }


    public static void getDeputados(Context ctx, final DeputadoCallback callback) {
        try {
            Call<Deputado> call = new RetrofitConfig().deputadoService().getDeputados();

            call.enqueue(new Callback<Deputado>() {
                @Override
                public void onResponse(Call<Deputado> call, Response<Deputado> response) {
                    Deputado dto = response.body();
                    callback.onDeputadoReceived(dto);
                }

                @Override
                public void onFailure(Call<Deputado> call, Throwable t) {
                    callback.onDeputadoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onDeputadoError(ex.getMessage());
        }
    }



    public static Deputado getDeputado(Context ctx, final DeputadoCallback callback) {
        final Deputado[] returnedDto = {null}; // Array para armazenar o DTO

        getDeputados(ctx, new DeputadoCallback() {
            @Override
            public void onDeputadoReceived(Deputado deputadoDto) {
                returnedDto[0] = deputadoDto; // Armazena o DTO retornado
                callback.onDeputadoReceived(deputadoDto); // Chama o callback
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                callback.onDeputadoError(errorMessage); // Chama o callback de erro
            }
        });

        return returnedDto[0];
    }
}