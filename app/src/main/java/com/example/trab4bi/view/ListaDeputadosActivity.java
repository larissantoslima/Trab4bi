package com.example.trab4bi.view;

import static com.example.trab4bi.R.id.lvDeputados;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
                deputadoAdapter.add(deputado);
                lvDeputados.setAdapter(deputadoAdapter);
            }

            @Override
            public void onDeputadoError(String errorMessage) {

            }
        });

        lvDeputados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getAdapter().getCount();
                Deputado deputadoSelecionado = (Deputado) adapterView.getAdapter().getItem(i);
                // Agora, deputadoSelecionado contém o objeto Deputado clicado
                System.out.println(i);
                System.out.println(adapterView.getAdapter().getCount());

                //abrirDetalhesDeputado(deputadoSelecionado);
            }
        });

    }

    private void abrirDetalhesDeputado(Deputado deputado) {
        // Converter o objeto Deputado para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String deputadoJson = objectMapper.writeValueAsString(deputado);

            // Passar a string JSON como extra
            Intent intent = new Intent(this, ListaDespesasDeputadoActivity.class);
            intent.putExtra("deputadoJson", deputadoJson);
            startActivity(intent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
