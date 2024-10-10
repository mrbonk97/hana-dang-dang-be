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
    long id;
    long amount;
    String code;
    Integer dividendType;
    LocalDate lockDate;
    LocalDate payDate;
    String title;
    int month;
    Double yieldPercentage;
    Double maxYield;
    Long sumAmount;
}
