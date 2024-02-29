package com.snc.sncmusicadmin.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snc.sncmusicadmin.domain.User;
import com.snc.sncmusicadmin.service.UserService;
import com.snc.sncmusicadmin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
* @author skyna
* @description 针对表【snc_music_user】的数据库操作Service实现
* @createDate 2024-02-29 14:40:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Value("${snc-music.salt}")
    private String salt;

    @Override
    public User doRegister(String email, String password) {
        User user = new User()
                .setUserId(UUID.fastUUID().toString(true))
                .setEmail(email)
                .setPwd(SaSecureUtil.md5BySalt(password, salt))
                .setCreateDateTime(DateUtil.date());
        this.save(user);
        return user;
    }

    @Override
    public User doLogin(String username, String password) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.and(lq -> lq.eq(User::getPhone, username).or().eq(User::getEmail, username));
        User user = this.getOne(lqw);
        if (user == null) {
            return null;
        }
        if (!StrUtil.equals(user.getPwd(), SaSecureUtil.md5BySalt(password,salt))){
            return null;
        }
        return user;
    }
}




