package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.AccountStock;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.service.AccountService;
import com.mrbonk97.hanadangdangbe.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final StockTransactionService stockTransactionService;

    @GetMapping("/{id}/recent-activity")
    public ResponseEntity<List<StockTransaction>> getAccount(@PathVariable String id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(stockTransactionService.findRecentActivity(account));
    }

    @GetMapping("/{id}/fill")
    public ResponseEntity<Account> fillAccount(@PathVariable String id, @RequestParam Long amount) {
        return ResponseEntity.ok(accountService.addToBalance(id, amount));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountDetail(@PathVariable String id) {
        Account account = accountService.getAccountInfo(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}/stocks")
    public ResponseEntity<List<AccountStock>> getAccountStockList(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountStockByAccountId(id));
    }

}
