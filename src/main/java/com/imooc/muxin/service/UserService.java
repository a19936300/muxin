package com.imooc.muxin.service;

import com.imooc.muxin.pojo.Users;

public interface UserService {
    /**
     * 查询用户名是否存在
     *
     * @Title: queryUsernameIsExist
     * @param username
     * @return : boolean
     *
     * date           modify by            workitem
     * ──────────────────────────────────────────────
     * 2019年09月30日        dszvz
     */
    public boolean queryUsernameIsExist(String username);


    /**
     * 查询用户名和密码
     *
     * @Title: queryUserForLogin
     * @param username
    * @param pwd
     * @return : com.imooc.muxin.pojo.Users
     *
     * date           modify by            workitem
     * ──────────────────────────────────────────────
     * 2019年09月30日        dszvz
     */
    public Users queryUserForLogin(String username,String pwd);

    /**
     * 保存用户
     *
     * @Title: saveUsers
     * @param users
     * @return : com.imooc.muxin.pojo.Users
     *
     * date           modify by            workitem
     * ──────────────────────────────────────────────
     * 2019年09月30日        dszvz
     */
    public Users saveUsers(Users users);
}
