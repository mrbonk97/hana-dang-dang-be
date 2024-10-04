package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DividendRecommendDto {
    String id;
    String title;
    String code;
    Integer month;
    String dividendType;
    LocalDate payDate;
    Long amount;
    Double percentage;
    Long sumAmount;
    Long sumPercentage;
}
