package com.mrbonk97.hanadangdangbe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockBuyRequest {
    private String accountId;
    private String stockCode;
    private Long quantity;
    private Long price;
}
