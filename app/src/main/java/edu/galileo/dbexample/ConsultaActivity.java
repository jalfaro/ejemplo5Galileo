package edu.galileo.dbexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import edu.galileo.dbexample.adapter.DatosAdapter;
import edu.galileo.dbexample.data.Datos;
import edu.galileo.dbexample.utilities.DBUtility;

/**
 * Created by jalfaro on 3/12/18.
 */

public class ConsultaActivity extends AppCompatActivity {
    private ListView lista;
    private DBUtility dbUtility;
    private List<Datos> listaDatos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_layout);
        lista = (ListView) findViewById(R.id.lst_datos);
        dbUtility = new DBUtility(this);
        listaDatos = dbUtility.getDatos();
        lista.setAdapter(new DatosAdapter(this, R.layout.row_datos_layout, listaDatos));
    }
}
