package com.mrbonk97.hanadangdangbe.controller.response;

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
public class SimpleIndexResponse {
    private List<String> stckBsopDate = new ArrayList<>();
    private List<String> bstp_nmix_prpr = new ArrayList<>();
}
