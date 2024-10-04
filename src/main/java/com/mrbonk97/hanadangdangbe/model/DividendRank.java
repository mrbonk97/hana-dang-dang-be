package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_DIVIDEND_RANK")
public class DividendRank {
    @Id
    private Long id;
    private String title;
    private String code;
    private String StockType;
    private String market;
    private String dividend;
    private String yield;
    private String yield2;
    private String faceValue;
    private String stacMonth;
}
