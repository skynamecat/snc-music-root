package com.snc.sncmusicadmin.domain;

import com.snc.sncmusicadmin.domain.vo.UserVo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T16:13:08+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (GraalVM Community)"
)
@Component
public class UserToUserVoMapperImpl implements UserToUserVoMapper {

    @Override
    public UserVo convert(User arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setNickName( arg0.getNickName() );
        userVo.setRealName( arg0.getRealName() );
        userVo.setPhone( arg0.getPhone() );
        userVo.setEmail( arg0.getEmail() );
        userVo.setCreateBy( arg0.getCreateBy() );
        userVo.setCreateDateTime( arg0.getCreateDateTime() );

        return userVo;
    }

    @Override
    public UserVo convert(User source, UserVo target) {
        if ( source == null ) {
            return target;
        }

        target.setNickName( source.getNickName() );
        target.setRealName( source.getRealName() );
        target.setPhone( source.getPhone() );
        target.setEmail( source.getEmail() );
        target.setCreateBy( source.getCreateBy() );
        target.setCreateDateTime( source.getCreateDateTime() );

        return target;
    }
}
