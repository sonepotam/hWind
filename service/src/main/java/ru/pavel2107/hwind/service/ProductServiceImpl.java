package ru.pavel2107.hwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.hwind.model.Product;
import ru.pavel2107.hwind.repository.ProductRepository;

import java.util.List;

/**
 * Created by admin on 30.03.2016.
 */
@Service( "ProductService")
@Transactional( readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    public Product save(Product product) {
        return repository.save( product);
    }

    public void delete(Integer ID) {
       repository.delete( ID);
    }

    public Product get(Integer ID) {
        return repository.findOne( ID);
    }

    public List<Product> findAll(String lang, int startPage, int size) {
        //return (List<Product>)repository. findByProductNamesLanguage( lang,
        //        new PageRequest( startPage, size, Sort.Direction.ASC, "name"));
        return repository.findAll();
    }
}
