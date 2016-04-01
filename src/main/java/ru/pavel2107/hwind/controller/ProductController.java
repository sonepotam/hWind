package ru.pavel2107.hwind.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.pavel2107.hwind.dto.ProductDTO;
import ru.pavel2107.hwind.model.Product;
import ru.pavel2107.hwind.model.ProductName;
import ru.pavel2107.hwind.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.json.*;

/**
 * Created by admin on 30.03.2016.
 */

@RestController
@RequestMapping( "/rest/product")
@Transactional( readOnly = true)
public class ProductController {

    @Autowired
    ProductService service;


    @Autowired
    private HttpServletRequest request;


    @RequestMapping(  method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){

        String pageNo = request.getParameter("iDisplayStart");
        String pageSize = request.getParameter("iDisplayLength");
        String colIndex = request.getParameter("iSortCol_0");
        String sortDirection = request.getParameter("sSortDir_0");
        String lang          = "ru_ru";

        int startPage = 0;
        int size      = 10;

        if( pageNo != null){
            startPage = Integer.parseInt( pageNo);
            size      = Integer.parseInt( pageSize);
        }
        startPage = startPage/ size;

        Page<Product> page = service.findAll( lang, startPage, size);

        JSONObject result = new JSONObject();
        result.put("iTotalRecords", page.getTotalElements());
        result.put("iTotalDisplayRecords", page.getTotalElements());

        JSONArray array = new JSONArray();
        for( Product product: page.getContent()){
            JSONArray row = new JSONArray();

            row.put( product.getID());
            Optional<ProductName> name =       product.getProductNames()
                    .stream()
                    .filter( p ->( lang.equals( p.getLanguage())))
                    .findFirst();
            row.put( name.isPresent() ? name.get().getProductName() : "???");
            row.put( product.getProductType());
            row.put( product.getSpice()? "Да" : "Нет" );
            row.put( "Delete");
            row.put( "Edit");
            array.put( row);

        }

        result.put("aaData", array);

        return result.toString();
    }





    @RequestMapping( value = "/{id}/{lang}", method = RequestMethod.GET)
    public ProductDTO get(@PathVariable("id") Integer id, @PathVariable("lang") String lang){
        Product product = service.get( id);
        ProductDTO productDTO = ProductDTO.convertProductToProductDTO( product, lang);
        return productDTO;
    }


    @RequestMapping( method = RequestMethod.POST)
    @Transactional
    public void updateOrCreate(@RequestBody ProductDTO productDTO, BindingResult result, SessionStatus status){
        status.setComplete();
        Product product;
        if( productDTO.getId() == null){
            product = new Product();
        }
        else {
            product = service.get( productDTO.getId());
        }
        product.setSpice( productDTO.getSpice());
        product.setProductType( productDTO.getProductType());
        Set<ProductName> nameSet = product.getProductNames();
        ProductName p = new ProductName( productDTO.getLang(), productDTO.getProductName());
        nameSet.add( p);


        service.save( product);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        service.delete( id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }



}
