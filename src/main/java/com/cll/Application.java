package com.cll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 启用定时任务、2h刷新一次token
public class Application {
	
    public static void main(String[] args) {
    	 SpringApplication.run(Application.class, args);
	}
    
  }