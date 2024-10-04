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
public class BoardMeetingDto {
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
        private String gen_meet_dt;
        private String gen_meet_type;
        private String agenda;
        private String vote_tot_qty;
    }
}
