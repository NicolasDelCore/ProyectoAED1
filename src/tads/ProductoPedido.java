package tads;

public class ProductoPedido implements Comparable<ProductoPedido> {
    private Nodo<Producto> miProducto;
    private int cantidad;
    
    public ProductoPedido(Nodo<Producto> miProducto, int cantidad) {
        this.miProducto = miProducto;
        this.cantidad = cantidad;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Nodo<Producto> getMiProducto() {
        return miProducto;
    }
    
    public void setMiProducto(Nodo<Producto> miProducto) {
        this.miProducto = miProducto;
    }

    @Override
    public String toString(){
        return this.miProducto.getDato().getNombre() + " x" + this.cantidad;
    }
    
    @Override
    public int compareTo(ProductoPedido o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
