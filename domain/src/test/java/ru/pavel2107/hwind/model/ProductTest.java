package ru.pavel2107.hwind.model;

import org.hibernate.engine.internal.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 29.03.2016.
 */
public class ProductTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getProductNames() throws Exception {

    }

    @Test
    public void setProductNames() throws Exception {

    }

    @Test
    public void getSpice() throws Exception {

    }

    @Test
    public void setSpice() throws Exception {
        Product product = new Product();
        product.setSpice( false);
        assertTrue( "wrong ID", !product.getSpice());
    }

    @Test
    public void getID() throws Exception {

    }

    @Test
    public void setID() throws Exception {
        Product product = new Product();
        product.setID(1);
        assertTrue( "wrong ID", product.getID() == 1);
    }

    @Test
    public void getProductType() throws Exception {

    }

    @Test
    public void setProductType() throws Exception {
        Product product = new Product();
        List<ProductName> list = new ArrayList<>();
        ProductName engName = new ProductName();
        engName.setID(1);
        engName.setLanguage( "fr_fr");
        engName.setProductName( "hello");
        list.add( engName);
      //  product.setProductNames( list);

   //     list = product.getProductNames();

    }
}