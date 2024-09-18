package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceResponse {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private StockCurrentPrice output;
}
