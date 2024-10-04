package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import com.mrbonk97.hanadangdangbe.model.DividendRank;
import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
import com.mrbonk97.hanadangdangbe.repository.DividendRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DividendRankService {
    private final DividendRankRepository dividendRankRepository;

    public List<DividendRank> getDividendRank() {
        return dividendRankRepository.findAllByOrderByIdAsc();
    }

}
