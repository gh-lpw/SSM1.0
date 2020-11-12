package com.lpw.service;

import java.util.Map;

/**
 * @author lipw4
 */
public interface UserService {

    /**
     * 查询用户信息
     * @param userName
     * @param password
     * @return
     */
    Map<String, Object> findUser(String userName, String password);
}
