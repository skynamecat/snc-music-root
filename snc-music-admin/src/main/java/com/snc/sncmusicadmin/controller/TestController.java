package com.snc.sncmusicadmin.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snc.sncmusicadmin.domain.User;
import com.snc.sncmusicadmin.domain.vo.UserVo;
import com.snc.sncmusicadmin.service.UserService;
import io.github.linpeilie.Converter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能描述
 *
 * @author: skynamecat
 * @date: 2024/2/29 14:23
 */
@RestController
@RequestMapping("test")
@AllArgsConstructor
public class TestController {
    private UserService userService;
    private Converter converter;

    @GetMapping("list")
    public SaResult list(Page<User> page, String name) {
        IPage<User> result = userService.page(page, new LambdaQueryWrapper<User>());
        IPage<Object> data = result.convert(user -> converter.convert(user, UserVo.class).setRealName("***"));
        return SaResult.data(data);
    }
}
