package mx.edu.ittepic.recyclerviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OEM on 01/03/2018.
*/

public class BaseDatosAlumno extends DataBaseManager {
    private static final String NOMBRE_TABLA="alumno";
    private static final String ID="_id";
    private static final String NOMBRE="nombre";
    private static final String DOMICILIO="domicilio";
    private static final String EDAD="edad";


    public static final String CREATE_TABLE = "CREATE TABLE" + NOMBRE_TABLA + " ("
            + ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + NOMBRE + " text NOT NULL, "
            + DOMICILIO + " text NULL, "
            + EDAD + " integer NULL"
            + ");";


    public BaseDatosAlumno(Context ctx) {
        super(ctx);
    }


    @Override
    public void cerrar() {
        super.getDb().close();
    }


    private ContentValues generarContentValues(String id, String name, String domicilio, String edad) {
        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, name);
        valores.put(DOMICILIO, domicilio);
        valores.put(EDAD, edad);


        return valores;
    }


    @Override
    public void insertar_4parametros(String id, String nombre, String domicilio, String edad) {
        //super.getDb().execSQL("INSERT "+);

        Log.d("alumno_insertar", super.getDb().insert(NOMBRE_TABLA, null, generarContentValues(id, nombre, domicilio, edad)) + "");
    }

    @Override
    public void actualizar_4parametros(String id, String nombre, String domicilio, String edad) {

        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, nombre);
        valores.put(DOMICILIO, domicilio);
        valores.put(EDAD, edad);

        String [] args= new String[]{id};
        Log.d("alumno_actualizar", super.getDb().update(NOMBRE_TABLA, valores, "_id=?", args)+"");
    }

    @Override
    public void eliminar(String id) {

        super.getDb().delete(NOMBRE_TABLA, ID + "=?", new String[]{id});
    }

    @Override
    public void eliminarTodo() {

        super.getDb().execSQL("DELETE FROM "+ NOMBRE_TABLA+";");
        Log.d("alumno_eliminar", "Datos borrados");

    }
    @Override
    public Cursor cargarCursor() {
        String [] columnas= new String[]{ID, NOMBRE, DOMICILIO, EDAD};


        return super.getDb().query(NOMBRE_TABLA,columnas,null,null,null,null,null );
    }



    @Override
    Boolean compruebaRegistro(String id) {

        boolean esta=true;

        Cursor resultSet= super.getDb().rawQuery("Select * from " + NOMBRE_TABLA + " WHERE " + ID + "=" + id, null);

        if(resultSet.getCount()<0)
            esta=false;
        else
            esta=true;

        return esta;

    }



    public List<Alumno> getAlumnosList(){
        List<Alumno> list= new ArrayList<>();
        Cursor c= cargarCursor();


        while (c.moveToNext()){
            Alumno alumno = new Alumno();

            alumno.setId(c.getString(0));
            alumno.setNombre(c.getString(1));
            alumno.setDomicilio(c.getString(2));
            alumno.setEdad(c.getDouble(3));


            list.add(alumno);
        }

        return list;

    }

}
