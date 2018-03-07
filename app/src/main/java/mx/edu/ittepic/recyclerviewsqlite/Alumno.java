package mx.edu.ittepic.recyclerviewsqlite;

/**
 * Created by OEM on 01/03/2018.
*/

public class Alumno {

    private String id;
    private String nombre;
    private String domicilio;
    private double edad;


    public Alumno() {

    }

    public Alumno(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Alumno(String id, String nombre, String domicilio, double edad) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.edad = edad;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String descripcion) {
        this.domicilio = descripcion;
    }

    public double getEdad() {
        return edad;
    }
    public void setEdad(double precio) {
        this.edad = precio;
    }
}
