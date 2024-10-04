package com.mrbonk97.hanadangdangbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "TB_STOCK_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockInfo {
    @Id
    private String pdno;
    private String code;
    @JsonIgnore private String prdt_type_cd;
    @JsonIgnore private String mket_id_cd;
    @JsonIgnore private String scty_grp_id_cd;
    @JsonIgnore private String excg_dvsn_cd;
    @JsonIgnore private String setl_mmdd;
    @JsonIgnore private String lstg_stqt;
    @JsonIgnore private String lstg_cptl_amt;
    @JsonIgnore private String cpta;
    @JsonIgnore private String papr;
    @JsonIgnore private String issu_pric;
    @JsonIgnore private String kospi200_item_yn;
    @JsonIgnore private String scts_mket_lstg_dt;
    @JsonIgnore private String scts_mket_lstg_abol_dt;
    @JsonIgnore private String kosdaq_mket_lstg_dt;
    @JsonIgnore private String kosdaq_mket_lstg_abol_dt;
    @JsonIgnore private String frbd_mket_lstg_dt;
    @JsonIgnore private String frbd_mket_lstg_abol_dt;
    @JsonIgnore private String reits_kind_cd;
    @JsonIgnore private String etf_dvsn_cd;
    @JsonIgnore private String oilf_fund_yn;
    @JsonIgnore private String idx_bztp_lcls_cd;
    @JsonIgnore private String idx_bztp_mcls_cd;
    @JsonIgnore private String idx_bztp_scls_cd;
    @JsonIgnore private String stck_kind_cd;
    @JsonIgnore private String mfnd_opng_dt;
    @JsonIgnore private String mfnd_end_dt;
    @JsonIgnore private String dpsi_erlm_cncl_dt;
    @JsonIgnore private String etf_cu_qty;
    private String prdt_name;
    @JsonIgnore private String prdt_name120;
    private String prdt_abrv_name;
    @JsonIgnore private String std_pdno;
    @JsonIgnore private String prdt_eng_name;
    @JsonIgnore private String prdt_eng_name120;
    private String prdt_eng_abrv_name;
    @JsonIgnore private String dpsi_aptm_erlm_yn;
    @JsonIgnore private String etf_txtn_type_cd;
    @JsonIgnore private String etf_type_cd;
    @JsonIgnore private String lstg_abol_dt;
    @JsonIgnore private String nwst_odst_dvsn_cd;
    @JsonIgnore private String sbst_pric;
    @JsonIgnore private String thco_sbst_pric;
    @JsonIgnore private String thco_sbst_pric_chng_dt;
    @JsonIgnore private String tr_stop_yn;
    @JsonIgnore private String admn_item_yn;
    @JsonIgnore private String thdt_clpr; // 당일종가
    @JsonIgnore private String bfdy_clpr; // 전일종가
    @JsonIgnore private String clpr_chng_dt; // 종가변경일자
    private String std_idst_clsf_cd; // 표준산업분류코드
    private String std_idst_clsf_cd_name; // 표준산업분류코드명
    private String idx_bztp_lcls_cd_name; // 지수업종중분류코드명
    private String idx_bztp_mcls_cd_name; // 지수업종중분류코드명
    private String idx_bztp_scls_cd_name; // 지수업종소분류코드명

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockInfo stockInfo = (StockInfo) o;
        return Objects.equals(code, stockInfo.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
