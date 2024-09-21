package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.IndexValueCreateRequest;
import com.mrbonk97.hanadangdangbe.dto.IndexListDto;
import com.mrbonk97.hanadangdangbe.dto.IndexValueDto;
import com.mrbonk97.hanadangdangbe.model.IndexValue;
import com.mrbonk97.hanadangdangbe.service.HanTuService;
import com.mrbonk97.hanadangdangbe.service.IndexValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/indexes")
public class IndexController {
    private final IndexValueService indexValueService;
    private final HanTuService hanTuService;

    @PostMapping("/batch")
    public void saveAllIndexes(@RequestBody IndexValueCreateRequest indexValueCreateRequest) {
        indexValueService.saveAll(indexValueCreateRequest.getCode(), indexValueCreateRequest.getFullCode(), indexValueCreateRequest.getData());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Mono<IndexValueDto>> getIndexByCodeSimple(@PathVariable String code) {
        log.info("지수 조회함 {}",code);
        return ResponseEntity.ok(hanTuService.getIndexGraph(code));
    }

    @GetMapping("/long/{code}")
    public ResponseEntity<Mono<IndexValueDto>> getIndexByCode(@PathVariable String code) {
        log.info("지수 조회함 {}",code);
        return ResponseEntity.ok(hanTuService.getIndexGraphLong(code));
    }

    @GetMapping
    public ResponseEntity<Mono<IndexListDto>> getIndexList() {
        return ResponseEntity.ok(hanTuService.getIndexList());
    }


}