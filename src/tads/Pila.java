package tads;

public class Pila<T extends Comparable<T>> implements IPila<T> {

    private Nodo<T> inicio;
    private Nodo<T> dato;
    private int cantElementos;
    private int cantMax;
    
    //Constructor Pila con tope
    public Pila(int cantMaxima){
        cantMax = cantMaxima;
        inicio = null;
    }
    
    //Constructor Pila sin tope
    public Pila(){
        cantMax = 0;
        inicio = null;
    }
    
    //Setters y Getters
    public Nodo getInicio() {
        return inicio;
    }
    
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
  
    public T getDato() {
        return dato.getDato();
    }
   
    public void setDato(T dato) {
        Nodo<T> miNodo = new Nodo(dato);
        this.dato = miNodo;
    }
   
    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
   
    public int getCantMax() {
        return cantMax;
    }
    
    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }
    
    //Métodos implementados
    
    @Override
    public void apilar(T dato) {
        
        if(!esllena() || this.cantMax == 0){
            Nodo nuevo = new Nodo(dato);
            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
            cantElementos ++;
        }
        else{
            System.out.println("La pila esta llena");
        }
        
    }

    @Override
    public void desapilar() {
         if (!this.esVacia()) {
            inicio = getInicio().getSiguiente();
            cantElementos--;
        } else {
            System.out.println("Esta vacia");
        }
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public boolean esllena() {
       return cantElementos == cantMax && cantMax != 0;
    }

    @Override
    public Nodo cima() {
        return this.getInicio();
    }

    @Override
    public int elementos() {
        return cantElementos; 
    }
    
    public String mostrarPila(){
        Nodo<T> nodoActual = inicio;
        String resultado = "";
        for(int i = 0; i < cantElementos; i++){
            resultado += nodoActual.getDato() + " ";
            nodoActual = nodoActual.getSiguiente();
        }
        return resultado;
    }
    
    public void vaciarPila(){        
        this.cantElementos = 0;
        this.inicio = null;
    }
    
    /*
    @Override
    public Pila copiarPila() {        
        Pila pilaNueva = new Pila(this.cantMax);
        
        Nodo<T> miNodo = this.cima();
        Lista miLista = new Lista();
        
        while (miNodo != null) {
            miLista.agregarInicio(miNodo.getDato() );
            miNodo = miNodo.getSiguiente();
        }     
        
        miNodo = miLista.getInicio();
        
        while (miNodo != null) {
            pilaNueva.apilar(miNodo.getDato());
            miNodo = miNodo.getSiguiente();
        }       
            
        return pilaNueva;        
    }
    */
    
}
