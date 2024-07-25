package tads;

public class Lista<T extends Comparable<T>> implements ILista<T> {

   //Atributos de Lista
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;
    private int maxElementos;

    //Constructor de lista con tope  
    public Lista(int max) {
        inicio = null;
        fin = null;
        cantidad = 0;
        maxElementos = max;
    }
    
    //Constructor de lista SIN tope
    public Lista() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }
    
    //Setters y Getters    
    public Nodo<T> getInicio() {
        return inicio;
    }
    
    public Nodo<T> getFin() {
        return fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Métodos de ILista implementados
    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void agregarInicio(T n) {

        if (!this.estaCompleta() || maxElementos == 0) {

            Nodo<T> nuevo = new Nodo(n);

            if (esVacia()) {
                fin = nuevo;
            }

            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            cantidad++;

        } else {
            System.out.println("La lista esta llena");
        }

    }

    @Override
    public void agregarFinal(T n) {

        if (!this.estaCompleta() || maxElementos == 0) {

            if (this.esVacia()) {
                agregarInicio(n);

            } else {

                Nodo<T> nuevo = new Nodo(n);
                fin.setSiguiente(nuevo);
                fin = nuevo;
                cantidad++;
            }
        } else {
            System.out.println("La lista esta llena");
        }

    }

    @Override
    public void borrarInicio() {

        if (!this.esVacia()) {

            Nodo borrar = inicio;
            inicio = inicio.getSiguiente();
            borrar.setSiguiente(null);

            if (cantidad == 1) {
                fin = inicio;
            }
            cantidad--;
        } else {
            System.out.println("Esta vacia");
        }

    }

    @Override
    public void borrarFin() {

        if (!this.esVacia()) {

            if (cantidad == 1) {
                vaciar();
            } else {

                Nodo actual = getInicio();

                while (actual.getSiguiente().getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                fin = actual;
                cantidad--;
            }

        }
    }

    @Override
    public void mostrar() {

        Nodo mostrar = getInicio();

        while (mostrar != null) {
            System.out.println(mostrar.getDato() + " - ");
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");

    }

    @Override
    public void vaciar() {
        inicio = null;
        fin = null;
        setCantidad(0);
    }

    @Override
    public int cantElementos() {
        return cantidad;
    }
    
    
    
    @Override
    public void agregarOrdAlfabetico(T n) {

        if (!this.estaCompleta() || maxElementos == 0) {

            Nodo<T> nuevo = new Nodo(n);

            if (this.esVacia()) {
                agregarInicio(n);
            } else {
                if (getInicio().getDato().compareTo(n) > 0) {
                    agregarInicio(n);
                } else {
                    if (getFin().getDato().compareTo(n) < 0) {
                        agregarFinal(n);
                    } else {
                        
                            Nodo<T> actual = getInicio();
                        
                            //Buscamos la posición donde agregar al nodo
                            while (actual.getSiguiente() != null && actual.getSiguiente().getDato().compareTo(n) < 0) {
                                    actual = actual.getSiguiente();                        
                            }
                            
                            //Agregamos el nodo en esa posición
                            nuevo.setSiguiente(actual.getSiguiente());
                            actual.setSiguiente(nuevo);
                            cantidad++;  
                        }
                    }
                }
        } else {            
            System.out.println("Error: La lista esta llena");
        }
    }


    @Override
    public void borrarElemento(T n) {

        if (!this.esVacia()) {

            if (inicio.getDato() == n) {
                borrarInicio();
            } else {
                if (fin.getDato() == n) {
                    borrarFin();
                } else {

                    Nodo actual = inicio;

                    while (actual.getSiguiente() != null && actual.getSiguiente().getDato() != n) {
                        actual = actual.getSiguiente();
                    }

                    if (actual.getSiguiente() != null) {
                        Nodo aBorrar = actual.getSiguiente();
                        actual.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
                        cantidad--;
                    }

                }

            }
        }       
    }

    @Override
    public Nodo obtenerElemento(T n) {

        Nodo ret = null;

        if (!this.esVacia()) {

            Nodo actual = getInicio();
            while (actual != null && !actual.getDato().equals(n)) {
                actual = actual.getSiguiente();
            }

            if (actual != null) {
                ret = actual;
            }
        }
        return ret;
    }

    @Override
    public boolean estaElemento(T n) {

        boolean esta = false;

        if (!this.esVacia()) {

            Nodo actual = getInicio();

            while ( actual != null && !( actual.getDato().equals( n ) ) ) {
                actual = actual.getSiguiente();
            }

            if (actual != null) {
                esta = true;
            }
        }
        return esta;
    }

    @Override
    public boolean estaCompleta() {
        boolean resultado = false;
        if (maxElementos != 0) {
            resultado = cantidad == maxElementos;
        }
        return resultado;
    }    
    
    //pre: este algoritmo recibe el primer nodo de la lista
    //PRE: NO ELIMINAR EL PRIMER NODO
    public boolean eliminarDato (Lista milista, int num){
        public boolean eliminarDato (milista.getInicio(), num);
    }
    
    public boolean eliminarDato (Nodo minodo, int num) {

	boolean encontrado = false;
        nodoAux = null;

        if (num >= milista.getInicio() && num <= milista.getultimo()){ //SI NUM ESTÁ DENTRO DE LA LISTA ORDENADA
            while (minodo != null && minodo.getSiguiente() != null && minodo.getSiguiente() <= num){
                //Soluciona medio de la lista
                if (minodo.getSiguiente.getDato() == num){
                    boolean = true;
                    while (nodoAux.getDato != null && nodoAux.getDato() == null){
                        nodoAux = nodoAux.getSiguiente();
                    }

                    //nodoAux ahora es o null (porque el último número == num), o es el primer número distinto de num
                    //si aux salió en null, hay que actualizar la referencia de ultimo a minodo
                    if (aux == null) {
                        milista.ultimo = minodo;
                    }
                    minodo.setSiguiente(nodoAux); //corta todas las apariciones de num de la lista, minodo es el último elemento o un elemento intermedio
                }
                minodo = minodo.getSiguiente(); //minodo puede qudar en null en este momento, por eso el chequeo de null en el while
            }        
        }
        return encontrado;

    }

}
    

    
}
