package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.CoverMonth;
import com.mrbonk97.hanadangdangbe.dto.DividendRecommendDto;
import com.mrbonk97.hanadangdangbe.dto.DividendRecommendResponseDto;
import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DividendHistoryService {
    private final DividendHistoryRepository dividendHistoryRepository;
    private final StockMapper stockMapper;
    private final ConversionService conversionService;

    public List<DividendHistory> findByCode(String code) {
        return dividendHistoryRepository.findAllByCodeOrderByLockDateDesc(code);
    }

    public List<DividendRecommendResponseDto> getRecommendStock(long m1, long m2, long m3, long m4, long m5, long m6, long m7, long m8, long m9, long m10, long m11, long m12) {
        long[] leftDividend = new long[]{m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12};

        List<DividendRecommendDto> list = stockMapper.selectDividendRecommendList();
        List<DividendRecommendResponseDto> response = new ArrayList<>();
        DividendRecommendResponseDto dto = new DividendRecommendResponseDto();


        for (var e : list) {
            if (leftDividend[e.getMonth() - 1] < 0) continue;

            dto.setTitle(e.getTitle());
            dto.setCode(e.getCode());
            long quantity = leftDividend[e.getMonth() - 1] / e.getAmount() + 1;
            dto.setQuantity(Math.max(dto.getQuantity(), quantity));
            dto.setYearlyProfit(e.getSumAmount());
                dto.getCoverMonth().add(new CoverMonth(e.getMonth(), e.getAmount() * quantity));
        }


    }


}
