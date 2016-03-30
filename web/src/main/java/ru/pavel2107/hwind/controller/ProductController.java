package ru.pavel2107.hwind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.pavel2107.hwind.dto.ProductDTO;
import ru.pavel2107.hwind.model.Product;
import ru.pavel2107.hwind.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 30.03.2016.
 */

@RestController
@RequestMapping( "/rest/product")
@Transactional( readOnly = true)
public class ProductController {

    @Autowired
    ProductService service;


    @RequestMapping( value="/{lang}/{startPage}/{size}", method = RequestMethod.GET)
    public List<ProductDTO> getAll( @PathVariable("lang") String lang,
                                    @PathVariable("startPage") int startPage,
                                    @PathVariable("size") int size){
        List<Product> list = service.findAll( lang, startPage, size);
        List<ProductDTO> listDTO = new ArrayList<>();
        for( Product product: list){
            listDTO.add( ProductDTO.convertProductToProductDTO( product));
        }
        return listDTO;
    }


    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public ProductDTO get(@PathVariable("id") Integer id){
        Product product = service.get( id);
        ProductDTO productDTO = ProductDTO.convertProductToProductDTO( product);
        return productDTO;
    }


    @RequestMapping( method = RequestMethod.POST)
    public void updateOrCreate(ProductDTO productDTO, BindingResult result, SessionStatus status){
        status.setComplete();
        service.save( ProductDTO.convertProductDTOToProduct( productDTO));
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        service.delete( id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }



}
