package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.dto.StockRankResponse;
import com.mrbonk97.hanadangdangbe.service.HanTuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/han-tu")
public class HanTuController {
    private final HanTuService hanTuService;

    @GetMapping("/rank")
    public ResponseEntity<Mono<StockRankResponse>> getStockRank() {
        log.info("거래량 순위 조회");
        return ResponseEntity.ok(hanTuService.getRankAsync());
    }


}
