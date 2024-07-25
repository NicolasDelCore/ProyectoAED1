
package tads;


public interface ILista<T> {
    
    //metodos de la interfaz
    //post: Retorna un boolean indicado si la lista es vacía
    public boolean esVacia();
    
    //pre: n es un posible nodo válido con datos válidos
    //post: agrega el elemento al principio de la lista
    public void agregarInicio(T n);
    
    //pre: n es un posible nodo válido con datos válidos
    //post: agrega el elemento al final de la lista
    public void agregarFinal(T n);
    
    //post: se borra el primer elemento de la lista
    public void borrarInicio();
    
    //post: se elimina el ultimo elemento de la lista
    public void borrarFin();
    
    //post: se vacia la lista
    public void vaciar();
    
    //post: se muestran todos los elementos de la lista
    public void mostrar();
    
    //pre: n es un posible nodo válido con datos válidos, la lista esta ordenada en forma ascendente
    //post: se interta el elemento n en forma ordenada
    public void agregarOrdAlfabetico(T n);
    
    //pre: n posible nodo válido
    //post: se elimina la primera ocurrencia de n en la lista
    public void borrarElemento(T n);
    
    //post: Retorna la cantidad de elementos de la lista
    public int cantElementos();
    
    //post: retornar el nodo que contiene el dato n
    public Nodo obtenerElemento(T n);
    
    //pre: la lista no esta ordenada
    //post: indica si esta el elemento en la lista
    public boolean estaElemento(T n);
    
    //pre: la lista tiene un tope (no se definió con maxElementos = 0)
    //post: Indica si la lista ya esta completa
    public boolean estaCompleta();
    
    
}
