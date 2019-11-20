package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.database.Cursor;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RECETAS extends AppCompatActivity {
    private EditText nom, ing, pre;
    private Button btn_agregar, btn_editar, btn_eliminar, btn_mostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        nom = (EditText) findViewById(R.id.nom);
        ing = (EditText) findViewById(R.id.ing);
        pre = (EditText) findViewById(R.id.pre);

        btn_agregar = (Button)findViewById(R.id.btn_agregar);
        btn_editar = (Button)findViewById(R.id.btn_editar);
        btn_eliminar= (Button)findViewById(R.id.btn_eliminar);
        btn_mostrar  = (Button)findViewById(R.id.btn_mostrar);

    }


    public void agregar(View view) {
        recetaSQLite admin = new recetaSQLite(this, "jefe", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = nom.getText().toString();
        String ingredientes = ing.getText().toString();
        String preparacion = pre.getText().toString();
        if (!nombre.isEmpty() && !ingredientes.isEmpty() && !preparacion.isEmpty()) {
            ContentValues agregar = new ContentValues();

            agregar.put("nombre", nombre);
            agregar.put("ingredientes", ingredientes);
            agregar.put("preparacion", preparacion);

            bd.insert("RECETA", null, agregar);

            bd.close();
            nom.setText("");
            ing.setText("");
            pre.setText("");

            Toast.makeText(this, "Receta agregada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void editar(View view) {
        recetaSQLite admin = new recetaSQLite(this, "jefe", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = nom.getText().toString();
        String ingredientes = ing.getText().toString();
        String preparacion = pre.getText().toString();
        if (!nombre.isEmpty() && !ingredientes.isEmpty() && !preparacion.isEmpty()) {
            ContentValues editar = new ContentValues();

            editar.put("nombre", nombre);
            editar.put("ingredientes", ingredientes);
            editar.put("preparacion", preparacion);

            int receta = bd.update("RECETA", editar, "nombre=" + nombre, null);
            bd.close();

            if (receta == 1) {
                Toast.makeText(this, "Receta modificada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "La receta no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Eliminar(View view) {
        recetaSQLite admin = new recetaSQLite(this, "jefe", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = nom.getText().toString();
        if (!nombre.isEmpty()) {

            int receta = bd.delete("RECETA", "nomnbre=" + nombre, null);
            bd.close();
            nom.setText("");
            ing.setText("");
            pre.setText("");

            if (receta == 1) {
                Toast.makeText(this, "Receta eliminada ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "La receta no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "porfavor coloque el nombre de la receta", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrar(View view) {
        recetaSQLite admin = new recetaSQLite(this, "jefe", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = nom.getText().toString();
        if (!nombre.isEmpty()) {
            Cursor orden = bd.rawQuery
                    ("select  nombre, ingrediente, preparacion from RECETA where nombre =" + nombre, null);

            if (orden.moveToFirst()) {
                nom.setText(orden.getString(0));
                ing.setText(orden.getString(1));
                pre.setText(orden.getString(2));
                bd.close();
            }else {
                Toast.makeText(this, "Receta no registrada", Toast.LENGTH_SHORT).show();
                bd.close();
            }
        } else {
            Toast.makeText(this, "Introduzca el nombre de la receta", Toast.LENGTH_SHORT).show();
        }

    }
}









