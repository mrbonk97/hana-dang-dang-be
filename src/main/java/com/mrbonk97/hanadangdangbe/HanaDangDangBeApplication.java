package com.mrbonk97.hanadangdangbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HanaDangDangBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HanaDangDangBeApplication.class, args);
    }

}
