package com.example.trab4bi.view;

import static com.example.trab4bi.R.id.lvDeputados;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab4bi.R;
import com.example.trab4bi.adpter.DeputadoAdapter;
import com.example.trab4bi.controller.DeputadoController;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Despesa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ListaDeputadosActivity extends AppCompatActivity  {

    private ListView lvDeputados;
    private DeputadoAdapter deputadoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_deputado_activity);
        lvDeputados = findViewById(R.id.lvDeputados);

        deputadoAdapter = new DeputadoAdapter(this, new ArrayList<>());
        lvDeputados.setAdapter(deputadoAdapter);


        // Executar a chamada à API
        DeputadoController.getDeputados(this, new DeputadoController.DeputadoCallback() {
            @Override
            public void onDeputadoReceived(Deputado deputado) {
                deputadoAdapter.add(deputado.getDados());
                lvDeputados.setAdapter(deputadoAdapter);
            }

            @Override
            public void onDeputadoError(String errorMessage) {

            }

            @Override
            public void onDespesasReceived(Despesa despesa) {

            }
        });

        lvDeputados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                DadosDeputados deputadoSelecionado = (DadosDeputados) adapterView.getAdapter().getItem(i);

                abrirDetalhesDeputado(deputadoSelecionado);
            }
        });


    }

    private void abrirDetalhesDeputado(DadosDeputados dadosDeputados) {
        // Converter o objeto Deputado para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String deputadoJson = objectMapper.writeValueAsString(dadosDeputados);

            // Passar a string JSON como extra
            Intent intent = new Intent(this, ListaDespesasDeputadoActivity.class);
            intent.putExtra("deputadoJson", deputadoJson);
            startActivity(intent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
