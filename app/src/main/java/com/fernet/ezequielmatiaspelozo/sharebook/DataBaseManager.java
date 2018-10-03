package com.fernet.ezequielmatiaspelozo.sharebook;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseManager {

    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;
    //para firebase
    private DatabaseReference myDatabase;
    // para usar los resources como ejemplo String
    private Resources res = Resources.getSystem();

    public DataBaseManager(Context context) {

        // creamos la base de datos
        b = new BaseDeDatos(context, "Ejemplo", null, 2);
        // inicializo ContentValue
        nuevoRegistro = new ContentValues();
        //inicio firebase
        myDatabase = FirebaseDatabase.getInstance().getReference();
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
    public void inputData(String nombre, String apellido, String edad, String ubicacion, String preferencias) {

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
        nuevoRegistro.put("nombre", nombre);
        nuevoRegistro.put("apellido", apellido);
        nuevoRegistro.put("edad", edad);
        nuevoRegistro.put("ubicacion", ubicacion);
        nuevoRegistro.put("preferencias", preferencias);
        // insertamos en la base
        db.insert("Ejemplo", null, nuevoRegistro);
        nuevoRegistro.clear();

        //para firbase
        User user = new User(nombre, apellido, edad, ubicacion, preferencias);
        myDatabase.child("users").child(nombre).setValue(user);

    }
}
