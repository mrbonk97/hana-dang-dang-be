package com.mrbonk97.hanadangdangbe.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "TB_INDUSTRY_STAT")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IndustryStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String industryName;
    private String statDate;
    private String todayPrice;
    private String yesterdayPrice;
    private String priceDiff;
    private String pricePercentage;
}
