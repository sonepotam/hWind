package ru.pavel2107.hwind.service;

import org.springframework.data.domain.Page;
import ru.pavel2107.hwind.model.Product;

import java.util.List;

/**
 * Created by admin on 30.03.2016.
 *
 */
public interface ProductService {
    Product save(Product product);
    void delete( Integer ID);
    Product get( Integer ID);
    Page<Product> findAll( String lang, int startPage, int count);
    Page<Product> findSorted( String lang, String productName, int startPage, int count);
}
