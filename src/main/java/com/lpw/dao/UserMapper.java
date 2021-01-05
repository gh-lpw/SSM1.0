package com.lpw.dao;

import com.lpw.entity.User;

/**
 * @author lipw4
 */
public interface UserMapper {

    /**
     * 查询用户信息
     * @param userName
     * @return
     */
    User queryByName(String userName);


}
