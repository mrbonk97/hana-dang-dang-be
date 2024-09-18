package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// 국내주식업종기간별시세(일/주/월/년)[v1_국내주식-021]
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndexValueDto {
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
        private String bstp_nmix_prdy_vrss;
        private String prdy_vrss_sign;
        private String bstp_nmix_prdy_ctrt;
        private String prdy_nmix;
        private String acml_vol;
        private String acml_tr_pbmn;
        private String hts_kor_isnm;
        private String bstp_nmix_prpr;
        private String bstp_cls_code;
        private String prdy_vol;
        private String bstp_nmix_oprc;
        private String bstp_nmix_hgpr;
        private String bstp_nmix_lwpr;
        private String futs_prdy_oprc;
        private String futs_prdy_hgpr;
        private String futs_prdy_lwpr;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output2 {
        private String stck_bsop_date;
        private String bstp_nmix_prpr;
        private String bstp_nmix_oprc;
        private String bstp_nmix_hgpr;
        private String bstp_nmix_lwpr;
        private String acml_vol;
        private String acml_tr_pbmn;
        private String mod_yn;
    }
}


