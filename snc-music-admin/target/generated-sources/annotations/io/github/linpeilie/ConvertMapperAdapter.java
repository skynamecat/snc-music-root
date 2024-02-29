package io.github.linpeilie;

import com.snc.sncmusicadmin.domain.User;
import com.snc.sncmusicadmin.domain.UserToUserVoMapper;
import com.snc.sncmusicadmin.domain.vo.UserVo;
import com.snc.sncmusicadmin.domain.vo.UserVoToUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ConvertMapperAdapter {
  @Autowired
  @Lazy
  private UserVoToUserMapper userVoToUserMapper;

  @Autowired
  @Lazy
  private UserToUserVoMapper userToUserVoMapper;

  public User com_snc_sncmusicadmin_domain_vo_UserVoToUser(UserVo param) {
    return userVoToUserMapper.convert(param);}

  public UserVo com_snc_sncmusicadmin_domain_UserToUserVo(User param) {
    return userToUserVoMapper.convert(param);}
}
