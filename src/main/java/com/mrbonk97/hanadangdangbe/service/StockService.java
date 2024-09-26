package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.StockHokaDto;
import com.mrbonk97.hanadangdangbe.dto.StockPriceDto;
import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.StockInfo;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.repository.*;
import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final AccountRepository accountRepository;
    private final StockTransactionRepository stockTransactionRepository;
    private final StockInfoRepository stockInfoRepository;
    private final AccountStockRepository accountStockRepository;
    private final StockMapper stockMapper;
    private final StockDailyPriceRepository stockDailyPriceRepository;


    @Transactional
    public StockTransaction buyStock(String accountId, Long price, Long quantity, String stockCode) {
        Account account = accountRepository.findById(accountId.replaceAll("-", "")).orElseThrow(() -> new RuntimeException("해당하는 계좌 없음"));
        StockInfo stockInfo = stockInfoRepository.findByCode(stockCode).orElseThrow(() -> new RuntimeException("해당하는 주식 없음"));
        Optional<AccountStock> accountStock = accountStockRepository.findByAccountAndStockInfo(account, stockInfo);

        Long totalPrice = price * quantity;
        if (account.getBalance() < totalPrice) throw new RuntimeException("잔고 부족");
        account.setBalance(account.getBalance() - totalPrice);

        StockTransaction stockTransaction = new StockTransaction();
        stockTransaction.setAccount(account);
        stockTransaction.setPrice(price);
        stockTransaction.setQuantity(quantity);
        stockTransaction.setStockInfo(stockInfo);
        stockTransactionRepository.save(stockTransaction);

        if (accountStock.isPresent()) {
            Long curTotalPrice = accountStock.get().getTotalPrice();
            Long q = accountStock.get().getQuantity();

            accountStock.get().setQuantity(q + quantity);
            accountStock.get().setTotalPrice(totalPrice + curTotalPrice);
            accountStock.get().setPurchasePrice((curTotalPrice + totalPrice) / (q + quantity));
            accountStockRepository.save(accountStock.get());
        } else {
            AccountStock accountStock2 = new AccountStock();
            accountStock2.setAccount(account);
            accountStock2.setStockInfo(stockInfo);
            accountStock2.setQuantity(quantity);
            accountStock2.setPurchasePrice(price);
            accountStock2.setTotalPrice(quantity * price);
            accountStockRepository.save(accountStock2);
        }

        accountRepository.save(account);


        return stockTransaction;
    }

    public List<StockPriceDto> getStockPriceList() {
        return stockMapper.selectStockPriceList();
    }





}
