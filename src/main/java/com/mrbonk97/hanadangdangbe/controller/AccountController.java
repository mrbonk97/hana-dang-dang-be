package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.dto.AccountMonthlyProfitEstimateDto;
import com.mrbonk97.hanadangdangbe.dto.AccountProfitEstimateDto;
import com.mrbonk97.hanadangdangbe.dto.AccountStockDto;
import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.DividendHistory;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.repository.DividendHistoryRepository;
import com.mrbonk97.hanadangdangbe.repository.mybatis.StockMapper;
import com.mrbonk97.hanadangdangbe.service.AccountService;
import com.mrbonk97.hanadangdangbe.service.DividendHistoryService;
import com.mrbonk97.hanadangdangbe.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final StockTransactionService stockTransactionService;
    private final DividendHistoryService dividendHistoryService;
    private final StockMapper stockMapper;

    @GetMapping("/{id}/recent-activity")
    public ResponseEntity<List<StockTransaction>> getAccount(@PathVariable String id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(stockTransactionService.findRecentActivity(account));
    }

    @GetMapping("/{id}/fill")
    public ResponseEntity<Account> fillAccount(@PathVariable String id, @RequestParam Long amount) {
        log.info("계좌 금액 충전 {} {}원",id, amount);
        return ResponseEntity.ok(accountService.addToBalance(id, amount));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountDetail(@PathVariable String id) {
        Account account = accountService.getAccountInfo(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}/stocks")
    public ResponseEntity<List<AccountStockDto>> getAccountStockList(@PathVariable String id) {
        id = id.replaceAll("-","");
        log.info("계좌에 있는 종목 조회 {}", id);
        return ResponseEntity.ok(stockMapper.selectAccountStockList(id));
    }

    @GetMapping("/{id}/dividend")
    public ResponseEntity<List<StockTransaction>> findAllDividendHistoryByAccount(@PathVariable String id) {
        id = id.replaceAll("-","");
        log.info("배당 내역 조회 {}", id);
        return ResponseEntity.ok(stockTransactionService.findAllAccountDividendHistory(id));
    }

    @GetMapping("/{id}/dividend-estimate")
    public ResponseEntity<List<AccountProfitEstimateDto>> getAccountProfitEstimate(@PathVariable String id) {
        id = id.replaceAll("-","");
        log.info("배당 예상치 조회 {}", id);
        return ResponseEntity.ok(stockMapper.selectAccountProfitEstimate(id));
    }

    @GetMapping("/{id}/dividend-estimate-monthly")
    public ResponseEntity<List<AccountMonthlyProfitEstimateDto>> getAccountMonthlyProfitEstimate(@PathVariable String id) {
        id = id.replaceAll("-","");
        log.info("월병 예상 배당 조회 {}", id);
        return ResponseEntity.ok(stockMapper.selectAccountMonthlyProfitEstimate(id));
    }

}
