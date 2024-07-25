package sistemaAutogestion;

import tads.*;

public class Sistema implements IObligatorio {

    //Atributos
    private Lista listaClientes;
    private Lista listaProductos;
    private Cola colaPedidosCerrados;
    private Cola colaPedidosListos;
    private int maxUnidadesDePedido;

    //Setters y getters
    public Lista getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Lista listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Lista getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Lista listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Cola getColaPedidosCerrados() {
        return colaPedidosCerrados;
    }

    public void setColaPedidosCerrados(Cola colaPedidosCerrados) {
        this.colaPedidosCerrados = colaPedidosCerrados;
    }

    public Cola getColaPedidosListos() {
        return colaPedidosListos;
    }

    public void setColaPedidosListos(Cola colaPedidosListos) {
        this.colaPedidosListos = colaPedidosListos;
    }

    //Implementación de IObligatorio (overrides de interfaz)
    @Override
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //Si las unidades máximas de pedidos son <= 3, devuelve error, >3 crea el sistema
        if (maxUnidadesDePedido > 3) {
            this.maxUnidadesDePedido = maxUnidadesDePedido;
            this.listaClientes = new Lista();
            this.listaProductos = new Lista();
            this.setColaPedidosCerrados(new Cola());
            this.setColaPedidosListos(new Cola());
            r.resultado = Retorno.Resultado.OK;
        } else {
            r.resultado = Retorno.Resultado.ERROR_1;
        }

