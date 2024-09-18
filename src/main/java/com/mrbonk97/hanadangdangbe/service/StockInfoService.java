package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.repository.StockInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockInfoService {
    private final StockInfoRepository stockInfoRepository;

    public StockInfo save(StockInfo stockInfo) {
        return stockInfoRepository.save(stockInfo);
    }

    public StockInfo getStockInfoByCode(String code) {
        return stockInfoRepository.findByCode(code).orElseThrow(() -> new RuntimeException("코드에 해당하는 주식 없음"));
    }

    public List<StockInfo> getStockInfoList() {
        return stockInfoRepository.findAll();
    }

}
