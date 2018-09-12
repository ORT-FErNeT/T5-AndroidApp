package com.fernet.ezequielmatiaspelozo.sharebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<Libro> {


    public UserAdapter(@NonNull Context context, @NonNull ArrayList<Libro> libros) {
        super(context, 0,libros);
    }
   /* public UserAdapter(@NonNull Context context, int resource, @NonNull List<Libro> objects) {
        super(context, resource, objects);
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Libro libro = (Libro) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_libro_list, parent, false);
        }
        // Lookup view for data population
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre_de_libro);
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imagen_de_libro);


        // Populate the data into the template view using the data object
        // aca ojo tuve problemas al pasar el dato que correspondia
        nombre.setText(libro.nombre);
        imagen.setImageResource(libro.imagen);



        // Return the completed view to render on screen*/
        return convertView;

    }

}
