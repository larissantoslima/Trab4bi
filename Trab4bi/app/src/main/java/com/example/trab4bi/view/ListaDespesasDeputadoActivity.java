package com.example.trab4bi.view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab4bi.R;
import com.example.trab4bi.adpter.DeputadoAdapter;
import com.example.trab4bi.adpter.DespesaAdapter;
import com.example.trab4bi.controller.DeputadoController;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class ListaDespesasDeputadoActivity extends AppCompatActivity {

    private ListView lvDespesas;
    private DespesaAdapter despesaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_despesas_deputado_activity);

        lvDespesas = findViewById(R.id.lvDespesas);

        despesaAdapter = new DespesaAdapter(this, new ArrayList<>());
        lvDespesas.setAdapter(despesaAdapter);

        String deputadoJson = getIntent().getStringExtra("deputadoJson");
        ObjectMapper objectMapper = new ObjectMapper();
        DadosDeputados dadosDeputados = new DadosDeputados();
        try {
            dadosDeputados = objectMapper.readValue(deputadoJson, DadosDeputados.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(dadosDeputados.getNome());
        carregaDespesas((int) dadosDeputados.getId());


    }

    private void carregaDespesas(int deputadoId) {
        DeputadoController.getDespesasDeputado(this, deputadoId, new DeputadoController.DeputadoCallback() {
            @Override
            public void onDeputadoReceived(Deputado deputado) {}

            @Override
            public void onDeputadoError(String errorMessage) {}

            @Override
            public void onDespesasReceived(Despesa despesa) {
                despesaAdapter.add(despesa.getDados());
                lvDespesas.setAdapter(despesaAdapter);
            }

        });
    }
}
