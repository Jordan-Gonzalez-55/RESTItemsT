package com.ibm.academia.restapi.items.servicios;

import com.ibm.academia.restapi.items.modelo.entidades.Articulo;
import com.ibm.academia.restapi.items.modelo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class IArticuloServiceImpl implements IArticuloService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Articulo> buscarTodosArticulos() {

        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://api-productos/api/vi/rest-productos/producto/listar",Producto[].class));
        return productos
                .stream()
                .map(p-> new Articulo(p,1))
                .collect(Collectors.toList());
    }

    @Override
    public Articulo buscarArticuloPorId(Long productoid, Integer cantidad) {

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", productoid.toString());
        Producto producto = clienteRest.getForObject("http://api-productos/api/vi/rest-productos/producto/ver-detalle/id/{id}",Producto.class, pathVariables);
        return new Articulo(producto, cantidad);
    }
}
