package com.company.evaluationwebapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PriceDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer ratePriceId;
    private String startDate;
    private String endDate;
    private Integer productId;
    private Double price;
    private Integer brandId;
}
