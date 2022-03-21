package com.tik.mysystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableDubbo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan(value = "com.tik.mysystem")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
