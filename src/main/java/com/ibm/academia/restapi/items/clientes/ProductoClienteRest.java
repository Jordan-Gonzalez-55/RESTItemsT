package com.ibm.academia.restapi.items.clientes;

import com.ibm.academia.restapi.items.modelo.entidades.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Este no se puede quitar
@FeignClient(name = "api-productos", url = "localhost:8001")
public interface ProductoClienteRest {

    @GetMapping("/api/vi/rest-productos/producto/listar")
    public List<Producto> consultarTodosProductos();

    @GetMapping("/api/vi/rest-productos/producto/ver-detalle/id/{productoId}")
    public  Producto verDetalleProducto(@PathVariable Long productoId);



    }
