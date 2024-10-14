package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountStockDto {
    private String code;
    private String title;
    private Long quantity;
    private Long purchasePrice;
    private Long purchaseTotalPrice;
    private Long currentPrice;
    private Long currentTotalPrice;
    private Double profit;
    private Double profitPercentage;
}
