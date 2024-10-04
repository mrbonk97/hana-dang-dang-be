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
public class DividendCalendarDto {
    private String rt_cd;
    private String msg_cd;
    private String msg1;
    private List<Output1> output1;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Output1 {
        private String record_date;
        private String sht_cd;
        private String isin_name;
        private String divi_kind;
        private String face_val;
        private String per_sto_divi_amt;
        private String divi_rate;
        private String stk_divi_rate;
        private String divi_pay_dt;
        private String stk_div_pay_dt;
        private String odd_pay_dt;
        private String stk_kind;
        private String high_divi_gb;
    }


}
