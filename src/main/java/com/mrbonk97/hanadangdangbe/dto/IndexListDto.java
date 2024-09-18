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
public class IndexListDto {
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
        private String bstp_nmix_prpr;
        private String bstp_nmix_prdy_vrss;
        private String prdy_vrss_sign;
        private String bstp_nmix_prdy_ctrt;
        private String acml_vol;
        private String acml_tr_pbmn;
        private String bstp_nmix_oprc;
        private String bstp_nmix_hgpr;
        private String bstp_nmix_lwpr;
        private String prdy_vol;
        private String ascn_issu_cnt;
        private String down_issu_cnt;
        private String stnr_issu_cnt;
        private String uplm_issu_cnt;
        private String lslm_issu_cnt;
        private String prdy_tr_pbmn;
        private String dryy_bstp_nmix_hgpr_date;
        private String dryy_bstp_nmix_hgpr;
        private String dryy_bstp_nmix_lwpr;
        private String dryy_bstp_nmix_lwpr_date;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output2 {
        private String bstp_cls_code;
        private String hts_kor_isnm;
        private String bstp_nmix_prpr;
        private String bstp_nmix_prdy_vrss;
        private String prdy_vrss_sign;
        private String bstp_nmix_prdy_ctrt;
        private String acml_vol;
        private String acml_tr_pbmn;
    }
}

