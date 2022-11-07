package org.lakers.mapstruct;

import org.lakers.common.UserVo;
import org.lakers.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Created on 2022/11/7 16:20
 *
 * @author lakers
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct {
    UserVo toUserVo(User user);

}
