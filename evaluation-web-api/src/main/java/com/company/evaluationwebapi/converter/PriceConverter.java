package com.company.evaluationwebapi.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.company.evaluationwebapi.dto.PriceDTO;
import com.company.evaluationwebapi.model.Price;
import com.company.evaluationwebapi.utils.Utils;

public class PriceConverter {

    public static List<PriceDTO> convertToPriceDTOFromPriceList (Iterable<Price> listDTO) {
        return StreamSupport.stream(listDTO.spliterator(), false)
                .map(mapper -> convertToPriceDTOFromPrice(mapper))
                .collect(Collectors.toList());
    }

    public static PriceDTO convertToPriceDTOFromPrice (Price price) {
        return PriceDTO.builder()
                .ratePriceId(price.getRatePriceId())
                .productId(price.getProductId())
                .startDate(Utils.parseDateToString(price.getStartDate()))
                .endDate(Utils.parseDateToString(price.getEndDate()))
                .brandId(price.getBrand().getBrandId())
                .price(price.getPrice())
                .build();
    }
}
