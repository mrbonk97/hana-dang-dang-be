package com.mrbonk97.hanadangdangbe.controller.request;

import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
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
public class StockDailyPriceCreateRequest {
    private String code;
    private List<StockDailyPrice> stockDailyPrices = new ArrayList<>();
}
