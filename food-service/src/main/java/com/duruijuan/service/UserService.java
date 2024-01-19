package com.duruijuan.service;


import com.duruijuan.pojo.Users;
import com.duruijuan.pojo.bo.UserBo;

public interface UserService {
/**
 * description:判断用户名是否存在
 * @param username
 * @return {@link boolean}
 * @author: duruijuan
 * @since: 2024-01-16 14:54
 **/
boolean queryUsernameIsExist(String username);
/**
 * description:创建用户
 * @param userBo
 * @return {@link Users}
 * @author: duruijuan
 * @since: 2024-01-16 20:09
 **/
Users createUser(UserBo userBo);
/**
 * description:检索用户名和密码是否匹配用于登录
 * @param username
 * @param password
 * @return {@link Users}
 * @author: duruijuan
 * @since: 2024-01-19 13:49
 **/
Users queryUserForLogin(String username,String password);
}
