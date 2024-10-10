package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_DIVIDEND_LOCK")
public class DividendLock {
    @Id
    @GeneratedValue
    Long id;
    String accountId;
    String stockCode;
    long quantity;
    long amount;
    Boolean payYn;
    LocalDate payDate;
}
