package com.snc.sncmusicadmin.domain.vo;

import com.snc.sncmusicadmin.domain.User;
import io.github.linpeilie.AutoMapperConfig;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
    config = AutoMapperConfig.class,
    uses = {},
    imports = {}
)
public interface UserVoToUserMapper extends BaseMapper<UserVo, User> {
  User convert(UserVo source, @MappingTarget User target);
}
