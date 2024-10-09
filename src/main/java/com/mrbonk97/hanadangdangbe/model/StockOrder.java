package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "TB_STOCK_ORDER")
public class StockOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String code;
    private String OrderType;
    private Long orderPrice;
    private Long orderQuantity;
    private Long leftQuantity;
    private String isFinish;
}
