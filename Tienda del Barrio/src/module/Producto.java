package module;

public class Producto {
    final String nombre;
    final String descripcion;
    final float precio;
    final String categoria;
    final String etiqueta;
    final  String url;

    public Producto(String nombre, String descripcion, float precio, String categoria,String etiqueta, String url){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.url = url;

    }
}
