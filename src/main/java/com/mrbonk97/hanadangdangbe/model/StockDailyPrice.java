package com.mrbonk97.hanadangdangbe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_STOCK_PRICE_DAILY")
public class StockDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String fid_cond_mkrt_div_code = "J";
    @Column(name = "stck_bsop_date")
    @JsonProperty("stck_bsop_date")
    private String stckBsopDate; // 주식 영업 일자
    private String stck_clpr; // 주식 종가
    private String stck_oprc; // 주식 시가
    private String stck_hgpr; // 주식 최고가
    private String stck_lwpr; // 주식 최저가
    private String acml_vol; // 누적 거래량
    private String acml_tr_pbmn; // 누적 거래 대금
    private String flng_cls_code; // 락 구분 코드
    private String prtt_rate; // 분할 비율
    private String mod_yn; // 분할변경여부
    private String prdy_vrss_sign; // 전일 대비 부호
    private String prdy_vrss; // 전일 대비
    private String revl_issu_reas; // 재평가사유코드
}