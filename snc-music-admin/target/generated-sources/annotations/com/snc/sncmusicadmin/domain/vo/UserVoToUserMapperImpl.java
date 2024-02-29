package com.snc.sncmusicadmin.domain.vo;

import com.snc.sncmusicadmin.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T16:13:08+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (GraalVM Community)"
)
@Component
public class UserVoToUserMapperImpl implements UserVoToUserMapper {

    @Override
    public User convert(UserVo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        User user = new User();

        user.setNickName( arg0.getNickName() );
        user.setRealName( arg0.getRealName() );
        user.setPhone( arg0.getPhone() );
        user.setEmail( arg0.getEmail() );
        user.setCreateBy( arg0.getCreateBy() );
        user.setCreateDateTime( arg0.getCreateDateTime() );

        return user;
    }

    @Override
    public User convert(UserVo source, User target) {
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
