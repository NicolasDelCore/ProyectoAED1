package tads;


public class Cola<T> implements ICola<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantElementos;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
        }
        ultimo = nuevoNodo;
        cantElementos++;
    }

    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Se intentó desencolar de una cola vacía");
        }
        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        cantElementos--;
        return dato;
    }
    
    @Override
    public Nodo<T> obtenerPrimero() {
        if (estaVacia()) {
            System.out.println("Se intentó obtener el primer dato de una cola vacía");
        }
        return primero;
    }

    @Override
    public void mostrarCola() {
        
        Nodo<T> aux = primero;
        
        System.out.println("Muestro Cola:");
        
        while(aux !=  null){
            System.out.print(aux.getDato() + " - ");
            aux = aux.getSiguiente();
        }  
    }


}


