package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockListDto {
    private int rn;
    private String prdtAbrvName;
    private String code;
    private String stdIdstClsfCdName;
    private String stckClpr;
    private String acmlVol;
    private String acmlTrPbmn;
    private String prdyVrss;
}
