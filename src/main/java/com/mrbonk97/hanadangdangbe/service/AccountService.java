package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.StockDailyPrice;
import com.mrbonk97.hanadangdangbe.model.User;
import com.mrbonk97.hanadangdangbe.repository.AccountRepository;
import com.mrbonk97.hanadangdangbe.repository.AccountStockRepository;
import com.mrbonk97.hanadangdangbe.repository.StockDailyPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountStockRepository accountStockRepository;
    private final StockDailyPriceRepository stockDailyPriceRepository;

    public Account createAccount(User user) {
        Account account = new Account();
        account.setUser(user);
        account.setTitle("주식거래계좌");

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 10; i++) {
            sb.append(random.nextInt(9) + 1);
        }

        account.setAccountNo(sb.toString());

        return accountRepository.save(account);
    }

    public Account getAccountByUser(User user) {
        return accountRepository.findByUser(user).orElseThrow(() -> new RuntimeException("유저에게 할당된 계좌가 없습니다."));
    }

    public Account getAccountInfo(User user) {
        long stockBalance = 0;
        Account account = getAccountByUser(user);
        List<AccountStock> accountStockList = accountStockRepository.findAllByAccount(account);

        for(var e: accountStockList) {
            StockDailyPrice stockDailyPrice = stockDailyPriceRepository.findTopByCodeOrderByStckBsopDateDesc(e.getStockInfo().getCode()).orElseThrow(() -> new RuntimeException("종목을 찾을 수 없음"));
            stockBalance += Long.parseLong(stockDailyPrice.getStck_clpr()) * e.getQuantity();
        }


        return account;
    }

    public Account findById(String id) {
        id = id.replaceAll("-", "");
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 계좌를 찾을 수 없음"));
    }

    public Account addToBalance(Account account, Long amount) {
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
}
