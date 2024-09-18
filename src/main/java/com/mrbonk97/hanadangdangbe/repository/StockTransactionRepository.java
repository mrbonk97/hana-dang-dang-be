package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findAllByAccountOrderByCreatedAtDesc(Account account);
    List<StockTransaction> findTop10ByAccountOrderByCreatedAtDesc(Account account);
}
