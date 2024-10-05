//package com.mrbonk97.hanadangdangbe.controller;
//
//import com.mrbonk97.hanadangdangbe.controller.request.DividendRecommendRequest;
//import com.mrbonk97.hanadangdangbe.dto.BoardMeetingDto;
//import com.mrbonk97.hanadangdangbe.dto.DividendCalendarDto;
//import com.mrbonk97.hanadangdangbe.dto.DividendRecommendResponseDto;
//import com.mrbonk97.hanadangdangbe.dto.StockHokaDto;
//import com.mrbonk97.hanadangdangbe.model.DividendHistory;
//import com.mrbonk97.hanadangdangbe.model.DividendRank;
//import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
//import com.mrbonk97.hanadangdangbe.service.DividendHistoryService;
//import com.mrbonk97.hanadangdangbe.service.DividendRankService;
//import com.mrbonk97.hanadangdangbe.service.HanTuService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/dividend")
//public class DividendController {
//    private final DividendHistoryService dividendHistoryService;
//    private final DividendRankService dividendRankService;
//    private final HanTuService hanTuService;
//    private final DividendHistoryRepository dividendHistoryRepository;
//
//    @GetMapping("/stocks/{code}")
//    public ResponseEntity<List<DividendHistory>> getDividendHistory(@PathVariable String code) {
//        log.info("배당 기록 조회 {}", code);
//        return ResponseEntity.ok(dividendHistoryService.findByCode(code));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<DividendRank>> getDividendRank() {
//        log.info("배당 기록 조회");
//        return ResponseEntity.ok(dividendRankService.getDividendRank());
//    }
//
//    @GetMapping("/calendar/{date}")
//    public ResponseEntity<Mono<DividendCalendarDto>> getDividendCalendar(@PathVariable String date) {
//        log.info("배당 캘린더 조회 {}", date);
//        return ResponseEntity.ok(hanTuService.getDividendCalendar(null, date, date));
//    }
//
//    @GetMapping("/stocks/{code}/meeting")
//    public ResponseEntity<Mono<BoardMeetingDto>> getBoardMeeting(@PathVariable String code) {
//        log.info("주주총회 일정 조회 {}", code);
//        return ResponseEntity.ok(hanTuService.getBoardMeeting(code));
//    }
//
//    @PostMapping("/recommend")
//    public ResponseEntity<List<DividendRecommendResponseDto>> getRecommendStock(@RequestBody DividendRecommendRequest dividendRecommendRequest) {
//        log.info("배당주 추천해줌");
//        List<DividendRecommendResponseDto> response = dividendHistoryService.getRecommendStock(
//                dividendRecommendRequest.getM1(),
//                dividendRecommendRequest.getM2(),
//                dividendRecommendRequest.getM3(),
//                dividendRecommendRequest.getM4(),
//                dividendRecommendRequest.getM5(),
//                dividendRecommendRequest.getM6(),
//                dividendRecommendRequest.getM7(),
//                dividendRecommendRequest.getM8(),
//                dividendRecommendRequest.getM9(),
//                dividendRecommendRequest.getM10(),
//                dividendRecommendRequest.getM11(),
//                dividendRecommendRequest.getM12()
//        );
//
//        return ResponseEntity.ok(response);
//    }
//
//
//}
