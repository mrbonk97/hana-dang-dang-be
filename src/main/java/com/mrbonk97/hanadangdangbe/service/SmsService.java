package com.mrbonk97.hanadangdangbe.service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmsService {

    @Value("${cool_sms.api_key}")
    private String API_KEY;
    @Value("${cool_sms.api_secret}")
    private String API_SECRET;


    public String send(String mobileNo) {
        mobileNo = mobileNo.replaceAll("-", "");
        mobileNo = mobileNo.strip();

        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < 6; i++ ){
            int n = random.nextInt(10);
            code.append(n);
        }

        DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET, "https://api.coolsms.co.kr");
        Message message = new Message();
        message.setFrom("01084333792");
        message.setTo(mobileNo);
        message.setText("[하나깔깔]인증번호 [" + code.toString() + "]을 화면에 입력해주세요.");

        try {
            // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
            messageService.send(message);
        } catch (NurigoMessageNotReceivedException exception) {
            // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return code.toString();
    }


}
