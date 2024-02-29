package com.snc.sncmusicadmin.domain;

import com.snc.sncmusicadmin.domain.vo.UserVo;
import io.github.linpeilie.AutoMapperConfig;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
    config = AutoMapperConfig.class,
    uses = {},
    imports = {}
)
public interface UserToUserVoMapper extends BaseMapper<User, UserVo> {
  UserVo convert(User source, @MappingTarget UserVo target);
}
