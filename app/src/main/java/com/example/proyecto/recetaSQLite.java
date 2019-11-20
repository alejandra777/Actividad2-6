package com.example.proyecto;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class recetaSQLite extends SQLiteOpenHelper {
    public recetaSQLite (Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE RECETA(nombre text primary key, ingredientes text, preparacion text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int il) {

    }
}
