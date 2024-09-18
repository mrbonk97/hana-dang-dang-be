package com.mrbonk97.hanadangdangbe.repository.mybatis;

import com.mrbonk97.hanadangdangbe.dto.StockPriceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<StockPriceDto> selectStockPriceList();
}
