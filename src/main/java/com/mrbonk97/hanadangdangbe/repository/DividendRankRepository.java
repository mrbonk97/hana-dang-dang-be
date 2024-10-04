package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.DividendRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DividendRankRepository extends JpaRepository<DividendRank, Long> {
    List<DividendRank> findAllByOrderByIdAsc();
}
