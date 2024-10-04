package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.StockBuyRequest;
import com.mrbonk97.hanadangdangbe.controller.response.DailyStockPriceResponse;
import com.mrbonk97.hanadangdangbe.dto.*;
import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
import com.mrbonk97.hanadangdangbe.service.HanTuService;
import com.mrbonk97.hanadangdangbe.service.StockDailyPriceService;
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
    private final StockDailyPriceService stockDailyPriceService;
    private final StockMapper stockMapper;

    @GetMapping("/rank")
    public ResponseEntity<Mono<StockListRankDto>> getStockListRank() {
        log.info("거래량 순위 조회");
        return ResponseEntity.ok(hanTuService.getStockListRank());
    }

    @PostMapping
    public ResponseEntity<StockInfo> saveStockInfoData(@RequestBody StockInfo stockInfo) {
        return ResponseEntity.ok(stockInfoService.save(stockInfo));
    }

    @GetMapping("/{code}/minute")
    public ResponseEntity<Mono<StockMinuteDto>> getStockMinuteData(@PathVariable String code, @RequestParam String time) {
        log.info("주식 분봉 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getStockMinuteData(code, time));
    }


    @GetMapping("/{code}/price")
    public ResponseEntity<Mono<StockPriceDto>> getStockInfoData(@PathVariable String code) {
        log.info("주식현재가 시세 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getStockPrice(code));
    }

    @GetMapping("/{code}/info")
    public ResponseEntity<Mono<StockInfoDto>> getStockInfo(@PathVariable String code) {
        log.info("주식기본정보 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getStockInfo("300", code));
    }

    @PostMapping("/buy")
    public ResponseEntity<StockTransaction> buyStock(@RequestBody StockBuyRequest stockBuyRequest) {
        log.info("사용자가 주식을 구매: 사용자 아이디: {}, 주식 코드: {}, 수량: {}, 가격: {}", stockBuyRequest.getAccountId(), stockBuyRequest.getStockCode(), stockBuyRequest.getQuantity(), stockBuyRequest.getPrice());
        StockTransaction stockTransaction = stockService.buyStock(stockBuyRequest.getAccountId(), stockBuyRequest.getPrice(), stockBuyRequest.getQuantity(), stockBuyRequest.getStockCode());
        return ResponseEntity.ok(stockTransaction);
    }

    @GetMapping
    public ResponseEntity<List<StockPriceDto>> getAllStockWithPrice() {
        log.info("종목 목록 조회");
        return ResponseEntity.ok(stockService.getStockPriceList());
    }

    @GetMapping("/{code}/opinion")
    public ResponseEntity<Mono<StockOpinionDto>> getStockOpinionByCode(@PathVariable String code) {
        log.info("국내주식 종목투자의견 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getStockOpinion(code));
    }

    @GetMapping("/{code}/recent-price")
    public ResponseEntity<Mono<StockRecentPriceDto>> getStockRecentPriceByCode(@PathVariable String code) {
        log.info("주식현재가 일자별 {}", code);
        return ResponseEntity.ok(hanTuService.getStockRecentPrice(code));
    }

    @GetMapping("/{code}/hoka")
    public ResponseEntity<Mono<StockHokaDto>> getStockHoka(@PathVariable String code) {
        log.info("주식현재가 호가/예상 체결 {}", code);
        return ResponseEntity.ok(hanTuService.getStockHoka(code));
    }

    @GetMapping("/{code}/daily")
    public ResponseEntity<DailyStockPriceResponse> getStockPriceDaily(@PathVariable String code) {
        log.info("주식 일자별 가격 {}", code);
        return ResponseEntity.ok(DailyStockPriceResponse.from(stockDailyPriceService.getStockDailyPriceByCode(code)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchStockDto>> searchStock(@RequestParam String keyword) {
        log.info("주식 검색 {}", keyword);
        return ResponseEntity.ok(stockMapper.selectSearchStockList(keyword));
    }


}
