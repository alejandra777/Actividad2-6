package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ver = (Button) findViewById(R.id.btn_ver);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ver = new Intent(MainActivity.this, RECETAS.class);
                startActivity(ver);
            }

        });


    }






        public void MAPA(View view){
            Intent MAPA = new Intent(this, MAPA.class);
            startActivity(MAPA);
        }


    }


