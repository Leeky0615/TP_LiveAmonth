package com.liveamonth.liveamonth;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Mapper 인터페이스를 인식할 수 있도록 설정
public class LiveAmonthApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveAmonthApplication.class, args);
	}
}
