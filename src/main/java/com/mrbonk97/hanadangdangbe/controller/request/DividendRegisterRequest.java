package com.mrbonk97.hanadangdangbe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DividendRegisterRequest {
    private Long dividendGoal;
    private String dividendRiskType;
    private String dividendPreference;
    private String dividendArea;
}
