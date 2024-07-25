package inicio;

import sistemaAutogestion.*;

public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        p1_creacionSistema(p, s);        
        p0_reportesVacios(p, s);
        p2_agregarCliente(p, s);
        p3_eliminarCliente(p, s);
        p4_agregarProducto(p, s);
        p5_eliminarProducto(p, s);
        p6_altaStockProducto(p, s);
        p7_aperturaDePedido(p, s);
        p8_agregarProductoAPedido(p, s);
        p9_deshacerPedido(p, s);
        p10_cerrarPedido(p, s);
        p11_abrirCerrarPedidos(p, s);
        p12a_procesarPedido(p, s);
        p12b_procesarPedido(p, s);
        p13_pedidosCerradosDeClientes(p, s);
        p14_productosParaEntregar(p, s);
        p15_reporteDePedidosSolicitadosXCliente(p, s);
        
        //Defensa del obligatorio
        p16_DefensaOb_cerrarPedido(p, s);
        p17_DefensaOb_pedidosCerradosDeCliente(p, s);        
        
        // Imprimir los resultados
        p.imprimirResultadosPrueba();         
    }

    public static void p1_creacionSistema(Prueba p, Sistema s) {
        //Pruebas crearSistemaDeAutoservicio
        p.ver(s.crearSistemaDeAutoservicio(20).resultado, Retorno.Resultado.OK, "Se espera OK, Sistema se creado con 4 maxUnidadesDePedido");
        p.ver(s.crearSistemaDeAutoservicio(3).resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, Sistema falla con 3 maxUnidadesDePedido");
        p.ver(s.crearSistemaDeAutoservicio(2).resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, Sistema falla con 2 maxUnidadesDePedido");
    }

    public static void p2_agregarCliente(Prueba p, Sistema s) {
        p.ver(s.agregarCliente("Fernando", "1111111", 2999999).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Fernando agregado");
        p.ver(s.agregarCliente("Ana", "2222222", 2992299).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Ana agregado");
        p.ver(s.agregarCliente("Maria", "3333333", 2992299).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Maria agregado");
        p.ver(s.agregarCliente("Carlos", "4444444", 2992299).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Carlos agregado");
        p.ver(s.agregarCliente("Laura", "5555555", 2992299).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Laura agregado");
        p.ver(s.agregarCliente("Bernardo", "1111111", 2944459).resultado, Retorno.Resultado.ERROR_1, "Se espera Error_1, cliente Bernardo no agregado, ci duplicada");
        p.ver(s.agregarCliente("Ernesto", "6666666", 2944459).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Ernesto agregado");
        p.ver(s.agregarCliente("Javier", "7777777", 2944459).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Javier agregado");
        p.ver(s.agregarCliente("Alfabeti", "8888888", 2944459).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Alfabeti agregado");
        p.ver(s.agregarCliente("Zampullido", "9999999", 2944459).resultado, Retorno.Resultado.OK, "Se espera OK, Cliente Zampullido agregado");
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK,"listarClientes, se espera OK y se muestra el reporte");
    }

    public static void p3_eliminarCliente(Prueba p, Sistema s) {
        p.ver(s.eliminarCliente("asd12345").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1 Eliminar cédula que no existe");
        p.ver(s.eliminarCliente("9999999").resultado, Retorno.Resultado.OK, "Se espera OK, Último Cliente Zampullido eliminado");
        p.ver(s.eliminarCliente("8888888").resultado, Retorno.Resultado.OK, "Se espera OK, primer Cliente Alfabeti eliminado");
        p.ver(s.eliminarCliente("6666666").resultado, Retorno.Resultado.OK, "Se espera OK, Cliente en medio Ernesto eliminado");
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK,"listarClientes, se espera OK y se muestra el reporte");
    }

    public static void p4_agregarProducto(Prueba p, Sistema s) {
        p.ver(s.agregarProducto("Hamburguesa", "Hamburguesa simple sin condimentos").resultado, Retorno.Resultado.OK, "Se espera OK, Hamburguesa simple agregada con exito");
        p.ver(s.agregarProducto("Papas fritas congeladas", "Papas fritas congeladas en forma de baston").resultado, Retorno.Resultado.OK, "Se espera OK, Papas fritas congeladas agregadas con exito");
        p.ver(s.agregarProducto("Refresco Coca-Cola", "Vaso de 300ml de refresco cola dietetico").resultado, Retorno.Resultado.OK, "Se espera OK, Refresco Coca-Cola agregado con exito");
        p.ver(s.agregarProducto("Nuggets de pollo", "Nuggets de pollo congelados con aditivos").resultado, Retorno.Resultado.OK, "Se espera OK, Nuggets de pollo agregado con exito");
        p.ver(s.agregarProducto("Salsa Ketchup", "Sobre de salsa de tomate marca 'Pepito' de 80grs. Sin sal adicionada").resultado, Retorno.Resultado.OK, "Se espera OK, Ketchup agregado con exito");
        p.ver(s.agregarProducto("Salsa Mayonesa", "Sobre de salsa mayonesa marca 'HombreDelInfierno' de 50grs. Extra sal adicionada").resultado, Retorno.Resultado.OK, "Se espera OK, Ketchup agregado con exito");
        p.ver(s.agregarProducto("Helado de Dulce de Leche", "Helado de dulce de leche con galletitas oreo, vaso de 500ml").resultado, Retorno.Resultado.OK, "Se espera OK, Helado de Dulce de Leche agregado con exito");
        p.ver(s.agregarProducto("Helado de Dulce de Leche", "Helado de dulce de leche con galletitas oreo, vaso de 500ml").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, Helado de Dulce de Leche ya existe");
        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK,"listarProductos, se espera OK y se muestra el reporte");
    }

    public static void p5_eliminarProducto(Prueba p, Sistema s) {
        p.ver(s.eliminarProducto("Hamburguesa").resultado, Retorno.Resultado.OK, "Se espera OK, Hamburguesa eliminado");
        p.ver(s.eliminarProducto("Helado de Dulce de Leche").resultado, Retorno.Resultado.OK, "Se espera OK, Helado de Dulce de Leche eliminado");
        p.ver(s.eliminarProducto("Nuggets de pollo").resultado, Retorno.Resultado.OK, "Se espera OK, Nuggets de Pollo eliminado");
        p.ver(s.eliminarProducto("Nuggets de pollo").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, Nuggets de pollo ya fue eliminado");
        p.ver(s.eliminarProducto("Torta de Dulce de Leche").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, Torta de Dulce de Leche no es un producto valido");
        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK,"listarProductos, se espera OK y se muestra el reporte");
    }

    public static void p6_altaStockProducto(Prueba p, Sistema s) {
        p.ver(s.altaStockProducto(3, 15).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 3 existe y 15 es > 0.");
        p.ver(s.altaStockProducto(3, 1).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 3 existe y 15 es > 0.");
        p.ver(s.altaStockProducto(2, 15).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 2 existe y 15 es > 0.");
        p.ver(s.altaStockProducto(150, 15).resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, el producto 150 es invalido.");
        p.ver(s.altaStockProducto(3, 0).resultado, Retorno.Resultado.ERROR_2, "Se espera ERROR_2, el producto 3 existe pero 0 es un stock inválido.");
        p.ver(s.altaStockProducto(3, -10).resultado, Retorno.Resultado.ERROR_2, "Se espera ERROR_2, el producto 3 existe pero -10 es un stock inválido.");
        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK,"listarProductos, se espera OK y se muestra el reporte");
    }

    public static void p7_aperturaDePedido(Prueba p, Sistema s) {
        p.ver(s.aperturaDePedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se abre un pedido para cliente con CI 7777777."));
        p.ver(s.aperturaDePedido("ab23455").resultado, Retorno.Resultado.ERROR_1, ("Se espera ERROR_1, cliente no existe."));
        p.ver(s.aperturaDePedido("7777777").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, cliente con CI 7777777 ya tiene un pedido abierto."));
        p.ver(s.aperturaDePedido("1111111").resultado, Retorno.Resultado.OK, ("Se espera OK, se abre un pedido para cliente con CI 1111111."));
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK,"listarClientes, se espera OK y se muestra el reporte");
        p.ver(s.aperturaDePedido("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, se abre un pedido para cliente con CI 2222222."));
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK,"listarClientes, se espera OK y se muestra el reporte");
    }

    public static void p8_agregarProductoAPedido(Prueba p, Sistema s) {
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("7777777", 2, 2).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 2 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("7777777", 2, 2).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 2 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("ab23455", 3, 3).resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, la cedula ab23455 no existe.");
        p.ver(s.agregarProductoAPedido("7777777", 160, 3).resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, el producto 160 no existe."));
        p.ver(s.agregarProductoAPedido("7777777", 3, 25).resultado, Retorno.Resultado.ERROR_3, ("Se espera ERROR_3, se supera el maximo de unidades permitidas por el sistema (25)."));
        p.ver(s.agregarProductoAPedido("7777777", 3, 0).resultado, Retorno.Resultado.ERROR_4, ("Se espera ERROR_4, se pidieron 0 unidades del producto."));
        p.ver(s.agregarProductoAPedido("7777777", 3, -1).resultado, Retorno.Resultado.ERROR_4, ("Se espera ERROR_4, se pidieron unidades negativas del producto."));
        p.ver(s.agregarProductoAPedido("7777777", 3, 14).resultado, Retorno.Resultado.ERROR_5, ("Se espera ERROR_5, se sobrepaso el stock del producto."));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
    }

    public static void p9_deshacerPedido(Prueba p, Sistema s) {
        p.ver(s.deshacerPedido("7777777", 2).resultado, Retorno.Resultado.OK, ("Se espera OK, 2 acciones del pedidoAbierto del cliente 7777777 se deshacen correctamente"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
        p.ver(s.deshacerPedido("7777777", 1).resultado, Retorno.Resultado.OK, ("Se espera OK, la ultima accion del pedidoAbierto del cliente 7777777 se deshace correctamente"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
        p.ver(s.deshacerPedido("ab23455", 1).resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, la cedula ab23455 no existe");
        p.ver(s.deshacerPedido("1111111", 0).resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, Se ingresaron 0 acciones"));
        p.ver(s.deshacerPedido("1111111", -1).resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, Se ingresaron -1 acciones"));
        p.ver(s.deshacerPedido("1111111", 1).resultado, Retorno.Resultado.ERROR_3, ("Se espera ERROR_3, El cliente 1111111 no tiene un pedido abierto"));
        p.ver(s.deshacerPedido("7777777", 4).resultado, Retorno.Resultado.ERROR_3, ("Se espera ERROR_3, Las acciones superan la cantidad del pedido del cliente 7777777"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
        //agregarProductoAPedido luego de haber vaciado el pedido
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
    }

    public static void p10_cerrarPedido(Prueba p, Sistema s) {
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 7777777"));
        p.ver(s.cerrarPedido("ab23455").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, la cedula ab23455 no existe");
        p.ver(s.cerrarPedido("xx12312").resultado, Retorno.Resultado.ERROR_1, "Se espera ERROR_1, la cedula xx12312 no existe");
        p.ver(s.cerrarPedido("3333333").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, el cliente 3333333 no tiene un pedido abierto"));
        p.ver(s.cerrarPedido("4444444").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, el cliente 4444444 no tiene un pedido abierto"));
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, se esta intentando cerrar un pedido abierto vacio"));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, cliente 7777777 ya cerro un pedido y no tiene un pedido abierto"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
    }

    public static void p11_abrirCerrarPedidos(Prueba p, Sistema s) {
        p.ver(s.aperturaDePedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se abre un pedido para cliente con CI 7777777."));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, cliente 7777777 tiene un pedido abierto vacÃ­o."));
        //Remover producto y luego cerrar pedido
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.deshacerPedido("7777777", 1).resultado, Retorno.Resultado.OK, ("Se espera OK, 2 acciones del pedidoAbierto del cliente 7777777 se deshacen correctamente"));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, cliente 7777777 tiene un pedido abierto vacÃ­o."));
        //Agregar productos y cerrar pedido, agregar productos nuevamente
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 7777777"));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK y se muestra el reporte");
    }

    public static void p12a_procesarPedido(Prueba p, Sistema s){
        //Prueba: reporte de pedidos listos para la entrega antes de que existan pedidos procesados
        p.ver(s.productosParaEntregar().resultado, Retorno.Resultado.OK, "Se espera OK, se listan los pedidos listos para entregar");
    }

    public static void p12b_procesarPedido(Prueba p, Sistema s){
        p.ver(s.procesarPedido(1).resultado, Retorno.Resultado.OK, ("Se espera OK, se procesa 1 pedido cerrado"));
        p.ver(s.procesarPedido(0).resultado, Retorno.Resultado.ERROR_1, ("Se espera ERROR_2, se intentan procesar 0 pedidos."));
        p.ver(s.procesarPedido(-1).resultado, Retorno.Resultado.ERROR_1, ("Se espera ERROR_2, se intentan procesar -1 pedidos."));
        p.ver(s.procesarPedido(2).resultado, Retorno.Resultado.ERROR_2, ("Se espera ERROR_2, se procesan 2 pedidos cerrados pero sÃ³lo hay 1 en la queue."));

    }

    public static void p13_pedidosCerradosDeClientes(Prueba p, Sistema s) {
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 7777777."));
        p.ver(s.pedidosCerradosDeClientes("ab1234").resultado, Retorno.Resultado.ERROR_1, ("Se espera ERROR_1, la cedula no existe."));
        //Agregamos stock para cerrar mas pedidos cerrados y listarlos
        p.ver(s.altaStockProducto(3, 20).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 3 existe y 15 es > 0.");
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 7777777."));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 7777777"));
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 7777777."));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 7777777"));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("7777777", 3, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 7777777 3 unidades del producto 3"));
        p.ver(s.cerrarPedido("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 7777777"));
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 7777777."));
        //Procesar 3 pedidos y listar pedidos cerrados (los pedidos procesados deberÃ­an desaparecer)
        p.ver(s.procesarPedido(3).resultado, Retorno.Resultado.OK, ("Se espera OK, se procesan 3 pedido cerrados."));
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 7777777."));

    }

    public static void p14_productosParaEntregar(Prueba p, Sistema s) {
        //Nota: Según la letra, esto muestra Pedidos listos para entregar, pero no cambiamos la firma para no romper nada
        p.ver(s.productosParaEntregar().resultado,Retorno.Resultado.OK,"Se espera OK, se listan los pedidos listos para entregar");
    }

    public static void p15_reporteDePedidosSolicitadosXCliente(Prueba p, Sistema s) {
        //Test inicial
        p.ver(s.reporteDePedidosSolicitadosXCliente().resultado, Retorno.Resultado.OK, ("Se espera OK, se muestra el reporte correctamente."));
        
        //Darle stock a más productos
        p.ver(s.altaStockProducto(2, 100).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 2 existe y 200 es > 0.");
        p.ver(s.altaStockProducto(3, 100).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 3 existe y 200 es > 0.");
        p.ver(s.altaStockProducto(5, 100).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 5 existe y 200 es > 0.");
        p.ver(s.altaStockProducto(6, 100).resultado, Retorno.Resultado.OK, "Se espera OK, el producto 6 existe y 200 es > 0.");
        
        //Poner esos products en pedidos de cliente
        p.ver(s.agregarProductoAPedido("5555555", 2, 10).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 2222222 10 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("5555555", 3, 14).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 2222222 14 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("5555555", 5, 8).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 2222222 8 unidades del producto 5"));
        
        p.ver(s.agregarProductoAPedido("4444444", 2, 3).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 4444444 3 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("4444444", 5, 6).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 4444444 6 unidades del producto 5"));
        p.ver(s.agregarProductoAPedido("4444444", 6, 7).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 4444444 7 unidades del producto 6"));
        p.ver(s.agregarProductoAPedido("4444444", 3, 19).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 4444444 19 unidades del producto 3"));
        
        p.ver(s.agregarProductoAPedido("3333333", 6, 2).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 2 unidades del producto 6"));
        p.ver(s.agregarProductoAPedido("3333333", 2, 5).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 5 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("3333333", 3, 19).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 19 unidades del producto 3"));
        
        p.ver(s.agregarProductoAPedido("2222222", 2, 9).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 9 unidades del producto 2"));
        p.ver(s.agregarProductoAPedido("2222222", 3, 10).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 10 unidades del producto 3"));
        p.ver(s.agregarProductoAPedido("2222222", 5, 15).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 15 unidades del producto 5"));
        p.ver(s.agregarProductoAPedido("2222222", 6, 1).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 1 unidades del producto 6"));
        
        p.ver(s.agregarProductoAPedido("1111111", 3, 10).resultado, Retorno.Resultado.OK, ("Se espera OK, se agrega al pedido del cliente 3333333 10 unidades del producto 3"));
        
        //Cerrar pedidos
        p.ver(s.cerrarPedido("5555555").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 5555555"));
        p.ver(s.cerrarPedido("4444444").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 4444444"));
        p.ver(s.cerrarPedido("3333333").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 3333333"));
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 1111111"));
        p.ver(s.cerrarPedido("1111111").resultado, Retorno.Resultado.OK, ("Se espera OK, Se cierra el pedido del cliente 1111111"));
        
        //Procesar algunos pedidos
        //pasamos -1 del total de pedidos abiertos, si pasamos el total TIRA EXCEPCION la cola esta vacia del metodo de cola obtenerPrimero. El error esta en el metodo cantidadEncargadaPor
        p.ver(s.procesarPedido(6).resultado, Retorno.Resultado.OK, ("Se espera OK, se procesan 1 pedidos cerrados."));
        
        //Testing
        //System.out.print("Los pedidos abiertos son: "); 
        //s.listarPedidosAbiertos();
        
        //Correr el reporte de nuevo
        p.ver(s.reporteDePedidosSolicitadosXCliente().resultado, Retorno.Resultado.OK, ("Se espera OK, se muestra el reporte correctamente."));    
    }
    
    public static void p0_reportesVacios(Prueba p, Sistema s){
        
        p.ver(s.listarClientes().resultado, Retorno.Resultado.OK,"listarClientes, se espera OK, pero el reporte está vacío");
        
        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK,"listarProductos, se espera OK, pero el reporte está vacío");
        
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK,"listarPedidosAbiertos, se espera OK, pero el reporte está vacío");
        
        p.ver(s.pedidosCerradosDeClientes("7777777").resultado, Retorno.Resultado.ERROR_1, ("Se espera ERROR_1, no hay clientes."));
        
        p.ver(s.reporteDePedidosSolicitadosXCliente().resultado, Retorno.Resultado.OK, ("Se espera OK, pero el reporte está vacío, por lo que no se muestra."));
    }

    public static void p16_DefensaOb_cerrarPedido(Prueba p, Sistema s){
        
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        s.agregarProductoAPedido("2222222", 2, 9);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.ERROR_3, ("Se espera ERROR_3, hay 9 unidades y se necesitan > 10"));        
        
        s.agregarProductoAPedido("2222222", 3, 1);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.ERROR_3, ("Se espera ERROR_3, hay 10 unidades y se necesitan > 10"));

        s.agregarProductoAPedido("2222222", 3, 1);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, hay 11 unidades, se cierra el pedido"));
        
        s.agregarProductoAPedido("2222222", 2, 2);
        s.agregarProductoAPedido("2222222", 3, 10);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, hay 12 unidades"));

    }
    
    public static void p17_DefensaOb_pedidosCerradosDeCliente(Prueba p, Sistema s){
        //Cerrar pedidos chicos para confirmar que el listado muestra los pedidos cerrados sólo mayores a 10 unidades
        s.agregarProductoAPedido("2222222", 2, 2);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedidoChicoTest("2222222").resultado, Retorno.Resultado.OK, ("Este método es sólo para generar un pedido menor a 10 unidades y demostrar que no es listado en el método pedidosCerradosDeClientes. 2 unidades.") );
        s.agregarProductoAPedido("2222222", 2, 9);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedidoChicoTest("2222222").resultado, Retorno.Resultado.OK, ("Este método es sólo para generar un pedido menor a 10 unidades y demostrar que no es listado en el método pedidosCerradosDeClientes. 9 unidades.") );     
        s.agregarProductoAPedido("2222222", 2, 10);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedidoChicoTest("2222222").resultado, Retorno.Resultado.OK, ("Este método es sólo para generar un pedido menor a 10 unidades y demostrar que no es listado en el método pedidosCerradosDeClientes. 10 unidades.") );      
        s.agregarProductoAPedido("2222222", 2, 12);
        p.ver(s.listarPedidosAbiertos().resultado, Retorno.Resultado.OK, "Lista pedidos abiertos.");
        p.ver(s.cerrarPedido("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, cierra pedido con 12 unidades"));
        
        //Mostrar los pedidos cerrados del cliente 2222222 con más de 10 unidades
        p.ver(s.pedidosCerradosDeClientes("2222222").resultado, Retorno.Resultado.OK, ("Se espera OK, se listan los pedidos cerrados del cliente 2222222."));
        
    }
    
}
