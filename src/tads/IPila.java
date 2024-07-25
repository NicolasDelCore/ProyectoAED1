package tads;


public interface IPila<T> {
    
    public void apilar(T dato);
    public void desapilar();
    public boolean esVacia();
    public boolean esllena();
    public Nodo cima();
    public int elementos();
        
    
    //Pos: Retorna una nueva pila con los mismos elementos que la pila original (la pila original queda intacta).
    //public Pila copiarPila ();

}
