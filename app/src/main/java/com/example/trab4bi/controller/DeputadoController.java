package com.example.trab4bi.controller;
import android.content.Context;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;
import com.example.trab4bi.retrofit.RetrofitConfig;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {

    public interface DeputadoCallback {
        void onDeputadoReceived(Deputado deputado);
        void onDeputadoError(String errorMessage);

        void onDespesasReceived(Despesa despesa);
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
        final Deputado[] returnedDto = {null};

        getDeputados(ctx, new DeputadoCallback() {
            @Override
            public void onDeputadoReceived(Deputado deputado) {
                returnedDto[0] = deputado;
                callback.onDeputadoReceived(deputado);
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                callback.onDeputadoError(errorMessage);
            }

            @Override
            public void onDespesasReceived(Despesa despesa) {

            }
        });

        return returnedDto[0];
    }


    public static void getDespesasDeputado(Context ctx, int deputadoId, final DeputadoCallback callback) {
        try {
            Call<Despesa> call = new RetrofitConfig().deputadoService().getDespesas(deputadoId);

            call.enqueue(new Callback<Despesa>() {
                @Override
                public void onResponse(Call<Despesa> call, Response<Despesa> response) {
                    Despesa despesa = response.body();
                    callback.onDespesasReceived(despesa);
                }

                @Override
                public void onFailure(Call<Despesa> call, Throwable t) {
                    callback.onDeputadoError(t.getMessage());
                }
            });

        } catch (Exception ex) {
            callback.onDeputadoError(ex.getMessage());
        }
    }
}