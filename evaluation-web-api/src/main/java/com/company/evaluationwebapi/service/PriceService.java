package com.company.evaluationwebapi.service;

import java.util.List;

import com.company.evaluationwebapi.dto.PriceDTO;

public interface PriceService {

    public List<PriceDTO> getPricesList(String dateApplication, Integer productId, Integer brandId);

}
