package com.company.evaluationwebapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.evaluationwebapi.dto.PriceDTO;
import com.company.evaluationwebapi.exceptions.ServiceException;
import com.company.evaluationwebapi.service.MessageService;
import com.company.evaluationwebapi.service.PriceService;
import com.company.evaluationwebapi.utils.Response;


@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/prices")
public class PricesController {

    final static Logger LOGGER = LoggerFactory.getLogger(PricesController.class);

    @Autowired
    private PriceService priceService;
    
    @Autowired
    private MessageService messageService;

    @GetMapping(path = "/{dateApplication}/{productId}/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Response<List<PriceDTO>>> getPricesList(@PathVariable(name = "dateApplication") String dateApplication, 
            @PathVariable(name = "productId") Integer productId, @PathVariable(name = "brandId") Integer brandId) throws Exception{
        Response<List<PriceDTO>> response = null;
        try {
            response = new Response<>(priceService.getPricesList(dateApplication, productId, brandId), messageService.getMessage("api.generic.success.messages.1001"));
        } catch (ServiceException ex) {
            LOGGER.error(ex.getMessage(), ex);             
            response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.buildListError(ex), 
                    messageService.getMessage("api.notification.messages.title.FAILED") + ex.getCause());
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

}
