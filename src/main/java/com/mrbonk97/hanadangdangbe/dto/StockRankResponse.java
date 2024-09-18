package com.mrbonk97.hanadangdangbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockRankResponse {
    String rt_cd;
    String msg_cd;
    String msg1;
    List<StockRank> output = new ArrayList<>();
}
