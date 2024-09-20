package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.IndexListDto;
import com.mrbonk97.hanadangdangbe.dto.IndexValueDto;
import com.mrbonk97.hanadangdangbe.dto.StockPriceResponse;
import com.mrbonk97.hanadangdangbe.dto.StockRankResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class HanTuService {
    @Value("${koreainvest.appkey}")
    private String APP_KEY;
    @Value("${koreainvest.appsecret}")
    private String APP_SECRET;
    @Value("${koreainvest.access_token}")
    private String ACCESS_TOKEN;


    public Mono<StockRankResponse> getRankAsync() {

        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/volume-rank?FID_COND_MRKT_DIV_CODE=J&FID_COND_SCR_DIV_CODE=20171&FID_INPUT_ISCD=0000&FID_DIV_CLS_CODE=0&FID_BLNG_CLS_CODE=0&FID_TRGT_CLS_CODE=111111111&FID_TRGT_EXLS_CLS_CODE=0000000000&FID_INPUT_PRICE_1=&FID_INPUT_PRICE_2&FID_VOL_CNT&FID_INPUT_DATE_1";
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPST01710000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockRankResponse.class);
    }

    public Mono<StockPriceResponse> getStockPrice(String code) {
        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price?FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + code;
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST01010100")
                .retrieve()
                .bodyToMono(StockPriceResponse.class);
    }

    // 국내업종 구분별전체시세[v1_국내주식-066]
    public Mono<IndexListDto> getIndexList() {
        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-index-category-price?FID_COND_MRKT_DIV_CODE=U&FID_INPUT_ISCD=0001&FID_COND_SCR_DIV_CODE=20214&FID_MRKT_CLS_CODE=Q&FID_BLNG_CLS_CODE=0";
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPUP02140000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(IndexListDto.class);
    }

    // 국내주식업종기간별시세(일/주/월/년)[v1_국내주식-021]
    public Mono<IndexValueDto> getIndexGraph(String code) {
        // 현재 날짜 가져오기
        LocalDate today = LocalDate.now();
        // 일주일 전 날짜 계산
        LocalDate weekAgo = today.minusWeeks(2);

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 포맷된 날짜 문자열 출력
        String _today = today.format(formatter);
        String _weekAgo = weekAgo.format(formatter);

        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice?FID_COND_MRKT_DIV_CODE=U&FID_INPUT_DATE_1="+ _weekAgo + "&FID_INPUT_DATE_2=" + _today + "&FID_PERIOD_DIV_CODE=D&FID_INPUT_ISCD=" + code;
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKUP03500100")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(IndexValueDto.class);
    }

}
