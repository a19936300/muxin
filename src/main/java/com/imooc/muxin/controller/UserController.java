package com.imooc.muxin.controller;

import com.imooc.muxin.common.utils.IMoocJSONResult;
import com.imooc.muxin.common.utils.MD5Utils;
import com.imooc.muxin.pojo.Users;
import com.imooc.muxin.pojo.vo.UsersVo;
import com.imooc.muxin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author : binbin
 * @description : ToDo
 * @date : 2019/11/17
 **/
@RestController
@RequestMapping("u")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registOrLogin")
    public IMoocJSONResult registOrLogin(@RequestBody Users users) throws Exception {

        //0.判断用户名和密码不能为空
        if(StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())){
            return IMoocJSONResult.errorMsg("用户名或密码不能为空...");
        }

        //1.判断用户名是否存在，如果存在就登录，如果不存在则注册
        boolean usernameIsExist = userService.queryUsernameIsExist(users.getUsername());
        Users userResult = null;
        if(usernameIsExist){
            //1.1 登录
            userResult = userService.queryUserForLogin(users.getUsername(), MD5Utils.getMD5Str(users.getPassword()));
            if (userResult == null) {
                return IMoocJSONResult.errorMsg("用户名或密码不正确...");
            }

        }else{
            //1.2
            users.setNickname(users.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            userService.saveUsers(users);
        }

        UsersVo result = new UsersVo();
        BeanUtils.copyProperties(users,result);

        return  IMoocJSONResult.ok(result);
    }
}
