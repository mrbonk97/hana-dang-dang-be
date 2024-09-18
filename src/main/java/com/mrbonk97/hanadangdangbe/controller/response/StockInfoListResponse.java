package com.mrbonk97.hanadangdangbe.controller.response;

import com.mrbonk97.hanadangdangbe.model.StockInfo;
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
public class StockInfoListResponse {

    @Getter
    @Setter
    private static class SimpleStockInfo {
        String code;
        String prdt_abrv_name;
    }

    List<SimpleStockInfo> simpleStockInfos;

    public static StockInfoListResponse from(List<StockInfo> stockInfos) {
        List<SimpleStockInfo> simpleStockInfos = new ArrayList<>();

        for (StockInfo e : stockInfos) {
            SimpleStockInfo simpleStockInfo = new SimpleStockInfo();
            simpleStockInfo.code = e.getCode();
            simpleStockInfo.prdt_abrv_name = e.getPrdt_abrv_name();
            simpleStockInfos.add(simpleStockInfo);
        }

        return new StockInfoListResponse(simpleStockInfos);


    }

}
