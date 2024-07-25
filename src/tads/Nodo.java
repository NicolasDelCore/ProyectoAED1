package tads;

public class Nodo<T>{
//public class Nodo<T extends Comparable<T>>{
    
    //Atributos
    private T dato;
    private Nodo<T> siguiente;
    
    //Constructor
    public Nodo(T elDato){
        this.setDato(elDato);
        this.setSiguiente(null);
    }


    //Setters y Getters
    public T getDato() {
        return dato;
    }


    public void setDato(T dato) {
        this.dato = dato;
    }


    public Nodo<T> getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    
    
}
