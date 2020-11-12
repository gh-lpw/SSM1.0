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
    User selectByUserName(String userName);

    /**
     * 通过主键查询用户信息
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

}
