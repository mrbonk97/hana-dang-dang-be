package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.*;
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


    // 거래량 순위
    public Mono<StockListRankDto> getStockListRankVol() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/volume-rank?FID_COND_MRKT_DIV_CODE=J&FID_COND_SCR_DIV_CODE=20171&FID_INPUT_ISCD=0001&FID_DIV_CLS_CODE=0&FID_BLNG_CLS_CODE=0&FID_TRGT_CLS_CODE=111111111&FID_TRGT_EXLS_CLS_CODE=0000000000&FID_INPUT_PRICE_1=&FID_INPUT_PRICE_2&FID_VOL_CNT&FID_INPUT_DATE_1";

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPST01710000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockListRankDto.class);
    }

    // 등락률 순위
    public Mono<StockListRankDto> getStockListRankRsfl() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/ranking/fluctuation?fid_rsfl_rate2&fid_cond_mrkt_div_code=J&fid_cond_scr_div_code=20170&fid_input_iscd=0001&fid_rank_sort_cls_code=0&fid_input_cnt_1=0&fid_prc_cls_code=0&fid_input_price_1&fid_input_price_2&fid_vol_cnt&fid_trgt_cls_code=0&fid_trgt_exls_cls_code=0&fid_div_cls_code=0&fid_rsfl_rate1";

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPST01700000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockListRankDto.class);
    }

    // 체결강도 순위
    public Mono<StockListRankDto> getStockListRankPower() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/ranking/volume-power?fid_trgt_exls_cls_code=0&fid_cond_mrkt_div_code=J&fid_cond_scr_div_code=20168&fid_input_iscd=0001&fid_div_cls_code=0&fid_input_price_1&fid_input_price_2&fid_vol_cnt&fid_trgt_cls_code";

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPST01680000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockListRankDto.class);
    }

    // 국내주식 공매도 상위종목[국내주식-133]
    public Mono<StockListRankDto> getStockListRankShort() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/ranking/short-sale?FID_APLY_RANG_VOL&FID_COND_MRKT_DIV_CODE=J&FID_COND_SCR_DIV_CODE=20482&FID_INPUT_ISCD=0001&FID_PERIOD_DIV_CODE=D&FID_INPUT_CNT_1=0&FID_TRGT_EXLS_CLS_CODE&FID_TRGT_CLS_CODE&FID_APLY_RANG_PRC_1&FID_APLY_RANG_PRC_2";

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHPST04820000")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockListRankDto.class);
    }

    // 주식현재가 시세[v1_국내주식-008]
    public Mono<StockPriceDto> getStockPrice(String code) {
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
                .bodyToMono(StockPriceDto.class);
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
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice?FID_COND_MRKT_DIV_CODE=U&FID_INPUT_DATE_1=" + _weekAgo + "&FID_INPUT_DATE_2=" + _today + "&FID_PERIOD_DIV_CODE=D&FID_INPUT_ISCD=" + code;
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

    // 주식현재가 일자별[v1_국내주식-010]
    public Mono<StockRecentPriceDto> getStockRecentPrice(String code) {
        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-price?FID_COND_MRKT_DIV_CODE=J&FID_PERIOD_DIV_CODE=D&FID_ORG_ADJ_PRC=0&FID_INPUT_ISCD=" + code;
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면, method()

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST01010400")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockRecentPriceDto.class);
    }

    // 국내주식업종기간별시세(일/주/월/년)[v1_국내주식-021]
    public Mono<IndexValueDto> getIndexGraphLong(String code) {
        // 현재 날짜 가져오기
        LocalDate today = LocalDate.now();
        // 일주일 전 날짜 계산
        LocalDate weekAgo = today.minusWeeks(200);

        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 포맷된 날짜 문자열 출력
        String _today = today.format(formatter);
        String _weekAgo = weekAgo.format(formatter);

        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-indexchartprice?FID_COND_MRKT_DIV_CODE=U&FID_INPUT_DATE_1=" + _weekAgo + "&FID_INPUT_DATE_2=" + _today + "&FID_PERIOD_DIV_CODE=D&FID_INPUT_ISCD=" + code;
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

    // 국내주식 종목투자의견 [국내주식-188]
    public Mono<StockOpinionDto> getStockOpinion(String code) {
        // 현재 날짜 가져오기
        LocalDate today = LocalDate.now();
        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 포맷된 날짜 문자열 출력
        String _today = today.format(formatter);

        // WebClient는 Builder 패턴 처럼 사용
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/invest-opinion?FID_COND_MRKT_DIV_CODE=J&FID_COND_SCR_DIV_CODE=16633&FID_INPUT_ISCD=" + code + "&FID_INPUT_DATE_1=20240101&FID_INPUT_DATE_2=" + _today;
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST663300C0")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockOpinionDto.class);
    }

    // 주식기본조회[v1_국내주식-067]
    public Mono<StockInfoDto> getStockInfo(String type, String code) {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443//uapi/domestic-stock/v1/quotations/search-stock-info?PRDT_TYPE_CD=" + type + "&PDNO=" + code;
        // 어떤 HTTP 메소드로 요청 보낼지를 get(), post() 메소드 등으로 결정

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "CTPF1002R")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockInfoDto.class);
    }

    // 주식기본조회[v1_국내주식-067]
    public Mono<StockHokaDto> getStockHoka(String code) {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-asking-price-exp-ccn?FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + code;

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST01010200")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockHokaDto.class);
    }

    //주식당일분봉조회[v1_국내주식-022]
    public Mono<StockMinuteDto> getStockMinuteData(String code, String time) {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-time-itemchartprice?FID_ETC_CLS_CODE&FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + code + "&FID_INPUT_HOUR_1=" + time + "&FID_PW_DATA_INCU_YN=Y";

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST03010200")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockMinuteDto.class);
    }

    //예탁원정보(배당일정)[국내주식-145]
    public Mono<DividendCalendarDto> getDividendCalendar(String code, String sTime, String eTime) {
        if (code == null) code = "";
        if (sTime == null) sTime = "";
        if (eTime == null) eTime = "";

        WebClient webClient = WebClient.builder().build();
        String url = String.format("https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/ksdinfo/dividend?CTS&GB1=0&F_DT=%s&T_DT=%s&SHT_CD=%s&HIGH_GB=", sTime, eTime, code);

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "HHKDB669102C0")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(DividendCalendarDto.class);
    }

    //예탁원정보(주주총회일정) [국내주식-154]
    public Mono<BoardMeetingDto> getBoardMeeting(String code) {
        if (code == null) code = "";
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/ksdinfo/sharehld-meet?CTS&F_DT=20200101&T_DT=20241231&SHT_CD=" + code;

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "HHKDB669111C0")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(BoardMeetingDto.class);
    }

    //예탁원정보(주주총회일정) [국내주식-154]
    public Mono<StockStabilityInfoDto> getStabilityInfo(String code) {
        WebClient webClient = WebClient.builder().build();
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/finance/stability-ratio?fid_div_cls_code=0&fid_cond_mrkt_div_code=J&fid_input_iscd=" + code;

        return webClient.get()
                .uri(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("content-type", "application/json; charset=utf-8")
                .header("appkey", APP_KEY)
                .header("appsecret", APP_SECRET)
                .header("tr_id", "FHKST66430600")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(StockStabilityInfoDto.class);
    }

}
