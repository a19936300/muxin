package com.imooc.muxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.imooc","org.n3r.idworker"})
@MapperScan(basePackages = {"com.imooc.muxin.dao"})
public class MuxinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuxinApplication.class, args);
    }

}
