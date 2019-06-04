package com.evilcry.shardingspheredemo;

import com.evilcry.shardingspheredemo.jpa.service.JPACommonService;
import com.evilcry.shardingspheredemo.jpa.service.JPACountryService;
import com.evilcry.shardingspheredemo.jpa.service.JPAUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// @MapperScan(basePackages = "com.evilcry.shardingspheredemo.mybatis.repository")
@ComponentScan("com.evilcry.shardingspheredemo.jpa")
@EntityScan(basePackages = "com.evilcry.shardingspheredemo.jpa.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class ShardingsphereDemoApplication {

    public static void main(final String[] args) {

        // mybatis
        // try (ConfigurableApplicationContext applicationContext = SpringApplication.run(ShardingsphereDemoApplication.class, args)) {
        //     // CommonService commonService = applicationContext.getBean(SpringPojoService.class);
        //     CommonService commonService = applicationContext.getBean(SpringCountryService.class);
        //     // CommonService commonService = applicationContext.getBean(UserService.class);
        //     commonService.initEnvironment();
        //     commonService.processSuccess();
        //     // commonService.cleanEnvironment();
        // }

        // jpa
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(ShardingsphereDemoApplication.class, args)) {
            JPACommonService commonService = applicationContext.getBean(JPACommonService.class);
            commonService.processSuccess();
            JPAUserService userService = applicationContext.getBean(JPAUserService.class);
            userService.processSuccess();
            JPACountryService countryService = applicationContext.getBean(JPACountryService.class);
            countryService.processSuccess();
        }
    }

}
