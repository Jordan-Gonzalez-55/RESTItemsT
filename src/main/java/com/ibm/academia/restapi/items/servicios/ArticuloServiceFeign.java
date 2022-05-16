package com.ibm.academia.restapi.items.servicios;

import com.ibm.academia.restapi.items.clientes.ProductoClienteRest;
import com.ibm.academia.restapi.items.modelo.entidades.Articulo;
import com.ibm.academia.restapi.items.modelo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
//@Primary
public class ArticuloServiceFeign implements IArticuloService{
    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Articulo> buscarTodosArticulos() {
        return clienteFeign.consultarTodosProductos()
                .stream()
                .map(p -> new Articulo(p,1))
                .collect(Collectors.toList());
    }

    @Override
    public Articulo buscarArticuloPorId(Long productoid, Integer cantidad) {
        return new Articulo(clienteFeign.verDetalleProducto(productoid), cantidad);
    }
}
