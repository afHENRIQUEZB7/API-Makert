package com.platzi.market.persistencia.crud;

import com.platzi.market.persistencia.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Recuperar una lista de productos que vengan de una categoria.
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // Recuperar los productos escasos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStock, boolean estado);
}
