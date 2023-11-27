package com.example.trab4bi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trab4bi.R;

public class MainActivity extends AppCompatActivity {
    private Button btnDeputados;
    private Button btnPartidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDeputados = findViewById(R.id.btDeputados);
        btnPartidos = findViewById(R.id.btPartidos);

        btnDeputados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListaDeputadosActivity.class);
                startActivity(intent);
            }
        });

        btnPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListaPartidosActivity.class);
                startActivity(intent);
            }
        });
    }

}