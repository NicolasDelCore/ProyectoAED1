package tads;

public class PedidoAbierto {

    static private int ultimoPedido = 1;
    private int nroPedido;
    private Pila pedido;
    private int cantUnidadesTotales; //la cantidad de unidades de todos los productos del pedidoAbierto; incrementa y decrementa desde Sistema cuando hay operaciones con la pila pedido de PedidoAbierto
    
    public PedidoAbierto(Pila pedido){
        this.pedido = pedido;
        this.nroPedido = ultimoPedido;
        this.cantUnidadesTotales = 0;
        PedidoAbierto.ultimoPedido++;
    }
    
    public int getCantUnidadesTotales(){
        return cantUnidadesTotales;
    }
    
    public void setCantUnidadesTotales(int cant){
        this.cantUnidadesTotales = cant;
    }

    public void sumarCantUnidadesTotales(int unidades){
        cantUnidadesTotales += unidades;
    }
    
    public int getNroPedido() {
        return nroPedido;
    }
    
    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }
    public Pila getPedido() {
        return pedido;
    }
    
    public void setPedido(Pila pedido) {
        this.pedido = pedido;
    }
    
    public String detallesDelPedido() {
        String resultado = "Número de pedido: " + this.nroPedido + " Cantidad total de unidades: " + getCantUnidadesTotales() + " Pedido: ";
        if (this.pedido.getCantElementos() == 0){
            resultado += "Vacío";
        } else {
            resultado += this.pedido.mostrarPila();
        }
        return resultado;
    }
    
    public int cantUnidadesDeProducto(Producto miProducto){
        int cantidad = 0;
        
        Nodo<ProductoPedido> miNodo = pedido.getInicio();
        while (miNodo != null){
            if ( miProducto.equals(miNodo.getDato().getMiProducto().getDato() ) ){
                cantidad += miNodo.getDato().getCantidad();
                //System.out.println("Producto: " + miProducto.getNombre() + " cantidad: " + cantidad); //debug
            }
            
            miNodo = miNodo.getSiguiente();
        }
        
        return cantidad;
    }
    
    @Override
    public String toString() {
        return "Número de pedido: " + this.nroPedido;
    }
    
}
