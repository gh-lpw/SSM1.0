package com.lpw.controller;

import cn.hutool.core.date.DateTime;
import com.lpw.entity.Result;
import com.lpw.service.UserService;
import com.lpw.entity.Constant;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author lipw4
 */
@RestController
public class UserController {

    private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Result login(HttpServletRequest request, HttpServletResponse response){
        String userName ="";
        String password ="";
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            if ("userName".equals(paramName)) {
                userName = request.getParameter(paramName);
            }else if("password".equals(paramName)){
                password = request.getParameter(paramName);
            }
        }
        String requestId = RandomStringUtils.randomAlphanumeric(32);
        String currentTime = DateTime.now().toString();
        JSONObject json = new JSONObject();
        json.put("currentTime", currentTime);
        json.put("userName", userName);
        json.put("password", password);
        json.put("requestId", requestId);
        Logger.info("登陆请求入参"+json);
        try{
            //调用userService登录方法验证
            Map<String, Object> data = userService.findUser(userName, password);
            Result result=new Result();
            int res=(Integer)data.get("code");
            //成功返回的data数据集合
            //判断登录结果
            if(res== Constant.LOGIN_OK){
                result.setCode(Constant.LOGIN_OK);
                result.setMessage(Constant.LOGIN_OK_MESSAGE);
                result.setData(data);
            }
            else if(res==Constant.LOGIN_NAME_ERROR){
                result.setCode(Constant.LOGIN_NAME_ERROR);
                result.setMessage(Constant.LOGIN_NAME_ERROR_MESSAGE);
                result.setData("");
            }else if(res==Constant.LOGIN_PASSWORD_ERROR){
                result.setCode(Constant.LOGIN_PASSWORD_ERROR);
                result.setMessage(Constant.LOGIN_PASSWORD_ERROR_MESSAGE);
                result.setData("");
            }
            JSONObject rjson = new JSONObject();
            String returnTime =  DateTime.now().toString();
            rjson.put("requestId",requestId);
            rjson.put("returnTime", returnTime);
            rjson.put("result", result);
            Logger.info("登陆请求出参"+rjson);
            return result;

        }catch(Exception e){
            Result result=new Result();
            result.setCode(Constant.ERROR);
            result.setMessage(Constant.ERROR_MESSAGE);
            return result;
        }
    }
}
