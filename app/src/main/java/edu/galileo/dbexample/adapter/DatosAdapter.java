package edu.galileo.dbexample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.galileo.dbexample.R;
import edu.galileo.dbexample.data.Datos;

/**
 * Created by jalfaro on 3/12/18.
 */

public class DatosAdapter extends ArrayAdapter<Datos>{
    private Context context;
    private int layout;
    private List<Datos> lista;
    public DatosAdapter(@NonNull Context context, int resource, @NonNull List<Datos> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.lista = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lf.inflate(layout, null);
        }
        if (lista.get(position) != null) {
            TextView nombre;
            LinearLayout layout;
            nombre =(TextView) v.findViewById(R.id.nombre_dato);
            layout = (LinearLayout) v.findViewById(R.id.layout);
            nombre.setText(lista.get(position).getNombre());
            layout.setBackgroundColor(Color.parseColor(lista.get(position).getColor()));
        }
        return v;
    }
}
