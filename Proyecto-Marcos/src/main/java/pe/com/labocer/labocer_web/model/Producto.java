package pe.com.labocer.labocer_web.model;

public class Producto {

    private String nombre;
    private String marca;
    private String categoria;
    private String color;
    private String imagen;
    private String codigo;
    private String descripcion;

    public Producto() {
    }

    public Producto(String nombre, String marca, String categoria, String color,
                    String imagen, String codigo, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.color = color;
        this.imagen = imagen;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}