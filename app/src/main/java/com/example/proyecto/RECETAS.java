package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RECETAS extends AppCompatActivity {

    Button ROSCAS;
    Button BRAZO_DE_REINA;
    Button QUEQUE;
    Button CACHITOS;
    Button TORTA_DE_YOGURT;
    Button PAN_DE_PASCUA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        ROSCAS =(Button)findViewById(R.id.btn_roscas);

        ROSCAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ROSCAS= new Intent(RECETAS.this, ROSCAS.class);
                startActivity(ROSCAS);
            }

        });

        BRAZO_DE_REINA =(Button)findViewById(R.id.btn_chu);

        BRAZO_DE_REINA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BRAZO_DE_REINA= new Intent(RECETAS.this, BRAZO_DE_REINA.class);
                startActivity(BRAZO_DE_REINA);
            }

        });

        QUEQUE =(Button)findViewById(R.id.btn_queque);

        QUEQUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent QUEQUE= new Intent(RECETAS.this, QUEQUE.class);
                startActivity(QUEQUE);
            }

        });
        CACHITOS =(Button)findViewById(R.id.btn_cachitos);

        CACHITOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CACHITOS= new Intent(RECETAS.this, CACHITOS.class);
                startActivity(CACHITOS);
            }

        });
        TORTA_DE_YOGURT =(Button)findViewById(R.id.btn_ty);

        TORTA_DE_YOGURT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TORTA_DE_YOGURT= new Intent(RECETAS.this, TORTA_DE_YOGURT.class);
                startActivity(TORTA_DE_YOGURT);
            }

        });



    }
}

