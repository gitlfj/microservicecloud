package com.lfj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//本服务启动后会自动注册进eureka服务中
@EnableEurekaClient
public class DeptProvider8003_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class, args);
    }

}
