package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, Long> {
    List<AccountStock> findAllByAccount(Account account);
    Optional<AccountStock> findByAccountAndStockInfo(Account account, StockInfo stockInfo);
}
