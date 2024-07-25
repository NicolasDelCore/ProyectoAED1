package tads;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private String descripcion;
    private int nroProducto;
    private int stock = 0;
    private static int proximoNumero = 1;
      
    //Constructor de Producto
    public Producto(String elNombre, String laDescripcion){
        this.nombre = elNombre;
        this.descripcion = laDescripcion;
        this.nroProducto = proximoNumero++;
    }
    
    //Constructor de Producto
    public Producto(int nroProducto){
        this.nombre = "";
        this.nroProducto = nroProducto;
    }
    
    //Sobrecarga del constructor
    public Producto(String elNombre) {
        this.nombre = elNombre;
    }
     
    //Getters y Setters de Producto
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNroProducto() {
        return nroProducto;
    }

    public void setNroProducto(int nroProducto) {
        this.nroProducto = nroProducto;
    }
    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Overrides de métodos de Object
    @Override
    public String toString() {
        return "Producto: " + getNombre() + " | Descripción: " + getDescripcion() + " | Stock: " + getStock() + " | Número: " + getNroProducto();
    }

    @Override
    public int compareTo(Producto o) { 
        return this.getNombre().compareTo(o.getNombre());
    }
    
    @Override
    public boolean equals(Object o) { //Compara por nombre  y por nroProducto       
        Producto miProducto = (Producto)o;
        return this.getNombre().equals(miProducto.getNombre()) || this.getNroProducto() == miProducto.getNroProducto();                
    }    

}
