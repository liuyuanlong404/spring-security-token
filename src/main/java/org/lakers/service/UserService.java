package org.lakers.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lakers.common.UserVo;
import org.lakers.domain.User;

/**
 * Created on 2022/11/3 14:19
 *
 * @author lakers
 */
public interface UserService extends IService<User> {

    UserVo getUserVo();
}
