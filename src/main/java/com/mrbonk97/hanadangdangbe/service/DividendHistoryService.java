package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.Dividend2023Dto;
import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DividendHistoryService {
    private final DividendHistoryRepository dividendHistoryRepository;

    public List<DividendHistory> findByCode(String code) {
        return dividendHistoryRepository.findAllByCodeOrderByLockDateDesc(code);
    }

    public Dividend2023Dto findByCode2023(String code) {
        Dividend2023Dto dto = new Dividend2023Dto();
        List<DividendHistory> list = dividendHistoryRepository.findAllByCodeAndLockDateBetweenOrderByLockDateDesc(code, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));;
        if(list.isEmpty()) return dto;

        dto.setYieldPercentage(list.getFirst().getYieldPercentage());
        for(var e: list) {
            if(e.getLockDate().getMonth() == Month.JANUARY) dto.getMonths()[0] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.FEBRUARY) dto.getMonths()[1] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.MARCH) dto.getMonths()[2] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.APRIL) dto.getMonths()[3] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.MAY) dto.getMonths()[4] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.JUNE) dto.getMonths()[5] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.JULY) dto.getMonths()[6] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.AUGUST) dto.getMonths()[7] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.SEPTEMBER) dto.getMonths()[8] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.OCTOBER) dto.getMonths()[9] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.NOVEMBER) dto.getMonths()[10] += e.getAmount();
            else if(e.getLockDate().getMonth() == Month.DECEMBER) dto.getMonths()[11] += e.getAmount();
        }

        return dto;
    }

}
