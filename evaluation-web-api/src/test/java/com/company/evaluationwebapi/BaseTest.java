package com.company.evaluationwebapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.evaluationwebapi.dto.PriceDTO;
import com.company.evaluationwebapi.model.Brand;
import com.company.evaluationwebapi.model.Price;

import ch.qos.logback.classic.BasicConfigurator;

public abstract class BaseTest {

    public BaseTest() {
        this.setup();
    }

    protected final static Logger LOGGER = LoggerFactory.getLogger(BasicConfigurator.class);

     protected String contextPath = "/api";
     protected List<PriceDTO> priceDTOList = new ArrayList<>();
     protected List<Price> priceList = new ArrayList<>();
     protected PriceDTO priceDTO = new PriceDTO();
     protected List<PriceDTO> priceDTOList1 = new ArrayList<>();

    private void setup () {
        this.setMemoryPriceList();
        this.setMemoryPriceDTOList();
        this.setMemoryPriceDTOList1();
    }

    private void setMemoryPriceList () {
        List<Price> priceList = new ArrayList<>();
        Price price = new Price();
        price.setBrand(new Brand(1));
        price.setEndDate(new Date());
        price.setStartDate(new Date());
        price.setPrice(30.80);
        price.setRatePriceId(0);
        price.setProductId(35455);
        price.setCurr("EUR");
        price.setPriority(0);
        Price price1 = new Price();
        price1.setBrand(new Brand(1));
        price1.setEndDate(new Date());
        price1.setStartDate(new Date());
        price1.setPrice(36.00);
        price1.setRatePriceId(1);
        price1.setProductId(35455);
        price1.setCurr("EUR");
        price1.setPriority(1);
        priceList.add(price);
        priceList.add(price1);
        this.priceList = priceList;
    }
    
    private void setMemoryPriceDTOList () {
        List<PriceDTO> priceDTOList = new ArrayList<>();
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setBrandId(1);
        priceDTO.setEndDate("2020-12-30 23:59:59");
        priceDTO.setStartDate("2020-06-14 00:00:00");
        priceDTO.setPrice(35.50);
        priceDTO.setRatePriceId(1);
        priceDTO.setProductId(35455);
        PriceDTO priceDTO1 = new PriceDTO();
        priceDTO1.setBrandId(1);
        priceDTO1.setEndDate("2020-06-14 14:18:30");
        priceDTO1.setStartDate("2020-06-14 15:00:00");
        priceDTO1.setPrice(25.45);
        priceDTO1.setRatePriceId(2);
        priceDTO1.setProductId(35455);
        this.priceDTO = priceDTO;
        priceDTOList.add(priceDTO);
        priceDTOList.add(priceDTO1);
        this.priceDTOList = priceDTOList;
    }
    
    private void setMemoryPriceDTOList1 () {
        List<PriceDTO> priceDTOList = new ArrayList<>();
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setBrandId(1);
        priceDTO.setEndDate("2020-06-14 19:00:00");
        priceDTO.setStartDate("2020-06-14 16:00:00");
        priceDTO.setPrice(25.45);
        priceDTO.setRatePriceId(2);
        priceDTO.setProductId(35455);
        priceDTOList.add(priceDTO);
        this.priceDTOList1 = priceDTOList;
    }

}
