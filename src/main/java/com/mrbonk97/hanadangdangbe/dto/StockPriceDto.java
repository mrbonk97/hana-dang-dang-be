package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
    private String code;
    private String prdtAbrvName;
    private String idxBztpMclsCdName;
    private String stckClpr;
    private String prdyVrss;
    private String acmlVol;
    private String prdyVrssSign;
    private String prdyCtrt;
    private String prdyVrssVolRate;
}
