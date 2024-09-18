package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDailyPriceRepository extends JpaRepository<StockDailyPrice, String> {
    List<StockDailyPrice> findAllByCodeAndStckBsopDateAfterOrderByStckBsopDateAsc(String code, String stckBsopDate);
    List<StockDailyPrice> findAllByCode(String code);
}
