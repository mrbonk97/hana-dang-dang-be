package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import com.mrbonk97.hanadangdangbe.repository.StockDailyPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockDailyPriceService {
    private final StockDailyPriceRepository stockDailyPriceRepository;

    public List<StockDailyPrice> save(String code, List<StockDailyPrice> stockDailyPrices) {
        for(var e: stockDailyPrices) e.setCode(code);
        return stockDailyPriceRepository.saveAll(stockDailyPrices);
    }

    public List<StockDailyPrice> getStockDailyPriceByCode(String code) {
        return stockDailyPriceRepository.findAllByCodeAndStckBsopDateAfterOrderByStckBsopDateAsc(code, "20240404");
    }
}
