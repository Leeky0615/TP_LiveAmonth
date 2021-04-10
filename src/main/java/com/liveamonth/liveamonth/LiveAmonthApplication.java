package com.liveamonth.liveamonth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Mapper 인터페이스를 인식할 수 있도록 설정
public class LiveAmonthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveAmonthApplication.class, args);
    }
}
