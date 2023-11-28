package com.example.trab4bi.controller;

import android.content.Context;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Partido;
import com.example.trab4bi.retrofit.RetrofitConfig;
import com.example.trab4bi.service.PartidoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartidoController {

    public interface PartidoCallback {
        void onPartidoReceived(Partido partido);

        void onPartidoError(String errorMessage);
    }


    public static void getPartidos(Context ctx, final PartidoController.PartidoCallback callback) {
        try {
            Call<Partido> call = new RetrofitConfig().partidoService().getPartidos();

            call.enqueue(new Callback<Partido>() {
                @Override
                public void onResponse(Call<Partido> call, Response<Partido> response) {
                    System.out.println(response);
                    Partido dto = response.body();
                    callback.onPartidoReceived(dto);
                }

                @Override
                public void onFailure(Call<Partido> call, Throwable t) {
                    System.out.println(t);
                    callback.onPartidoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onPartidoError(ex.getMessage());
        }
    }
}
