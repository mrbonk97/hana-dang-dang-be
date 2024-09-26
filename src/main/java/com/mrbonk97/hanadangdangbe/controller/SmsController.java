package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.response.SmsRequest;
import com.mrbonk97.hanadangdangbe.controller.response.SmsVerifyResponse;
import com.mrbonk97.hanadangdangbe.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/verify")
    public ResponseEntity<SmsVerifyResponse> verify(@RequestBody SmsRequest smsRequest) {
        String code = smsService.send(smsRequest.getMobile_no());
        SmsVerifyResponse smsVerifyResponse = new SmsVerifyResponse(code);
        return ResponseEntity.ok(smsVerifyResponse);
    }
}
