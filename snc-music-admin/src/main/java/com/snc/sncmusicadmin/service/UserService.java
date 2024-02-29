package com.snc.sncmusicadmin.service;

import com.snc.sncmusicadmin.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author skyna
* @description 针对表【snc_music_user】的数据库操作Service
* @createDate 2024-02-29 14:51:56
*/
public interface UserService extends IService<User> {
    User doRegister(String username, String password);
    User doLogin(String username, String password);
}
