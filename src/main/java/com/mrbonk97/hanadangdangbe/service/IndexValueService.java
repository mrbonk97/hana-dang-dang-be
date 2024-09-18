package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.dto.SimpleIndexDto;
import com.mrbonk97.hanadangdangbe.model.IndexValue;
import com.mrbonk97.hanadangdangbe.repository.IndexValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexValueService {
    private final IndexValueRepository indexValueRepository;

    public void saveAll(String code, String fullCode, List<IndexValue> indexValues) {
        for (IndexValue indexValue : indexValues) {
            indexValue.setCode(code);
            indexValue.setFullCode(fullCode);
        }

        indexValueRepository.saveAll(indexValues);
    }



    public SimpleIndexDto findAllByCodeSimple (String code) {
        SimpleIndexDto simpleIndexDto = new SimpleIndexDto();
        List<IndexValue> indexValues = indexValueRepository.findAllByCodeAndStckBsopDateAfterOrderByStckBsopDate(code, "20240901");
        for (IndexValue indexValue : indexValues) {
            simpleIndexDto.getStckBsopDate().add(indexValue.getStckBsopDate());
            simpleIndexDto.getBstp_nmix_prpr().add(indexValue.getBstp_nmix_prpr());
        }

        return simpleIndexDto;
    }

    public List<IndexValue> findAllByCodeSimpleV2 (String code) {
        List<IndexValue> indexValues = indexValueRepository.findAllByCodeAndStckBsopDateAfterOrderByStckBsopDate(code, "20240901");
       return indexValues;
    }
}
