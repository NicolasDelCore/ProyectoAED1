package tads;

public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private String ci;
    private int tel;
    private PedidoAbierto pedidoAbierto;
    
    //Constructor de Cliente
    public Cliente(String nombre, String ci, int tel){
        this.nombre = nombre;
        this.ci = ci;
        this.tel = tel;
    }
    
    //Constructor de Cliente sólo cédula para objs temporales para tests
    public Cliente(String ci) {
        this.ci = ci;
    }
    
    //Getters y Setters de Cliente
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    public PedidoAbierto getPedidoAbierto() {
        return pedidoAbierto;
    }

    public void setPedidoAbierto(PedidoAbierto pedidoAbierto) {
        this.pedidoAbierto = pedidoAbierto;
    }

    //Para dejar más prolijo el toString de Cliente en caso de que el pedidoAbierto esté vacío
    private String pedidoAbiertoString(){
        String resultado = "Vacío";
        if(pedidoAbierto != null){
            resultado = "" + pedidoAbierto;
        }
        return resultado;
    }
    
    //Overrides de métodos de Object
    @Override
    public String toString() {
        return "Cliente: " + nombre + " CI: " + ci + " Teléfono: " + tel + " PedidoAbierto: " + pedidoAbiertoString();
    }

    @Override
    public int compareTo(Cliente o) { //Para agregar alfabéticamente
        return this.nombre.compareTo(o.nombre);
    }
    
    @Override
    public boolean equals(Object o) { //Compara por cédula
        Cliente miCliente = (Cliente)o;
        return this.getCi().equals(miCliente.getCi());
    }


    
}
