package com.example.trab4bi.controller;

import android.content.Context;
import android.util.Log;

import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;
import com.example.trab4bi.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DespesaController {

    public static void executarAPI(Context ctx, Long id){
        try{
            Call<Despesa> call = new RetrofitConfig()
                    .despesaService().getDespesas(id);

            call.enqueue(new Callback<Despesa>() {
                @Override
                public void onResponse(Call<Despesa> call,
                                       Response<Despesa> response) {
                    Despesa dto = response.body();
                    String teste = "teste";
                }


                @Override
                public void onFailure(Call<Despesa> call, Throwable t) {
                    Log.e("TESTE",
                            "Erro ao comunicar com a API: "+t.getMessage());
                }
            });


        }catch (Exception ex){
            String erro = ex.getMessage();
        }
    }
}
