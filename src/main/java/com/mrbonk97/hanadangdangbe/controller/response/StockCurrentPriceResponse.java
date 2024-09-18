package com.mrbonk97.hanadangdangbe.controller.response;

import com.mrbonk97.hanadangdangbe.dto.StockPriceResponse;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockCurrentPriceResponse {
    private StockInfo stockInfo;
    private StockPriceResponse stockCurrentPrice;

    public static Mono<StockCurrentPriceResponse> from(StockInfo stockInfo, Mono<StockPriceResponse> stockPriceResponseMono) {
        return stockPriceResponseMono.map(stockPriceResponse -> {
            StockCurrentPriceResponse response = new StockCurrentPriceResponse();
            response.setStockInfo(stockInfo);
            response.setStockCurrentPrice(stockPriceResponse);
            return response;
        });
    }
}

