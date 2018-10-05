package com.fernet.ezequielmatiaspelozo.sharebook;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DataBaseManager {

    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;
    //para firebase
    final FirebaseDatabase database;
    private DatabaseReference myDatabase;
   // DatabaseReference ref;
    // para usar los resources como ejemplo String
    private Resources res = Resources.getSystem();

    public DataBaseManager(Context context) {

        // creamos la base de datos
        b = new BaseDeDatos(context, "Ejemplo", null, 2);
        // inicializo ContentValue
        nuevoRegistro = new ContentValues();
        //inicio firebase
        database = FirebaseDatabase.getInstance();
        myDatabase = database.getReference();

    }

   //retorno los datos de mi DB
    public String returnData(){
        // la abrimos en modo escritura

        db = b.getReadableDatabase();
        String palabra = "";

        //utilizo un cursor para recorrer mi base de datos
        Cursor cursor = db.rawQuery("SELECT * FROM Ejemplo",null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    //estoy probando que se graban los ingresos en la base
                    palabra += "Nombre: ";
                    palabra += cursor.getString(cursor.getColumnIndex("nombre"));
                    palabra += "\n";
                   // palabra += res.getString(R.string.apellido);
                    palabra += "Apellido: ";
                    palabra += cursor.getString(cursor.getColumnIndex("apellido"));
                    palabra += "\n";
                   // palabra += res.getString(R.string.edad);
                    palabra += "Edad: ";
                    palabra += cursor.getString(cursor.getColumnIndex("edad"));
                    palabra += "\n";
                   // palabra += res.getString(R.string.ubicacion);
                    palabra += "Ubicacion: ";
                    palabra += cursor.getString(cursor.getColumnIndex("ubicacion"));
                    palabra += "\n";
                    //palabra += res.getString(R.string.preferencias);
                    palabra += "Preferencias: ";
                    palabra += cursor.getString(cursor.getColumnIndex("preferencias"));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        // mostramos en el TextView de prueba

        return palabra;
    }
    //ingreso los datos de mi perfil en mi DB
    public void inputData(User user) {

        // limpiamos los TextView
        db = b.getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete("Ejemplo", null, null);

            db.setTransactionSuccessful();
        } catch (Exception e) {

        } finally {
            db.endTransaction();
        }

        // insertamos los datos en el ContentValues
        nuevoRegistro.put("nombre", user.nombre);
        nuevoRegistro.put("apellido", user.apellido);
        nuevoRegistro.put("edad",user.edad);
        nuevoRegistro.put("ubicacion", user.ubicacion);
        nuevoRegistro.put("preferencias", user.preferencias);
        // insertamos en la base
        db.insert("Ejemplo", null, nuevoRegistro);
        nuevoRegistro.clear();

        //para firebase

        DatabaseReference usersRef = myDatabase.child("users");
        Log.d("asda", "asd");
        Log.d("asda", "asd");
        Log.d("asda", "asd");
        Log.d("asda", "asd");
        Log.d("asda", usersRef.toString());
       // String value = "asdasd";
        usersRef.child(usersRef.getKey()).setValue(user);







    }
}
