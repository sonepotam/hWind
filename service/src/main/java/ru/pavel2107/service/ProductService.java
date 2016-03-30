package ru.pavel2107.service;

import ru.pavel2107.hwind.model.Product;

import java.util.List;

/**
 * Created by admin on 30.03.2016.
 *
 */
public interface ProductService {
    Product save(Product product);
    void delete( Product product);
    Product get( Integer ID);
    List<Product> findAll( String lang, int startPage, int count);
}
