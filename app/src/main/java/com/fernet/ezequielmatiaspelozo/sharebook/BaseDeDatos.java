package com.fernet.ezequielmatiaspelozo.sharebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    // string con la instruccion para crear la base de datos
    String sqlCreate ="CREATE TABLE Ejemplo(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,apellido TEXT, edad TEXT, ubicacion TEXT," +
            " preferencias TEXT)";
    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // se crea la base de datos
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // En este ejemplo se pierden todos los datos de la tabla
        // se deberφa hacer un bkup
        db.execSQL("DROP TABLE IF EXISTS Ejemplo");
        db.execSQL(sqlCreate);
    }
}
