package ru.pavel2107.hwind.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.pavel2107.hwind.model.PRODUCT_TYPE;
import ru.pavel2107.hwind.model.Product;
import ru.pavel2107.hwind.model.ProductName;

import javax.annotation.PostConstruct;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by admin on 30.03.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductControllerTest {

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();
    private static final String REST_URL = "/rest/product";

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }


    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ProductController controller;


    @PostConstruct
    void postConstruct() throws Exception {


        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .build();
    }


    @Test
    public void testGetAll() throws Exception {
        String lang = "ru_ru";
        String start = "2";
        String size  = "5";

        mockMvc.perform(get(REST_URL + "/" + lang)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())

        ;


    }

    @Test
    public void testGet() throws Exception {

        String lang = "ru_ru";
        String id = "1";

        mockMvc.perform(get(REST_URL + "/" + id + "/" + lang)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testDelete() throws Exception {
        String id = "1";

        mockMvc.perform(delete(REST_URL + "/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }


    @Test
    public void testUpdateOrCreate() throws Exception {

    }

}