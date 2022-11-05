package org.lakers.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lakers.domain.User;

/**
 * Created on 2022/11/3 14:04
 * @author lakers
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
