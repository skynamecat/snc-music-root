package com.snc.sncmusicadmin.conf;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* 功能描述
* [Sa-Token 权限认证] 全局配置类
* @author: skynamecat
* @date: 2024/2/29 14:02
*/
@Configuration
@Slf4j
public class SaTokenConfigure {
    /**
     * 注册 [Sa-Token全局过滤器] 
     */
    @Bean
    public SaServletFilter getSaReactorFilter() {
        return new SaServletFilter()
                // 指定 [拦截路由]
                .addInclude("/**")
                // 指定 [放行路由]
                .addExclude("/favicon.ico")
                // 指定[认证函数]: 每次请求执行 
                .setAuth(obj -> {
                    log.info("sa全局认证");
                    SaRouter.match("/test/**", StpUtil::checkLogin);
                })
                // 指定[异常处理函数]：每次[认证函数]发生异常时执行此函数 
                .setError(error -> {
                    log.error("sa全局异常");
                    return SaResult.error(error.getMessage());
                });
    }
}
