//package com.mrbonk97.hanadangdangbe.service;
//
//import com.mrbonk97.hanadangdangbe.dto.CoverMonth;
//import com.mrbonk97.hanadangdangbe.dto.DividendRecommendDto;
//import com.mrbonk97.hanadangdangbe.dto.DividendRecommendResponseDto;
//import com.mrbonk97.hanadangdangbe.model.DividendHistory;
//import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
//import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class DividendHistoryService {
//    private final DividendHistoryRepository dividendHistoryRepository;
//    private final StockMapper stockMapper;
//    private final ConversionService conversionService;
//
//    public List<DividendHistory> findByCode(String code) {
//        return dividendHistoryRepository.findAllByCodeOrderByDeclareDateDesc(code);
//    }
//
////    public List<DividendRecommendResponseDto> getRecommendStock(long m1, long m2, long m3, long m4, long m5, long m6, long m7, long m8, long m9, long m10, long m11, long m12) {
////        List<DividendRecommendDto> dividendRecommendList = stockMapper.selectDividendRecommendList();
////        List<DividendRecommendResponseDto> responseList = new ArrayList<>();
////
////        String curCode = dividendRecommendList.getFirst().getCode();
////        DividendRecommendResponseDto dto = new DividendRecommendResponseDto();
////
////
////        for (var e : dividendRecommendList) {
////            int month = e.getMonth();
////
////            if (m1 <= 0 && month == 1) continue;
////            if (m2 <= 0 && month == 2) continue;
////            if (m3 <= 0 && month == 3) continue;
////            if (m4 <= 0 && month == 4) continue;
////            if (m5 <= 0 && month == 5) continue;
////            if (m6 <= 0 && month == 6) continue;
////            if (m7 <= 0 && month == 7) continue;
////            if (m8 <= 0 && month == 8) continue;
////            if (m9 <= 0 && month == 9) continue;
////            if (m10 <= 0 && month == 10) continue;
////            if (m11 <= 0 && month == 11) continue;
////            if (m12 <= 0 && month == 12) continue;
////
////            if (!e.getCode().equals(curCode)) {
////                responseList.add(dto);
////                dto = new DividendRecommendResponseDto();
////                curCode = e.getCode();
////            }
////
////            if (month == 1) {
////                long coverAmount = calculateQuantity(1, m1, e, dto);
////                m1 -= coverAmount;
////            }
////            if (month == 2) {
////                long coverAmount = calculateQuantity(2, m2, e, dto);
////                m2 -= coverAmount;
////            }
////            if (month == 3) {
////                long coverAmount = calculateQuantity(3, m3, e, dto);
////                m3 -= coverAmount;
////            }
////            if (month == 4) {
////                long coverAmount = calculateQuantity(4, m4, e, dto);
////                m4 -= coverAmount;
////            }
////            if (month == 5) {
////                long coverAmount = calculateQuantity(5, m5, e, dto);
////                m5 -= coverAmount;
////            }
////            if (month == 6) {
////                long coverAmount = calculateQuantity(6, m6, e, dto);
////                m6 -= coverAmount;
////            }
////            if (month == 7) {
////                long coverAmount = calculateQuantity(7, m7, e, dto);
////                m7 -= coverAmount;
////            }
////            if (month == 8) {
////                long coverAmount = calculateQuantity(8, m8, e, dto);
////                m8 -= coverAmount;
////            }
////            if (month == 9) {
////                long coverAmount = calculateQuantity(9, m9, e, dto);
////                m9 -= coverAmount;
////
////            }
////            if (month == 10) {
////                long coverAmount = calculateQuantity(10, m10, e, dto);
////                m10 -= coverAmount;
////            }
////            if (month == 11) {
////                long coverAmount = calculateQuantity(11, m11, e, dto);
////                m11 -= coverAmount;
////            }
////            if (month == 12) {
////                long coverAmount = calculateQuantity(12, m12, e, dto);
////                m12 -= coverAmount;
////            }
////        }
////
////        return responseList;
////    }
//
//    private long calculateQuantity(int month, long goalAmount, DividendRecommendDto dto, DividendRecommendResponseDto responseDto) {
//        if (responseDto.getQuantity() != 0) {
//            responseDto.getCoverMonth().add(new CoverMonth(month, dto.getAmount(), dto.getPercentage()));
//            return responseDto.getQuantity() * dto.getAmount();
//        }
//
//        long quantity = goalAmount / dto.getAmount();
//        if (goalAmount % dto.getAmount() != 0) quantity++;
//
//        responseDto.getCoverMonth().add(new CoverMonth(month, dto.getAmount(), dto.getPercentage()));
//        responseDto.setQuantity(quantity);
//        responseDto.setCode(dto.getCode());
//        responseDto.setTitle(dto.getTitle());
//        responseDto.setYearlyProfit(dto.getAmount() * responseDto.getQuantity());
//        responseDto.setYearlyProfitPercentage(dto.getSumPercentage());
//
//        return quantity * dto.getAmount();
//    }
//}
