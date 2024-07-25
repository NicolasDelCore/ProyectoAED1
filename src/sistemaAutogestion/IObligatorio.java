package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTRO DE CLIENTES Y PRODUCTOS **************************************
    */
    
    //pre: Recibe un int maxUnidadesDePedido      post: Carga el sistema de autoservicio con sus TADs inicializados, si la cantidad es <= 3 devuelve ERROR_1
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido);
    
     //pre: Recibe Nombre y CI que son Strings válidos y reales, tel es un int teléfono real y > 0     post: se agrega un nodo cliente a la lista de clientes con los valores proporcionados
    public Retorno agregarCliente(String nombre,String ci, int tel);
    
     //pre: Recibe un String que representa un CI válido     post: Se elimina al cliente con el CI indicado, o se le indica al usuario que con ese CI no existe un usuario registrado en el sistema mediante ERROR_1, o se indica que el usuario tiene pedidos registrados y no se puede borrar mediante ERROR_2
    public Retorno eliminarCliente(String ci);
    
     //pre: Recibe un Nombre y Descripción que son Strings válidos que representan un producto real     post: Se agrega un nodo producto a la lista de productos con los valores proporcionados, o se le indica al usuario que ya existe un producto con el nombre indicado mediante ERROR_1
    public Retorno agregarProducto(String nombre, String descripcion); 
    
     //pre: Recibe un Nombre que es un String válido     post: Si el nombre dado corresponde con un producto, el producto se borra, sino, se devuelve que el producto no existe mediante ERROR_1
    public Retorno eliminarProducto(String nombre);
    
     //pre: Recibe un String nroProducto y un int cantidad de unidades > 0     post: Se da de alta el producto indicado y su cantidad de unidades en el stock, devuelve ERROR_1 en caso de que no exista un producto con el numero indicado o ERROR_2 en caso de que las unidades ingresadas sean <=0
    public Retorno altaStockProducto(int nroProducto, int unidades);
    
     /*
    **************** GESTIÓN DE PEDIDOS **************************************
    */
    
     //pre: Recibe un String CI Cliente válido y que existe en el sistema     post: se crea un nodo de pedidoAbierto, devuelve ERROR_1 en caso de que no exista el cliente con la CI indicada o ERROR_2 en caso de que el cliente ya tenga un pedido abierto
    public Retorno aperturaDePedido(String ciCliente);
    
     //pre: Recibe un String ciCliente e int nroProducto válidos y que existen en el sistema, y una cantidad int de unidades válida    post: Se agrega el producto al pedido del cliente, devuelve ERROR_1 en caso de que no exista la CI del cliente en el sistema, ERROR_2 en caso de que no exista el nro de producto o ERROR_3 en caso de que unidades > maximas unidades permitidas para el pedido
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades); 
    
     //pre: Recibe un String ciCliente válido y que existen en el sistema y una cantidad int de acciones válida >= 0     post: Se deshace esa cantidad de acciones del pedido del cliente, volviendo hacia atrás la cantidad indicada de pasos, devuelve ERROR_1 en caso de que no exista la CI del cliente en el sistema, ERROR_2 en caso de que el numero de acciones <= 0 y ERROR_3 en caso de que cantAccionesDesacer > cantidad de productos agregados  
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer);
    
     //pre: Recibe un String ciCliente válido y que existe en el sistema, si ese cliente tiene un pedido abierto      post: Se crea nodo de pedido cerrado en ******* (tad), el cuál pasa a ser procesado, y se borra el nodo de pedido abierto, devuelve ERROR_1 en caso de que no exista la CI del cliente
    public Retorno cerrarPedido(String ciCliente); 
    
     //pre: Recibe una cantidad int cantPedidos válida > 0     post: Se procesan los pedidos cerrados en orden de llegada y se les asigna el estado "Prontos para entregar", devuelve ERROR_1 en caso de que la cantidad de pedidos <= 0
    public Retorno procesarPedido(int cantPedidos); 
    
      /*
    **************** LISTADO Y REPORTES **************************************
    */
    
     //pre: -      post: Se listan los clientes registrados en orden alfabético ascendiente con todos sus datos
    public Retorno listarClientes();
    
     //pre: -      post: Se listan los productos en el orden que fueron registrados con todos sus datos incluyendo el stock disponible
    public Retorno listarProductos();
    
     //pre: -      post: Se listan todos los pedidos abiertos con sus productos y unidades solicitadas, también se muestra la cantidad total de unidades de cada pedido
    public Retorno listarPedidosAbiertos();
    
     //pre: Recibe un String ciCliente válido y que existe en el sistema      post: Lista todos los pedidos cerrados para dicho cliente, devuelve ERROR_1 en caso de que no exista la CI del cliente
    public Retorno pedidosCerradosDeClientes(String ci); //Error en la letra del Obligatorio, CI de cliente es un string
    
    //pre: -      post: Se muestra el numero y nombre de cliente de cada pedido que este pronto para entregar
    public Retorno productosParaEntregar();
    
    //pre: -     post: Se muestra en una matriz cada pedido representado en una única fila, la cantidad de unidades ingresadas para cada producto.
    public Retorno reporteDePedidosSolicitadosXCliente();
    
}
