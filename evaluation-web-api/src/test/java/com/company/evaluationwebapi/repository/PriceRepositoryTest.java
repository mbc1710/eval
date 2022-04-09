package com.company.evaluationwebapi.repository;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.company.evaluationwebapi.Order;


public class PriceRepositoryTest extends BaseRepositoryTest {

    @Test
    @Order(order = 1)
    public void findByStartDateThanEqualProductIdBrandId () throws ParseException {
         when(priceRepository.findByStartDateThanEqualProductIdBrandId(isA(Date.class), isA(Integer.class), isA(Integer.class))).thenReturn(priceList);
    }
}
