package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button INICIOSESSION;
    Button REGISTRAR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        INICIOSESSION = (Button) findViewById(R.id.btn_i);
        INICIOSESSION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent INICIOSESSION = new Intent(MainActivity.this, RECETAS.class);
                startActivity(INICIOSESSION);
            }

        });
        REGISTRAR = (Button) findViewById(R.id.btn_r);
        REGISTRAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent REGISTRAR = new Intent(MainActivity.this, REGISTRO.class);
                startActivity(REGISTRAR);
            }
        });
    }

        public void MAPA(View view){
            Intent MAPA = new Intent(this, MAPA.class);
            startActivity(MAPA);
        }


    }


