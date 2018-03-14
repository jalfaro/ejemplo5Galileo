package edu.galileo.dbexample.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.galileo.dbexample.data.Datos;

/**
 * Created by jalfaro on 3/12/18.
 */

public class DBUtility {
    public static final String DBNAME = "ejemplo";
    public static final int DBVER = 1;

    private DBHelper conn;
    private Context context;

    public DBUtility(Context context) {
        this.context = context;
        conn = new DBHelper(context);
    }

    public void insertDatos (Datos item) {
       SQLiteDatabase db =  conn.getWritableDatabase();
       String query = "Insert INTO datos (nombre, color) VALUES ('" + item.getNombre() + "', '" + item.getColor() +"')";
       db.execSQL(query);
       db.close();
    }

    public List<Datos> getDatos() {
        List<Datos> lista = null;
        Datos item;
        Cursor c;
        SQLiteDatabase db = conn.getWritableDatabase();
        String query = "Select id, nombre, color FROM datos";
        c = db.rawQuery(query, null);
        if (c != null ) {
            if (c.getCount() > 0) {
                c.moveToFirst();
                lista = new ArrayList<Datos>();
                while (!c.isAfterLast()) {
                    item = new Datos();
                    item.setColor(c.getString(c.getColumnIndex("color")));
                    item.setNombre(c.getString(c.getColumnIndex("nombre")));
                    item.setId(c.getInt(c.getColumnIndex("id")));
                    lista.add(item);
                    c.moveToNext();
                }
            }
        }
        return lista;
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DBNAME, null, DBVER);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE datos ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, color TEXT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
