package com.company.evaluationwebapi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.evaluationwebapi.converter.PriceConverter;
import com.company.evaluationwebapi.dto.PriceDTO;
import com.company.evaluationwebapi.exceptions.ServiceException;
import com.company.evaluationwebapi.repository.PriceRepository;
import com.company.evaluationwebapi.service.MessageService;
import com.company.evaluationwebapi.service.PriceService;
import com.company.evaluationwebapi.utils.Utils;

@Service
public class PriceServiceImpl implements PriceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Autowired
    private PriceRepository priceRepository;
    
    @Autowired
    private MessageService messageService;

    @Override
    public List<PriceDTO> getPricesList (String dateApplication, Integer productId, Integer brandId) {
        List<PriceDTO> response;
        try {
            response = PriceConverter.convertToPriceDTOFromPriceList(
                    priceRepository.findByStartDateThanEqualProductIdBrandId(Utils.parseStringToDate(dateApplication), productId, brandId));
        } catch (Exception ex) {
            LOGGER.error(messageService.getMessage("api.generic.error.messages.1000") + ex.getCause(), ex);
            throw new ServiceException(messageService.getMessage("api.generic.error.messages.1000") + ex.getCause(), ex);
        }
        return response;
    }

}
