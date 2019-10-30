package me.nnsty.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目的启动入口类
 * */
@Slf4j
@EnableAsync
@SpringBootApplication(scanBasePackages = {"me.nnsty"})
@EnableTransactionManagement
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        log.info("~~~~~~~~~~~~~API启动成功!~~~~~~~~~~~~~~~~~~");
    }

}
