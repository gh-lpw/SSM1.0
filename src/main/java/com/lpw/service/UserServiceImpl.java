package com.lpw.service;

import com.lpw.dao.UserMapper;
import com.lpw.entity.User;

import com.lpw.entity.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipw4
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> findUser(String userName, String password) {
        Map<String,Object> data = new HashMap<String,Object>();
        User user = userMapper.queryByName(userName);
        if (StringUtils.isEmpty(user)){
            data.put("code",Constant.LOGIN_NAME_ERROR_MESSAGE);
        }else {
            if(user.getPassword().equals(password)){
                data.put("code",Constant.LOGIN_OK);
                data.put("userName",user.getUserName());
                data.put("phone", user.getPhone());
                data.put("address", user.getAddress());
                return data;
            }else{
                data.put("code",Constant.LOGIN_PASSWORD_ERROR);
                return data;
            }
        }
        return data;
    }
}
