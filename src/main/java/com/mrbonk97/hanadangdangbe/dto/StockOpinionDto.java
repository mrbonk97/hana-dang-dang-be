package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// 국내주식업종기간별시세(일/주/월/년)[v1_국내주식-021]
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockOpinionDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private List<Output1> output = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output1 {
        private String stck_bsop_date;
        private String invt_opnn;
        private String invt_opnn_cls_code;
        private String rgbf_invt_opnn;
        private String rgbf_invt_opnn_cls_code;
        private String mbcr_name;
        private String hts_goal_prc;
        private String stck_prdy_clpr;
        private String stck_nday_esdg;
        private String nday_dprt;
        private String stft_esdg;
        private String dprt;
    }

}


