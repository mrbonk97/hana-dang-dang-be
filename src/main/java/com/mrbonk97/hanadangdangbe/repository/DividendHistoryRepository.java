package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DividendHistoryRepository extends JpaRepository<DividendHistory, Long> {
    List<DividendHistory> findAllByCodeOrderByLockDateDesc(String code);
    List<DividendHistory> findAllByCodeAndPayDateAfterOrderByLockDateDesc(String code, LocalDate startDate);
}
