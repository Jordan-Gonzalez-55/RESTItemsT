package com.ibm.academia.restapi.items.servicios;

import com.ibm.academia.restapi.items.modelo.entidades.Articulo;

import java.util.List;
import java.util.Optional;

public interface IArticuloService {
    public List<Articulo> buscarTodosArticulos();
    public Articulo buscarArticuloPorId(Long productoid, Integer cantidad);
}
