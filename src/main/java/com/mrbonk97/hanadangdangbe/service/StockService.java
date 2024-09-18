package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.StockPriceDto;
import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.repository.AccountRepository;
import com.mrbonk97.hanadangdangbe.repository.AccountStockRepository;
import com.mrbonk97.hanadangdangbe.repository.StockInfoRepository;
import com.mrbonk97.hanadangdangbe.repository.StockTransactionRepository;
import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final AccountRepository accountRepository;
    private final StockTransactionRepository stockTransactionRepository;
    private final StockInfoRepository stockInfoRepository;
    private final AccountStockRepository accountStockRepository;
    private final StockMapper stockMapper;


    @Transactional
    public void buyStock(String accountId, Long price, Long quantity, String stockCode) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("해당하는 계좌 없음"));

        Long totalPrice = price * quantity;
        if(account.getBalance() < totalPrice) throw new RuntimeException("잔고 부족");
        account.setBalance(account.getBalance() - totalPrice);

        StockInfo stockInfo = stockInfoRepository.findByCode(stockCode).orElseThrow(() -> new RuntimeException("해당하는 주식 없음"));

        StockTransaction stockTransaction = new StockTransaction();
        stockTransaction.setAccount(account);
        stockTransaction.setPrice(price);
        stockTransaction.setQuantity(quantity);
        stockTransaction.setStockInfo(stockInfo);
        stockTransactionRepository.save(stockTransaction);

        AccountStock accountStock = new AccountStock();
        accountStock.setAccount(account);
        accountStock.setQuantity(quantity);
        accountStock.setStockInfo(stockInfo);
        accountStockRepository.save(accountStock);

        accountRepository.save(account);
    }

    public List<StockPriceDto> getStockPriceList() {
        return stockMapper.selectStockPriceList();
    }


}
