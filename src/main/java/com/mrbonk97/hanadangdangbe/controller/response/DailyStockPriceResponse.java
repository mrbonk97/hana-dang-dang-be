package com.mrbonk97.hanadangdangbe.controller.response;

import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyStockPriceResponse {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DailyPrice {
        private LocalDate x;
        private Long [] y;
    }

    List<DailyPrice> daily_price = new ArrayList<>();

    public static DailyStockPriceResponse from(List<StockDailyPrice> stockDailyPrice) {
        DailyStockPriceResponse dailyStockPriceResponse = new DailyStockPriceResponse();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (StockDailyPrice e : stockDailyPrice) {
            DailyPrice dailyPrice = new DailyPrice();
            dailyPrice.setX(LocalDate.parse(e.getStckBsopDate(), formatter));
            dailyPrice.setY(new Long[]{
                    Long.valueOf(e.getStck_oprc()),
                    Long.valueOf(e.getStck_hgpr()),
                    Long.valueOf(e.getStck_lwpr()),
                    Long.valueOf(e.getStck_clpr())
            });
            dailyStockPriceResponse.getDaily_price().add(dailyPrice);
        }

        return dailyStockPriceResponse;

    }
}
