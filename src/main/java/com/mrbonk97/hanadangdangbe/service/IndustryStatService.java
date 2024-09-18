package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.IndustryStat;
import com.mrbonk97.hanadangdangbe.repository.IndustryStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustryStatService {
    private final IndustryStatRepository industryStatRepository;

    public List<IndustryStat> findAllByDate(String date) {
        return industryStatRepository.findAllByStatDateOrderByPricePercentageDesc(date);
    }
}
