package com.platzi.market.persistencia;

import com.platzi.market.domain.dto.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import com.platzi.market.persistencia.entity.Producto;
import com.platzi.market.persistencia.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper maper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return maper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(maper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> maper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> maper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = maper.toProducto(product);
        return maper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
