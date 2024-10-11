package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.DividendRecommendRequest;
import com.mrbonk97.hanadangdangbe.dto.*;
import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import com.mrbonk97.hanadangdangbe.model.DividendRank;
import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
import com.mrbonk97.hanadangdangbe.service.DividendHistoryService;
import com.mrbonk97.hanadangdangbe.service.DividendRankService;
import com.mrbonk97.hanadangdangbe.service.HanTuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dividend")
public class DividendController {
    private final DividendHistoryService dividendHistoryService;
    private final DividendRankService dividendRankService;
    private final HanTuService hanTuService;

    @GetMapping("/stocks/{code}")
    public ResponseEntity<List<DividendHistory>> getDividendHistory(@PathVariable String code) {
        log.info("배당 기록 조회 {}", code);
        return ResponseEntity.ok(dividendHistoryService.findByCode(code));
    }

    @GetMapping("/stocks-2023/{code}")
    public ResponseEntity<Dividend2023Dto> getDividendHistory2023(@PathVariable String code) {
        log.info("배당 기록 조회 2023년 {}", code);
        return ResponseEntity.ok(dividendHistoryService.findByCode2023(code));
    }

    @GetMapping
    public ResponseEntity<List<DividendRank>> getDividendRank() {
        log.info("배당 순위 조회");
        return ResponseEntity.ok(dividendRankService.getDividendRank());
    }

    @GetMapping("/calendar/{date}")
    public ResponseEntity<Mono<DividendCalendarDto>> getDividendCalendar(@PathVariable String date) {
        log.info("배당 캘린더 조회 {}", date);
        return ResponseEntity.ok(hanTuService.getDividendCalendar(null, date, date));
    }

    @GetMapping("/stocks/{code}/meeting")
    public ResponseEntity<Mono<BoardMeetingDto>> getBoardMeeting(@PathVariable String code) {
        log.info("주주총회 일정 조회 {}", code);
        return ResponseEntity.ok(hanTuService.getBoardMeeting(code));
    }
}
