package ru.pavel2107.hwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Transactional
    public Product save(Product product) {
        return repository.save( product);
    }

    @Transactional
    public void delete(Integer ID) {
       repository.delete( ID);
    }

    public Product get(Integer ID) {
        return repository.findOne( ID);
    }

    public Page<Product> findAll(String lang, int startPage, int size) {
      Page<Product> page =  repository.findAll( new PageRequest( startPage, size));
      return page;
    }

    /*
    public List<Product> findSorted(String lang, String productName, int startPage, int size) {
        List<Product> page =  repository.findByNameLanguageAndNameProductNameStartingWith( lang, productName); //, new PageRequest( startPage, size));
        return page;
    }
*/
    public Page<Product> findSorted(String lang, String productName, int startPage, int size) {
        Page<Product> page =  repository.findByNameLanguageAndNameProductNameStartingWith( lang, productName, new PageRequest( startPage, size));
        return page;
    }

}
