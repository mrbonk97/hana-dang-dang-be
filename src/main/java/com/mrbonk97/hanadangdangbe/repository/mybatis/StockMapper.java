package com.mrbonk97.hanadangdangbe.repository.mybatis;

import com.mrbonk97.hanadangdangbe.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockMapper {
    List<StockPriceDto> selectStockPriceList();
    List<AccountStockDto> selectAccountStockList(@Param("accountNo") String accountNo);
    List<AccountProfitEstimateDto> selectAccountProfitEstimate(@Param("accountNo") String accountNo);
    List<AccountMonthlyProfitEstimateDto> selectAccountMonthlyProfitEstimate(@Param("accountNo") String accountNo);
    List<DividendRecommendDto> selectDividendRecommendList();
    List<SearchStockDto> selectfindStockByName(@Param("keyword") String keyword);
    List<StockListDto> selectfindStockListPage(@Param("page") int page);
}
