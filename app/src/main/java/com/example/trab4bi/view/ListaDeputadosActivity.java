package com.example.trab4bi.view;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trab4bi.R;
import com.example.trab4bi.adpter.DeputadoAdapter;
import com.example.trab4bi.controller.DeputadoController;
import com.example.trab4bi.model.Deputado;

import java.util.ArrayList;
import java.util.List;

public class ListaDeputadosActivity extends AppCompatActivity implements DeputadoController.DeputadoControllerListener {

    private ListView lvDeputados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_deputado_activity);
        lvDeputados = findViewById(R.id.lvDeputados);

        DeputadoController.setListener(this);
        inicializaTela();
    }

    private void inicializaTela() {
        DeputadoController.executarAPI(this);
    }

    @Override
    public void onDeputadosLoaded(List<Deputado> deputados) {
        // Aqui você pode usar a lista de deputados para preencher o ListView
        DeputadoAdapter adapter = new DeputadoAdapter(this, deputados);
        lvDeputados.setAdapter(adapter);
    }

    @Override
    public void onDeputadosError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
