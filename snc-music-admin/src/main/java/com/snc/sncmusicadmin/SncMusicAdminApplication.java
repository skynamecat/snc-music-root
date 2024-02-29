package com.snc.sncmusicadmin;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* 功能描述
* 
* @author: skynamecat
* @date: 2024/2/29 13:43
*/
@SpringBootApplication
@MapperScan("com.snc.sncmusicadmin.mapper")
public class SncMusicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SncMusicAdminApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }

}
