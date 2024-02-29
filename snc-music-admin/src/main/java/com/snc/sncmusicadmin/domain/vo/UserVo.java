package com.snc.sncmusicadmin.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author skynamecat
 * @date 2024/2/29 15:50
 */
@Data
@Accessors(chain = true)
public class UserVo {
    private String nickName;
    private String realName;
    private String phone;
    private String email;
    private String createBy;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDateTime;
}
