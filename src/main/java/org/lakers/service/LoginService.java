package org.lakers.service;

import org.lakers.domain.ResponseResult;
import org.lakers.domain.User;

import java.util.Map;

/**
 * Created on 2022/11/3 15:48
 *
 * @author lakers
 */
public interface LoginService {
    ResponseResult<Map<String, String>> login(User user);

    ResponseResult<Void> logout();
}
