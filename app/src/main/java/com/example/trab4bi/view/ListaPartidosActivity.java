package com.example.trab4bi.view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab4bi.R;
import com.example.trab4bi.adpter.DeputadoAdapter;
import com.example.trab4bi.adpter.PartidoAdapter;
import com.example.trab4bi.controller.DeputadoController;
import com.example.trab4bi.controller.PartidoController;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Partido;

import java.util.ArrayList;

public class ListaPartidosActivity extends AppCompatActivity {

    private ListView lvPartidos;
    private PartidoAdapter partidoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_partidos_activity);

        lvPartidos = findViewById(R.id.lvPartido);

        partidoAdapter = new PartidoAdapter(this, new ArrayList<>());
        lvPartidos.setAdapter(partidoAdapter);

        PartidoController.getPartidos(this, new PartidoController.PartidoCallback() {
            @Override
            public void onPartidoReceived(Partido partido) {
                partidoAdapter.add(partido);
                lvPartidos.setAdapter(partidoAdapter);
            }

            @Override
            public void onPartidoError(String errorMessage) {

            }
        });
    }
}

//