package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockRank {
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
}
