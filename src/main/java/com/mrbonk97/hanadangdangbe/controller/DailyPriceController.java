package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.StockDailyPriceCreateRequest;
import com.mrbonk97.hanadangdangbe.controller.response.StockInfoListResponse;
import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.service.StockDailyPriceService;
import com.mrbonk97.hanadangdangbe.service.StockInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/daily-price")
public class DailyPriceController {
    private final StockDailyPriceService stockDailyPriceService;

    @PostMapping
    public ResponseEntity<String> saveALl(@RequestBody StockDailyPriceCreateRequest stockDailyPriceCreateRequest) {
        stockDailyPriceService.save(stockDailyPriceCreateRequest.getCode(), stockDailyPriceCreateRequest.getStockDailyPrices());
        log.info("잘 저장함 {}", stockDailyPriceCreateRequest.getStockDailyPrices());
        return ResponseEntity.ok("잘 저장함 ㅋ");
    }


}
