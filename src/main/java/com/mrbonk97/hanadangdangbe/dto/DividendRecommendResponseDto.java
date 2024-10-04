package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DividendRecommendResponseDto {
    private String code;
    private String title;
    private long quantity = 0L;
    private long yearlyProfit = 0L;
    private double yearlyProfitPercentage = 0;
    private List<CoverMonth> coverMonth = new ArrayList<>();

}
