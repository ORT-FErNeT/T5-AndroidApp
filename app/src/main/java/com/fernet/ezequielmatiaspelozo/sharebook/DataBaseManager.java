package com.fernet.ezequielmatiaspelozo.sharebook;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class DataBaseManager {

    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;
    //para firebase
    final FirebaseDatabase database;
    private DatabaseReference myDatabase;
    private DatabaseReference usersRef;
    private DatabaseReference bookUserDeseadosRef;
    private DatabaseReference bookUserPrestadosRef;
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
        usersRef = myDatabase.child("users");
        bookUserDeseadosRef = myDatabase.child("users_libros_deseados");
        bookUserPrestadosRef = myDatabase.child("users_libros_prestados");

    }

    //retorno los datos de mi DB
    public String returnData(){

        // la abrimos en modo escritura
        db = b.getReadableDatabase();
        String palabra = "";

        //Para Database
        // Attach a listener to read the data at our posts reference
        DatabaseReference ref = database.getReference("users/users");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                System.out.println("User " +  user.getNombre());
                System.out.println("User " +  user.getApellido());
                //ahora deberia guardar lo que se cambio en mi base local para luego levantarlo de ahi
                modify(user);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });


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

         modify(user);

        //para firebase
       //guardo en FireBase
        Log.d("test", usersRef.toString());
        usersRef.child(usersRef.getKey()).setValue(user);
        }
        
        //agrego un metodo para modificar

    public void modify(User user) {

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
        nuevoRegistro.put("nombre", user.getNombre());
        nuevoRegistro.put("apellido", user.getApellido());
        nuevoRegistro.put("edad",user.getEdad());
        nuevoRegistro.put("ubicacion", user.getUbicacion());
        nuevoRegistro.put("preferencias", user.getPreferencias());
        // insertamos en la base
        db.insert("Ejemplo", null, nuevoRegistro);
        nuevoRegistro.clear();
    }
    //
    public void saveWishedBook(String username, String libro,String estado) {
       UsuarioLibro miLibro = new UsuarioLibro(libro,username,estado);

        try {
            if (estado == "PRESTADO") {
                DatabaseReference ref = bookUserPrestadosRef.push();
                ref.setValue(miLibro);
            }
            if (estado == "DESEADO") {
                //bookUserDeseadosRef.setValue(miLibro);
                DatabaseReference ref = bookUserDeseadosRef.push();
                ref.setValue(miLibro);
            }
        } catch (Exception e) {
            Log.e("test", e.getMessage());
        }

    }
}
