package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_INDEX_VALUE")
public class IndexValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String fullCode;
    private String stckBsopDate;
    private String acml_tr_pbmn;
    private String acml_vol;
    private String bstp_nmix_hgpr;
    private String bstp_nmix_lwpr;
    private String bstp_nmix_oprc;
    private String bstp_nmix_prpr;
    private String mod_yn;

}
