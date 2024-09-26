package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// 주식현재가 일자별[v1_국내주식-010]
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockRecentPriceDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private List<Output> output = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output {
        private String stck_bsop_date;
        private String stck_oprc;
        private String stck_hgpr;
        private String stck_lwpr;
        private String stck_clpr;
        private String acml_vol;
        private String prdy_vrss_vol_rate;
        private String prdy_vrss;
        private String prdy_vrss_sign;
        private String prdy_ctrt;
        private String hts_frgn_ehrt;
        private String frgn_ntby_qty;
        private String flng_cls_code;
        private String acml_prtt_rate;
    }

}


