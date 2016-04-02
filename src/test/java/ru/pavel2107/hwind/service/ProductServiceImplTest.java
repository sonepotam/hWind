package ru.pavel2107.hwind.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.hwind.model.Product;

/**
 * Created by pavel2107 on 02.04.16.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest extends TestCase {

    @Autowired
    ProductService service;

    @Test
    public void testGet() throws Exception {
        Product product = service.get( 40);
        assertTrue( "broken",  product != null);
        System.out.println( product.toString());
    }


    @Test
    public void testSave() throws Exception {
        Product product = service.get( 40);
        System.out.println( product.toString());
        String before = product.toString();
        product.setSpice( !product.getSpice());
        product = service.save( product);

        System.out.println( product.toString());
        assertTrue( "broken", !before.equals( product.toString()));

    }

    public void testDelete() throws Exception {

    }

    public void testFindAll() throws Exception {

    }
}