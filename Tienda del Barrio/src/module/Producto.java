package module;

public class Producto {
    private String nombre;
    private String descripcion;
    private float precio;
    private String categoria;
    private String etiqueta;
    private  String url;

    public Producto(String nombre, String descripcion, float precio, String categoria,String etiqueta, String url){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.url = url;

    }
}
