package com.company.evaluationwebapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.evaluationwebapi.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query(value = "SELECT p from Price p WHERE p.startDate =:startDate AND p.productId=:productId AND p.brand.brandId=:brandId")
    public List<Price> findByStartDateThanEqualProductIdBrandId(Date startDate, Integer productId, Integer brandId);
}
