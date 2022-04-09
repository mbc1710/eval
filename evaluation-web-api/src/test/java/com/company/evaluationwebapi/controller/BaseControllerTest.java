package com.company.evaluationwebapi.controller;

import java.nio.charset.Charset;
import java.util.Locale;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.company.evaluationwebapi.BaseTest;
import com.company.evaluationwebapi.OrderedRunner;
import com.company.evaluationwebapi.service.impl.PriceServiceImpl;


@RunWith(OrderedRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BaseControllerTest extends BaseTest {

    @Autowired
    private WebApplicationContext context;
    protected MockMvc MOCK;
    protected final static Locale LOCALE = new Locale("es", "MX");
    protected MediaType contentType;
    protected HttpHeaders httpHeaders = new HttpHeaders();

    @MockBean
    protected PriceServiceImpl priceServiceImpl; 

    public BaseControllerTest() {
        this.setUpContentType();
    }

    @Before
    public void setup () {
        this.MOCK = MockMvcBuilders.webAppContextSetup(context).build();
    }

    protected void setUpContentType () {
        this.contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    }

}
