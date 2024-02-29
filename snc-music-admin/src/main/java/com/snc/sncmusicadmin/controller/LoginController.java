package com.snc.sncmusicadmin.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.snc.sncmusicadmin.domain.User;
import com.snc.sncmusicadmin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: skynamecat
 * @date: 2024/2/29 14:23
 */
@RestController
@RequestMapping("acc")
@AllArgsConstructor
public class LoginController {
    private UserService userService;

    @RequestMapping("doRegister")
    public SaResult doRegister(String email, String password) {
        User user = userService.doRegister(email, password);
        StpUtil.login(user.getUserId());
        return SaResult.ok("注册成功");
    }

    @RequestMapping("doLogin")
    public SaResult doLogin(String email, String password,
                            @RequestParam(defaultValue = "false") Boolean logout,
                            @RequestParam(defaultValue = "false") Boolean info) {
        if (logout) {
            StpUtil.logout();
            return SaResult.ok("注销成功");
        }
        if (StpUtil.isLogin()) {
            return SaResult.error("已经登录");
        }
        User user = userService.doLogin(email, password);
        if (user == null) {
            return SaResult.error("登录失败");
        }
        StpUtil.login(user.getUserId());
        return SaResult.ok("登录成功").setData(info ? StpUtil.getTokenInfo() : null);
    }
}
