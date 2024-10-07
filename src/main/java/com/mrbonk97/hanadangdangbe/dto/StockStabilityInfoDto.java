package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockStabilityInfoDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private Output[] output;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output {
        private String stac_yymm;
        private String lblt_rate;
        private String bram_depn;
        private String crnt_rate;
        private String quck_rate;
    }
}
