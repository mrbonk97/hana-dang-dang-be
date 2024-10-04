package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountProfitEstimateDto {
    Long id;
    String code;
    String title;
    Long quantity;
    Long purchasePrice;
    Long totalPrice;
    Long estimateProfit;
    Long amount;
    Double percentage;
}
