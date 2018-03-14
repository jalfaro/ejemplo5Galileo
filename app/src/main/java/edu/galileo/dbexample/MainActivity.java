package edu.galileo.dbexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.dbexample.data.Datos;
import edu.galileo.dbexample.utilities.DBUtility;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nombre, color;
    private Button guardar, consultar;
    private DBUtility dbUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        dbUtility = new DBUtility(this);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        color = (EditText) findViewById(R.id.txt_color);
        guardar = (Button) findViewById(R.id.btn_guardar);
        consultar = (Button) findViewById(R.id.btn_consultar);

        guardar.setOnClickListener(this);
        consultar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Datos elemento;
        if (v.getId() == R.id.btn_guardar) {
            elemento = new Datos();
            elemento.setNombre(nombre.getText().toString());
            elemento.setColor(color.getText().toString());
            dbUtility.insertDatos(elemento);
            nombre.setText("");
            color.setText("");
            Toast.makeText(this,"Dato insertado con exito", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.btn_consultar) {
            Intent intent = new Intent(this, ConsultaActivity.class);
            startActivity(intent);
        }
    }
}
