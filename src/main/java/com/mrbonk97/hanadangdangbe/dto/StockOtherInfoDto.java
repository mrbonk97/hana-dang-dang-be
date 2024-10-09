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
public class StockOtherInfoDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private List<Output> output = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output {
        private String stac_yymm;
        private String payout_rate;
        private String eva;
        private String ebitda;
        private String ev_ebitda;
    }
}
