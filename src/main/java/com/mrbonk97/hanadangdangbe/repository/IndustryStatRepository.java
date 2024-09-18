package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.IndustryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryStatRepository extends JpaRepository<IndustryStat, Long> {

    List<IndustryStat> findAllByStatDateOrderByPricePercentageDesc(String statDate);
}