        return r;
    }

    @Override
    public Retorno agregarCliente(String nombre, String ci, int tel) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //Objeto Cliente que será nodo de lista
        Cliente miCliente = new Cliente(nombre, ci, tel);

        if (listaClientes.esVacia()) { //Si la lista está vacía
            listaClientes.agregarInicio(miCliente); //Agrego el cliente al inicio de la lista            
            r.resultado = Retorno.Resultado.OK; //Devolveré OK
        } else { //Sino
            boolean noEncontrado = !listaClientes.estaElemento(miCliente); //(listaClientes.obtenerElemento(miCliente) == null);

            //Si la CI de miCliente no existe en la lista, agrego el nodo miCliente ordenado alfabéticamente
            if (noEncontrado) {
                listaClientes.agregarOrdAlfabetico(miCliente);
                r.resultado = Retorno.Resultado.OK; //Devolveré OK
            } else {
                r.resultado = Retorno.Resultado.ERROR_1; ////Si la CI de miCliente existe en la lista, devuelvo ERROR_1
            }
        }

        return r;
    }

    @Override
    public Retorno eliminarCliente(String ci) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //Chequeo si la lista está vacía, si lo está, el cliente no existe, entonces devuelvo ERROR_1
        if (listaClientes.esVacia()) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } else {
            Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ci));

            //SI EL CLIENTE NO EXISTE, DEVOLVER ERROR_1
            if (miCliente == null) {
                r.resultado = Retorno.Resultado.ERROR_1;
            } else {
                listaClientes.borrarElemento(miCliente.getDato());
                r.resultado = Retorno.Resultado.OK;
            }
        }
        return r;
    }
    //Para la siguiente parte del obligatorio: SI EL CLIENTE TIENE PEDIDOS REGISTRADOS, DEVOLVER ERROR_2

    @Override
    public Retorno agregarProducto(String nombre, String descripcion) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Producto miProducto = new Producto(nombre, descripcion);

        //Chequeo si la lista está vacía, si lo está, el producto no existe, entonces devuelvo ERROR_1
        if (listaProductos.esVacia()) {
            listaProductos.agregarInicio(miProducto);
            r.resultado = Retorno.Resultado.OK;
        } else {
            boolean noEncontrado = !listaProductos.estaElemento(miProducto);
            if (noEncontrado) {
                listaProductos.agregarFinal(miProducto);
                r.resultado = Retorno.Resultado.OK;
            } else {
                r.resultado = Retorno.Resultado.ERROR_1;
            }
        }
        return r;
    }

    @Override
    public Retorno eliminarProducto(String nombre) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (listaProductos.esVacia()) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } else {

            Nodo<Producto> miProducto = listaProductos.obtenerElemento(new Producto(nombre));

            if (miProducto == null) {
                r.resultado = Retorno.Resultado.ERROR_1;
            } else {
                listaProductos.borrarElemento(miProducto.getDato());
                r.resultado = Retorno.Resultado.OK;
            }
        }
        return r;
    }

    @Override
    public Retorno altaStockProducto(int nroProducto, int unidades) {

        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Producto productoNumero = new Producto(nroProducto);
        Nodo<Producto> miProducto = listaProductos.obtenerElemento(productoNumero);

        if (miProducto == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } else if (unidades <= 0) {
            r.resultado = Retorno.Resultado.ERROR_2;
        } else if (unidades > 0) {
            int stockActual = miProducto.getDato().getStock();
            miProducto.getDato().setStock(stockActual + unidades);
            r.resultado = Retorno.Resultado.OK;
        }

        return r;
    }

    @Override
    public Retorno aperturaDePedido(String ciCliente) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ciCliente));

        //Si el cliente no existe, devuelvo ERROR_1
        if (miCliente == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } else {
            //Si el cliente ya tiene un pedidoAbierto, devuelvo ERROR_2
            if (miCliente.getDato().getPedidoAbierto() != null) {
                r.resultado = Retorno.Resultado.ERROR_2;
            } else {
                PedidoAbierto nuevoPedido = new PedidoAbierto(new Pila());
                miCliente.getDato().setPedidoAbierto(nuevoPedido);
                r.resultado = Retorno.Resultado.OK;
            }
        }

        return r;
    }

    @Override
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ciCliente));
        Producto productoNumero = new Producto(nroProducto);
        Nodo<Producto> miProducto = listaProductos.obtenerElemento(productoNumero);

        //ERROR_1: En caso de que no exista la ci del cliente
        if (miCliente == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } //ERROR_2: En caso de que no exista el nro de producto
        else if (miProducto == null) {
            r.resultado = Retorno.Resultado.ERROR_2;
        } //ERROR_3: En caso de que, con la cantidad de unidades indicadas, se supere el máximo de unidades totales permitidas para el pedido      
        else if (unidades > maxUnidadesDePedido) {
            r.resultado = Retorno.Resultado.ERROR_3;
        } //ERROR_4: En caso de que las unidades sean <= 0
        else if (unidades <= 0) {
            r.resultado = Retorno.Resultado.ERROR_4;
        } //ERROR_5: En caso de que no exista stock para agregar dicha cantidad de unidades (queda sin efecto TODO el registro)
        else if (miProducto.getDato().getStock() < unidades) {
            r.resultado = Retorno.Resultado.ERROR_5;
        } //Procesar
        else {
            //En caso de querer agregar un producto con un pedido abierto en null, agregamos un pedidoAbierto al cliente
            if (miCliente.getDato().getPedidoAbierto() == null) {
                this.aperturaDePedido(ciCliente);
            }

            int stockDelProd = miProducto.getDato().getStock();
            ProductoPedido productoApilado = new ProductoPedido(miProducto, unidades);

            miCliente.getDato().getPedidoAbierto().getPedido().apilar(productoApilado);
            miProducto.getDato().setStock(stockDelProd - unidades);
            miCliente.getDato().getPedidoAbierto().sumarCantUnidadesTotales(unidades); //aumenta contador de unidades totales de pedidoAbierto cantUnidadesTotales
            r.resultado = Retorno.Resultado.OK;
        }

        return r;
    }

    @Override
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ciCliente));

        //ERROR_1: En caso de que no exista la ci del cliente
        if (miCliente == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } //ERROR_2: En caso de que el nro de acciones sea <= 0
        else if (cantAccionesDeshacer <= 0) {
            r.resultado = Retorno.Resultado.ERROR_2;
        } //ERROR_3: En caso de que la cantidad de acciones solicitadas supere la cantidad de productos que fueron agregados      
        else if (cantAccionesDeshacer > miCliente.getDato().getPedidoAbierto().getPedido().getCantElementos()) {
            r.resultado = Retorno.Resultado.ERROR_3;
        } else {
            int cantProductos = miCliente.getDato().getPedidoAbierto().getPedido().getCantElementos();
            //si la tenemos que deshacer todas las acciones del pedido
            if (cantAccionesDeshacer == cantProductos) {
                miCliente.getDato().getPedidoAbierto().getPedido().vaciarPila();
                miCliente.getDato().getPedidoAbierto().setCantUnidadesTotales(0);
            } else {
                int acciones = 0;
                while (acciones < cantAccionesDeshacer) {
                    ProductoPedido pedidoCima = (ProductoPedido)miCliente.getDato().getPedidoAbierto().getPedido().cima().getDato();
                    miCliente.getDato().getPedidoAbierto().sumarCantUnidadesTotales(-(pedidoCima.getCantidad())); //decrementa contador de unidades totales de pedidoAbierto cantUnidadesTotales
                    miCliente.getDato().getPedidoAbierto().getPedido().desapilar(); //desapila la cima
                    acciones++;
                }
            }
            r.resultado = Retorno.Resultado.OK;
        }
        return r;
    }

    @Override
    public Retorno cerrarPedido(String ciCliente) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ciCliente));

        //ERROR_1: En caso de que no exista la ci del cliente
        if (miCliente == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } //ERROR_2: En caso de que dicho cliente no tenga un pedido abierto / pedido abierto está vacío
        else if (miCliente.getDato().getPedidoAbierto() == null || miCliente.getDato().getPedidoAbierto().getPedido().esVacia()) {
            r.resultado = Retorno.Resultado.ERROR_2;            
        } else {
            PedidoCerrado pedidoCerrado = new PedidoCerrado(ciCliente, miCliente.getDato().getPedidoAbierto());
            //ERROR_3: E caso de que el pedido tenga 10 o menos unidades
            if(pedidoCerrado.getElPedidoAbierto().getCantUnidadesTotales() <= 10){
                r.resultado = Retorno.Resultado.ERROR_3;
            }
            else {
                getColaPedidosCerrados().encolar(pedidoCerrado);
                miCliente.getDato().setPedidoAbierto(null);
                r.resultado = Retorno.Resultado.OK;
            }
        }
        return r;
    }
    
    //Este método sólo existe para testear cerrarPedido con cantidades de 10 o menos unidades, para confirmar que sólo se listan los pedidos correctos en pedidosCerradosDeClientes
    //Como es un método de test y fuera del Sistema, no lo agrego a la intefaz IObligatorio
    public Retorno cerrarPedidoChicoTest(String ciCliente){
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        Nodo<Cliente> miCliente = listaClientes.obtenerElemento(new Cliente(ciCliente));

        //ERROR_1: En caso de que no exista la ci del cliente
        if (miCliente == null) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } //ERROR_2: En caso de que dicho cliente no tenga un pedido abierto / pedido abierto está vacío
        else if (miCliente.getDato().getPedidoAbierto() == null || miCliente.getDato().getPedidoAbierto().getPedido().esVacia()) {
            r.resultado = Retorno.Resultado.ERROR_2;            
        } else {
            PedidoCerrado pedidoCerrado = new PedidoCerrado(ciCliente, miCliente.getDato().getPedidoAbierto());            
                getColaPedidosCerrados().encolar(pedidoCerrado);
                miCliente.getDato().setPedidoAbierto(null);
                r.resultado = Retorno.Resultado.OK;            
            }
        return r;
    }

    @Override
    public Retorno procesarPedido(int cantPedidos) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //ERROR_1 - En caso de que la cantidad de pedidos sea <=0
        if (cantPedidos <= 0) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } //ERROR_2 - En caso de que la cantidad de pedidos a procesar sea mayor a la cantidad de pedidos cerrados
        else if (cantPedidos > this.getColaPedidosCerrados().getCantElementos()) {
            r.resultado = Retorno.Resultado.ERROR_2;
        } else {
            for (int i = 0; i < cantPedidos; i++) {
                PedidoCerrado miPedido = (PedidoCerrado) getColaPedidosCerrados().desencolar();
                miPedido.setProcesado(true);
                this.colaPedidosListos.encolar(miPedido);
                r.resultado = Retorno.Resultado.OK;
            }
        }

        return r;
    }

    @Override
    public Retorno listarClientes() {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (listaClientes.getCantidad() > 0) {
            listaClientes.mostrar();
            r.resultado = Retorno.Resultado.OK;
        } else {
            System.out.println("No hay clientes registrados");
            r.resultado = Retorno.Resultado.OK;
        }
        return r;
    }

    @Override
    public Retorno listarProductos() {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        listarProductosRecursivo(listaProductos.getInicio());
        System.out.println("");
        r.resultado = Retorno.Resultado.OK;
        return r;
    }

    public void listarProductosRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " - ");
            listarProductosRecursivo(nodo.getSiguiente());
        }
    }

    @Override
    public Retorno listarPedidosAbiertos() {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        int cantClientes = listaClientes.cantElementos();
        Nodo<Cliente> nodoActual = listaClientes.getInicio();

        for (int i = 0; i < cantClientes; i++) {
            if (nodoActual.getDato().getPedidoAbierto() != null) {
                System.out.println(nodoActual.getDato().getPedidoAbierto().detallesDelPedido());
            }
            nodoActual = nodoActual.getSiguiente();
        }

        r.resultado = Retorno.Resultado.OK;
        return r;

    }

    @Override
    public Retorno pedidosCerradosDeClientes(String ci) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //Cliente miCliente = (Cliente)listaClientes.obtenerElemento(new Cliente(ci));
        boolean clienteEsta = listaClientes.estaElemento(new Cliente(ci));

        //Si la cédula del cliente no existe, ERROR_1
        if (this.colaPedidosCerrados.estaVacia() || !clienteEsta) {
            r.resultado = Retorno.Resultado.ERROR_1;
        } else {
            //Listar pedidos errados                
            Nodo<PedidoCerrado> nodoActual = colaPedidosCerrados.obtenerPrimero();

            while (nodoActual != null) {
                PedidoCerrado miDato = nodoActual.getDato(); //Referencia al dato del nodo para hacer el if más legible
                if (miDato.getCiCliente().equals(ci) && miDato.getElPedidoAbierto().getCantUnidadesTotales() > 10) {
                    System.out.println(nodoActual.getDato() + " - ");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            r.resultado = Retorno.Resultado.OK;
        }
        return r;
    }

    //ESTE DEBE SER RECURSIVO
    @Override
    public Retorno productosParaEntregar() {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (!colaPedidosListos.estaVacia()) {
            productosParaEntregar(this.colaPedidosListos.obtenerPrimero());
        } else {
            System.out.println("No hay pedidos listos para la entrega todavía.");
        }

        System.out.println("");
        r.resultado = Retorno.Resultado.OK;
        return r;
    }

    public void productosParaEntregar(Nodo nodo) {
        if (nodo != null) {
            PedidoCerrado miPedido = (PedidoCerrado) nodo.getDato();
            Nodo<Cliente> miCliente = this.listaClientes.obtenerElemento(new Cliente(miPedido.getCiCliente()));

            System.out.println("Cliente " + miCliente.getDato().getNombre() + " Pedido: " + miPedido.getElPedidoAbierto().getNroPedido() + " - ");

            productosParaEntregar(nodo.getSiguiente());
        }
    }

    @Override
    public Retorno reporteDePedidosSolicitadosXCliente() {

        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        //Crear matriz
        int cantClientes = listaClientes.getCantidad();
        int cantidadProductos = listaProductos.getCantidad();

        Nodo<Cliente> nodoActualCliente = listaClientes.getInicio();

        String[][] reporteMatriz = new String[cantClientes][cantidadProductos + 1]; //agregamos +1 a las columnas (represantadas por CantidadProductos), dado que la columnas 0 tiene a los clientes

        int fila = 0;

        while (nodoActualCliente != null) {
            reporteMatriz[fila][0] = nodoActualCliente.getDato().getNombre() + " |";

            Nodo<Producto> nodoActualProducto = listaProductos.getInicio();
            int columna = 1; //los productos se colocan a partir de la columna 1, ya que los clientes van en la 0

            while (nodoActualProducto != null) {
                reporteMatriz[fila][columna] = nodoActualProducto.getDato().getNombre();
                reporteMatriz[fila][columna] += " x" + (cantidadEncargadaPor(nodoActualProducto.getDato(), nodoActualCliente.getDato())) + " | ";
                nodoActualProducto = nodoActualProducto.getSiguiente();
                columna++;
            }

            nodoActualCliente = nodoActualCliente.getSiguiente();
            fila++;
        }

        //Imprimir matriz
        dibujarMatrizStr(reporteMatriz, "Productos en pedidos cerrados por cliente");

        r.resultado = Retorno.Resultado.OK;
        return r;

    }

    //Método: cantidad de veces que alguien encargó algo en pedidos cerrados y abiertos
    //Pre: recibe un objeto Producto y un objeto Cliente, Post: Devuelve la cantidad de unidades de ese producto en pedidosCerrados y pedidosListos de ese Cliente
    public int cantidadEncargadaPor(Producto miProducto, Cliente miCliente) {
        return (cantidadEncargadaPor(miProducto, miCliente, colaPedidosCerrados) + cantidadEncargadaPor(miProducto, miCliente,colaPedidosListos));
    }
    
    //Pre: recibe un Producto, un Cliente y una Cola, se espera que la cola sea: colaPedidosCerrados o colaPedidosListos, Post: devuelve la cantidad de unidades del Producto en el PedidoCerrado del Cliente que está guardado en la Cola
    public int cantidadEncargadaPor(Producto miProducto, Cliente miCliente, Cola cola){
        int cantidad = 0;        
        if (!cola.estaVacia() && miCliente != null && miProducto != null) {
            String ci = miCliente.getCi();
            Nodo<PedidoCerrado> nodoActual = cola.obtenerPrimero();
            while (nodoActual != null) {
                if (nodoActual.getDato().getCiCliente().equals(ci)) {
                    cantidad += nodoActual.getDato().getElPedidoAbierto().cantUnidadesDeProducto(miProducto);
                }
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return cantidad;
    }

    //Método para dibujar matrices de String //Pre: recibe una matriz de String y un String título, Post: Imprime en pantalla el título y debajo el contenido de la matriz
    public void dibujarMatrizStr(String[][] reporteMatriz, String titulo) {
        System.out.println(titulo);
        for (int i = 0; i < reporteMatriz.length; i++) {
            for (String item : reporteMatriz[i]) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
