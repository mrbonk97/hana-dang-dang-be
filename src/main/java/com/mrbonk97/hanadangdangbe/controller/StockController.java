package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.StockBuyRequest;
import com.mrbonk97.hanadangdangbe.controller.request.StockListPriceRequest;
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

    // 코스피 리스트 전체 조회
    @GetMapping
    public ResponseEntity<List<StockListDto>> getAllStockWithPrice(@RequestParam int page) {
        log.info("종목 목록 조회 페이지 {}", page);
        return ResponseEntity.ok(stockMapper.selectfindStockListPage(page));
    }

    // 상위 30개 순위
    @GetMapping("/rank")
    public ResponseEntity<Mono<StockListRankDto>> getStockListRank(@RequestParam String type) {
        log.info("거래량 순위 조회 {}", type);
        if (type.equals("vol")) return ResponseEntity.ok(hanTuService.getStockListRankVol());
        if (type.equals("rsfl")) return ResponseEntity.ok(hanTuService.getStockListRankRsfl());
        if (type.equals("power")) return ResponseEntity.ok(hanTuService.getStockListRankPower());
        if (type.equals("short")) return ResponseEntity.ok(hanTuService.getStockListRankShort());
        throw new RuntimeException("잘못된 타입");
    }

    // 매일 밤 DB에 자동으로 저장하는 코드
    @PostMapping
    public ResponseEntity<StockInfo> saveStockInfoData(@RequestBody StockInfo stockInfo) {
        return ResponseEntity.ok(stockInfoService.save(stockInfo));
    }

    // 주식 분봉 조회
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

    @GetMapping("/list-price")
    public ResponseEntity<List<StockDailyPrice>> getStockPriceList(@RequestParam(required = false) String c1,
                                                                   @RequestParam(required = false) String c2,
                                                                   @RequestParam(required = false) String c3,
                                                                   @RequestParam(required = false) String c4,
                                                                   @RequestParam(required = false) String c5) {
        log.info("포트폴리오 조정 주식 목록 가격 조회 {} {} {} {} {}",c1,c2,c3,c4,c5);
        return ResponseEntity.ok(stockDailyPriceService.getStockPriceList(c1,c2,c3,c4,c5));
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

    @PostMapping("/order")
    public ResponseEntity<String> orderStock(@RequestBody StockBuyRequest stockBuyRequest) {
        log.info("사용자가 주식을 매수 주문: 사용자 아이디: {}, 주식 코드: {}, 수량: {}, 가격: {}", stockBuyRequest.getAccountId(), stockBuyRequest.getStockCode(), stockBuyRequest.getQuantity(), stockBuyRequest.getPrice());
        return ResponseEntity.ok(stockBuyRequest.getPrice() + "원에 " + stockBuyRequest.getQuantity() + "주 매수 주문");
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

    @GetMapping("/{code}/stability")
    public ResponseEntity<Mono<StockStabilityInfoDto>> getStockStability(@PathVariable String code) {
        log.info("주식 안정성 검색 {}", code);
        return ResponseEntity.ok(hanTuService.getStabilityInfo(code));
    }

    @GetMapping("/{code}/other")
    public ResponseEntity<Mono<StockOtherInfoDto>> getOtherInfo(@PathVariable String code) {
        log.info("종목 기타 정보 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getOtherInfo(code));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchStockDto>> searchStock(@RequestParam String keyword) {
        log.info("주식 검색 {}", keyword);
        return ResponseEntity.ok(stockMapper.selectfindStockByName(keyword));
    }


}
