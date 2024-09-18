package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo, String> {
    Optional<StockInfo> findByCode(String code);

}
