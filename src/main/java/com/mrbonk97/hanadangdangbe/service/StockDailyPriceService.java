package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.repository.StockDailyPriceRepository;
import com.mrbonk97.hanadangdangbe.repository.StockInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockDailyPriceService {
    private final StockDailyPriceRepository stockDailyPriceRepository;
    private final StockInfoRepository stockInfoRepository;

    public List<StockDailyPrice> save(String code, List<StockDailyPrice> stockDailyPrices) {
        for (var e : stockDailyPrices) e.setCode(code);
        return stockDailyPriceRepository.saveAll(stockDailyPrices);
    }

    public List<StockDailyPrice> getStockDailyPriceByCode(String code) {
        return stockDailyPriceRepository.findAllByCodeAndStckBsopDateAfterOrderByStckBsopDateAsc(code, "20240404");
    }

    public List<StockDailyPrice> getStockPriceList(String c1, String c2, String c3, String c4, String c5) {
        List<StockDailyPrice> stockDailyPrices = new ArrayList<>();
        if (c1 != null && !c1.equals("undefined")) {
            StockDailyPrice stock = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(c1).orElseThrow(() -> new RuntimeException("해당 코드 없음"));
            StockInfo stockInfo = stockInfoRepository.findByCode(c1).orElseThrow(() -> new RuntimeException("해당하는 코드 없음"));
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stockDailyPrices.add(stock);
        }
        if (c2 != null && !c2.equals("undefined")) {
            StockDailyPrice stock = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(c2).orElseThrow(() -> new RuntimeException("해당 코드 없음"));
            StockInfo stockInfo = stockInfoRepository.findByCode(c2).orElseThrow(() -> new RuntimeException("해당하는 코드 없음"));
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stockDailyPrices.add(stock);
        }
        if (c3 != null && !c3.equals("undefined")) {
            StockDailyPrice stock = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(c3).orElseThrow(() -> new RuntimeException("해당 코드 없음"));
            StockInfo stockInfo = stockInfoRepository.findByCode(c3).orElseThrow(() -> new RuntimeException("해당하는 코드 없음"));
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stockDailyPrices.add(stock);
        }
        if (c4 != null && !c4.equals("undefined")) {
            StockDailyPrice stock = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(c4).orElseThrow(() -> new RuntimeException("해당 코드 없음"));
            StockInfo stockInfo = stockInfoRepository.findByCode(c4).orElseThrow(() -> new RuntimeException("해당하는 코드 없음"));
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stockDailyPrices.add(stock);
        }

        if (c5 != null && !c5.equals("undefined")) {
            StockDailyPrice stock = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(c5).orElseThrow(() -> new RuntimeException("해당 코드 없음"));
            StockInfo stockInfo = stockInfoRepository.findByCode(c5).orElseThrow(() -> new RuntimeException("해당하는 코드 없음"));
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stock.setTitle(stockInfo.getPrdt_abrv_name());
            stockDailyPrices.add(stock);
        }

        return stockDailyPrices;

    }
}
