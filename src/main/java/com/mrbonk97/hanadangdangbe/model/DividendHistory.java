package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Entity(name = "TB_DIVIDEND_HISTORY")
public class DividendHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recordDate;
    private String code;
    private String title;
    private String dividendKind;
    private String faceValue;
    private String perStockDividendAmount;
    private String dividendRate;
    private String stockDividendPayRate;
    private String dividendPayDate;
    private String oddPayDate;
    private String stockKind;
    private String highDividendGb;
}
