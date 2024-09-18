package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.repository.StockTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTransactionService {
    private final StockTransactionRepository stockTransactionRepository;

    public List<StockTransaction> findRecentActivity(Account account) {
        return stockTransactionRepository.findTop10ByAccountOrderByCreatedAtDesc(account);
    }
}
