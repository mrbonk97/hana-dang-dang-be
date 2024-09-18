package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.StockBuyRequest;
import com.mrbonk97.hanadangdangbe.controller.response.StockCurrentPriceResponse;
import com.mrbonk97.hanadangdangbe.dto.StockPriceDto;
import com.mrbonk97.hanadangdangbe.dto.StockPriceResponse;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.service.HanTuService;
import com.mrbonk97.hanadangdangbe.service.StockInfoService;
import com.mrbonk97.hanadangdangbe.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {
    private final StockInfoService stockInfoService;
    private final HanTuService hanTuService;
    private final StockService stockService;

    @PostMapping
    public ResponseEntity<StockInfo> saveStockInfoData(@RequestBody StockInfo stockInfo) {
        return ResponseEntity.ok(stockInfoService.save(stockInfo));
    }


    @GetMapping("/{code}")
    public ResponseEntity<Mono<StockCurrentPriceResponse>> getStockInfoData(@PathVariable String code) {
        log.info("종목 조회 {}", code);
        StockInfo stockInfo = stockInfoService.getStockInfoByCode(code);
        Mono<StockPriceResponse> stockPriceResponseMono = hanTuService.getStockPrice(code);

        return ResponseEntity.ok(StockCurrentPriceResponse.from(stockInfo, stockPriceResponseMono));
    }

    @PostMapping("/buy")
    public ResponseEntity<Void> buyStock(@RequestBody StockBuyRequest stockBuyRequest) {
        stockService.buyStock(stockBuyRequest.getAccountId(), stockBuyRequest.getPrice(), stockBuyRequest.getQuantity(), stockBuyRequest.getStockCode());
        log.info("사용자가 주식을 구매: 사용자 아이디: {}, 주식 코드: {}, 수량: {}, 가격: {}", stockBuyRequest.getAccountId(), stockBuyRequest.getStockCode(), stockBuyRequest.getQuantity(), stockBuyRequest.getPrice());
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<StockPriceDto>> getAllStockWithPrice() {
        log.info("종목 목록 조회");
        return ResponseEntity.ok(stockService.getStockPriceList());
    }


}
