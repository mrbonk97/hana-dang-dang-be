package com.mrbonk97.hanadangdangbe.controller.request;

import com.mrbonk97.hanadangdangbe.model.IndexValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndexValueCreateRequest {
    private String code;
    private String fullCode;
    private List<IndexValue> data;
}



