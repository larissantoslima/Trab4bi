package com.example.trab4bi.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab4bi.R;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.Deputado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListaDespesasDeputadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_despesas_deputado_activity);

        String deputadoJson = getIntent().getStringExtra("deputadoJson");
        ObjectMapper objectMapper = new ObjectMapper();
        DadosDeputados dadosDeputados = new DadosDeputados();
        try {
            dadosDeputados = objectMapper.readValue(deputadoJson, DadosDeputados.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(dadosDeputados.getNome());



    }
}
