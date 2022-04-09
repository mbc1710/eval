package com.company.evaluationwebapi.service;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.company.evaluationwebapi.Order;
import com.company.evaluationwebapi.dto.PriceDTO;


public class PriceServiceImplTest extends BaseServiceTest {

    @Test
    @Order(order = 1)
    public void getPricesList () {
        when(priceRepository.findByStartDateThanEqualProductIdBrandId(isA(Date.class), isA(Integer.class), isA(Integer.class))).thenReturn(priceList);
        List<PriceDTO> result = priceServiceImpl.getPricesList("2020-06-14 10:00:00", 35455, 1);
        assertNotEquals(0, result.size());
    }
}
