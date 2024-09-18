package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.IndexValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexValueRepository extends JpaRepository<IndexValue, Long> {

    List<IndexValue> findAllByCodeAndStckBsopDateAfterOrderByStckBsopDate(String code, String date);
}
