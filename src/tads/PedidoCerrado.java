package tads;

public class PedidoCerrado {
    //Atributos
    private String ciCliente;
    private PedidoAbierto pedidoAbierto;
    private boolean procesado;

    //Constructor
    public PedidoCerrado(String elCi, PedidoAbierto elPedidoAbierto){
        this.ciCliente = elCi;
        this.pedidoAbierto = elPedidoAbierto;
    }
    
    //Getters & Setters
    public String getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(String ciCliente) {
        this.ciCliente = ciCliente;
    }

    public PedidoAbierto getElPedidoAbierto() {
        return pedidoAbierto;
    }

    public void setElPedidoAbierto(PedidoAbierto elPedidoAbierto) {
        this.pedidoAbierto = elPedidoAbierto;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }
     
    @Override
    public String toString() {
        return "Pedido cerrado del cliente: " + this.ciCliente + " Procesado: " + this.procesado + " Número de pedido: " + pedidoAbierto.getNroPedido();
    }
    
}
