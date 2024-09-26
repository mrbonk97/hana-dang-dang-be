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
public class StockHokaDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private Output1 output1;
    private Output2 output2;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output1 {
        private String aspr_acpt_hour;
        private String askp1;
        private String askp2;
        private String askp3;
        private String askp4;
        private String askp5;
        private String askp6;
        private String askp7;
        private String askp8;
        private String askp9;
        private String askp10;
        private String bidp1;
        private String bidp2;
        private String bidp3;
        private String bidp4;
        private String bidp5;
        private String bidp6;
        private String bidp7;
        private String bidp8;
        private String bidp9;
        private String bidp10;
        private String askp_rsqn1;
        private String askp_rsqn2;
        private String askp_rsqn3;
        private String askp_rsqn4;
        private String askp_rsqn5;
        private String askp_rsqn6;
        private String askp_rsqn7;
        private String askp_rsqn8;
        private String askp_rsqn9;
        private String askp_rsqn10;
        private String bidp_rsqn1;
        private String bidp_rsqn2;
        private String bidp_rsqn3;
        private String bidp_rsqn4;
        private String bidp_rsqn5;
        private String bidp_rsqn6;
        private String bidp_rsqn7;
        private String bidp_rsqn8;
        private String bidp_rsqn9;
        private String bidp_rsqn10;
        private String askp_rsqn_icdc1;
        private String askp_rsqn_icdc2;
        private String askp_rsqn_icdc3;
        private String askp_rsqn_icdc4;
        private String askp_rsqn_icdc5;
        private String askp_rsqn_icdc6;
        private String askp_rsqn_icdc7;
        private String askp_rsqn_icdc8;
        private String askp_rsqn_icdc9;
        private String askp_rsqn_icdc10;
        private String bidp_rsqn_icdc1;
        private String bidp_rsqn_icdc2;
        private String bidp_rsqn_icdc3;
        private String bidp_rsqn_icdc4;
        private String bidp_rsqn_icdc5;
        private String bidp_rsqn_icdc6;
        private String bidp_rsqn_icdc7;
        private String bidp_rsqn_icdc8;
        private String bidp_rsqn_icdc9;
        private String bidp_rsqn_icdc10;
        private String total_askp_rsqn;
        private String total_bidp_rsqn;
        private String total_askp_rsqn_icdc;
        private String total_bidp_rsqn_icdc;
        private String ovtm_total_askp_icdc;
        private String ovtm_total_bidp_icdc;
        private String ovtm_total_askp_rsqn;
        private String ovtm_total_bidp_rsqn;
        private String ntby_aspr_rsqn;
        private String new_mkop_cls_code;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output2 {
        private String antc_mkop_cls_code;
        private String stck_prpr;
        private String stck_oprc;
        private String stck_hgpr;
        private String stck_lwpr;
        private String stck_sdpr;
        private String antc_cnpr;
        private String antc_cntg_vrss_sign;
        private String antc_cntg_vrss;
        private String antc_cntg_prdy_ctrt;
        private String antc_vol;
        private String stck_shrn_iscd;
        private String vi_cls_code;
    }
}
