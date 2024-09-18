package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.StockTransaction;
import com.mrbonk97.hanadangdangbe.service.AccountService;
import com.mrbonk97.hanadangdangbe.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;
    private final StockTransactionService stockTransactionService;

    @GetMapping("/{id}/transaction")
    public ResponseEntity<List<StockTransaction>> getAccount(@PathVariable String id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(stockTransactionService.findRecentActivity(account));
    }

    @PutMapping("/{id}/fill")
    public ResponseEntity<Account> fillAccount(@PathVariable String id, @RequestBody Long amount) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(accountService.addToBalance(account, amount));
    }


}
