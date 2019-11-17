package com.imooc.muxin.impl;

import com.imooc.muxin.dao.UserMapper;
import com.imooc.muxin.pojo.Users;
import com.imooc.muxin.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * UserServiceImpl
 *
 * @author : binbin
 * @description : 操作用户
 * @date : 2019/11/17
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Sid sid;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExist(String username) {
        Users user = new Users();
        user.setUsername(username);

        Users users = userMapper.selectOne(user);
        return users != null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users queryUserForLogin(String username, String pwd) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",pwd);

        Users users = userMapper.selectOneByExample(userExample);

        return users;
    }

    @Override
    public Users saveUsers(Users users) {

        String userId = sid.nextShort();
        //todo 为每一个用户生成一个二维码
        users.setQrcode("");

        users.setId(userId);
        userMapper.insert(users);
        return users;
    }
}
