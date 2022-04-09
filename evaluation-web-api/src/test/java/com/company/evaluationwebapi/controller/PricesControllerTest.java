package com.company.evaluationwebapi.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.company.evaluationwebapi.Order;

public class PricesControllerTest extends BaseControllerTest {
    
    @Test
    @Order(order = 1)
    public void getPricesList() throws Exception {
        final String url = new StringBuilder().append("/prices/{dateApplication}/{productId}/{brandId}").toString();
        when(priceServiceImpl.getPricesList(isA(String.class),isA(Integer.class),isA(Integer.class))).thenReturn(this.priceDTOList);
        final RequestBuilder request = MockMvcRequestBuilders.get(url,"2020-06-14 10:00:00", 35455, 1).accept(contentType).contentType(contentType);
        super.MOCK.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.status").value(200))
        .andExpect(jsonPath("$.responseBody.[0].productId").value(priceDTOList.get(0).getProductId())).andDo(print()).andReturn();       
    }
    
    @Test
    @Order(order = 1)
    public void getPricesList1() throws Exception {
        final String url = new StringBuilder().append("/prices/{dateApplication}/{productId}/{brandId}").toString();
        when(priceServiceImpl.getPricesList(isA(String.class),isA(Integer.class),isA(Integer.class))).thenReturn(this.priceDTOList1);
        final RequestBuilder request = MockMvcRequestBuilders.get(url,"2020-06-14 16:00:00", 35455, 1).accept(contentType).contentType(contentType);
        super.MOCK.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.status").value(200))
        .andExpect(jsonPath("$.responseBody.[0].productId").value(priceDTOList.get(0).getProductId())).andDo(print()).andReturn();       
    }

}
