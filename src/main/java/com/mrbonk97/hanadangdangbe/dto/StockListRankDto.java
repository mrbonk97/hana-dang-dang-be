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
public class StockListRankDto {
    String rt_cd;
    String msg_cd;
    String msg1;
    List<Output> output = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output {
        private String hts_kor_isnm;
        private String mksc_shrn_iscd;
        private String data_rank;
        private String stck_prpr;
        private String prdy_vrss_sign;
        private String prdy_vrss;
        private String prdy_ctrt;
        private String acml_vol;
        private String prdy_vol;
        private String lstn_stcn;
        private String avrg_vol;
        private String n_befr_clpr_vrss_prpr_rate;
        private String vol_inrt;
        private String vol_tnrt;
        private String nday_vol_tnrt;
        private String avrg_tr_pbmn;
        private String tr_pbmn_tnrt;
        private String nday_tr_pbmn_tnrt;
        private String acml_tr_pbmn;

        // 등락률
        private String stck_shrn_iscd;
//        private String data_rank;
//        private String hts_kor_isnm;
//        private String stck_prpr;
//        private String prdy_vrss;
//        private String prdy_vrss_sign;
//        private String prdy_ctrt;
//        private String acml_vol;
        private String stck_hgpr;
        private String hgpr_hour;
        private String acml_hgpr_date;
        private String stck_lwpr;
        private String lwpr_hour;
        private String acml_lwpr_date;
        private String lwpr_vrss_prpr_rate;
        private String dsgt_date_clpr_vrss_prpr_rate;
        private String cnnt_ascn_dynu;
        private String hgpr_vrss_prpr_rate;
        private String cnnt_down_dynu;
        private String oprc_vrss_prpr_sign;
        private String oprc_vrss_prpr;
        private String oprc_vrss_prpr_rate;
        private String prd_rsfl;
        private String prd_rsfl_rate;

        // 체결강도
//        private String stck_shrn_iscd;
//        private String data_rank;
//        private String hts_kor_isnm;
//        private String stck_prpr;
//        private String prdy_vrss;
//        private String prdy_vrss_sign;
//        private String prdy_ctrt;
//        private String acml_vol;
        private String tday_rltv;
        private String seln_cnqn_smtn;
        private String shnu_cnqn_smtn;


        // 공매도 순위
//        private String mksc_shrn_iscd;
//        private String hts_kor_isnm;
//        private String stck_prpr;
//        private String prdy_vrss;
//        private String prdy_vrss_sign;
//        private String prdy_ctrt;
//        private String acml_vol;
//        private String acml_tr_pbmn;
        private String ssts_cntg_qty;
        private String ssts_vol_rlim;
        private String ssts_tr_pbmn;
        private String ssts_tr_pbmn_rlim;
        private String stnd_date1;
        private String stnd_date2;
        private String avrg_prc;
    }
}
