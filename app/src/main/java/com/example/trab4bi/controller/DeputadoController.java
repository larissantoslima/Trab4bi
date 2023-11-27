package com.example.trab4bi.controller;
import android.content.Context;
import android.util.Log;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.DeputadoDados;
import com.example.trab4bi.retrofit.RetrofitConfig;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {
    private static DeputadoControllerListener listener;

    public interface DeputadoControllerListener {
        void onDeputadosLoaded(List<Deputado> deputados);
        void onDeputadosError(String errorMessage);
    }

    public static void setListener(DeputadoControllerListener callback) {
        listener = callback;
    }

    public static void executarAPI(Context ctx) {
        try {
            Call<List<Deputado>> call = new RetrofitConfig().deputadoService().getDeputados();

            call.enqueue(new Callback<List<Deputado>>() {
                @Override
                public void onResponse(Call<List<Deputado>> call, Response<List<Deputado>> response) {
                    if (response.isSuccessful()) {
                        List<Deputado> deputados = response.body();
                        if (listener != null) {
                            listener.onDeputadosLoaded(deputados);
                        }
                    } else {
                        if (listener != null) {
                            listener.onDeputadosError("Erro ao obter resposta da API");
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Deputado>> call, Throwable t) {
                    if (listener != null) {
                        listener.onDeputadosError("Erro ao comunicar com a API: " + t.getMessage());
                    }
                }
            });
        } catch (Exception ex) {
            String erro = ex.getMessage();
        }
    }
}
