package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockMinuteDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private Output1 output1;
    private List<Output2> output2;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output1 {
        private String prdy_vrss;
        private String prdy_vrss_sign;
        private String prdy_ctrt;
        private String stck_prdy_clpr;
        private String acml_vol;
        private String acml_tr_pbmn;
        private String hts_kor_isnm;
        private String stck_prpr;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output2 {
        private String stck_bsop_date;
        private String stck_cntg_hour;
        private String stck_prpr;
        private String stck_oprc;
        private String stck_hgpr;
        private String stck_lwpr;
        private String cntg_vol;
        private String acml_tr_pbmn;

    }
}
