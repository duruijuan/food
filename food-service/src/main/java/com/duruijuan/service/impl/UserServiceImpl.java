package com.duruijuan.service.impl;


import com.duruijuan.enums.Sex;
import com.duruijuan.mapper.UsersMapper;
import com.duruijuan.pojo.Users;
import com.duruijuan.pojo.bo.UserBo;
import com.duruijuan.service.UserService;
import com.duruijuan.utils.DateUtil;
import com.duruijuan.utils.MD5Utils;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Sid sid;
    private static final String USER_FACE="https://cn.bing.com/images/search?view=detailV2&ccid=mhAHlVsx&id=C5E9D047187AF73B42A420339FA0D0AE60A305A4&thid=OIP.mhAHlVsxgdvXusLOVItvIwAAAA&mediaurl=https%3a%2f%2fp.qqan.com%2fup%2f2021-7%2f16272649758490171.jpg&exph=400&expw=400&q=%e5%a4%b4%e5%83%8f&simid=608026791164001513&FORM=IRPRST&ck=5A520269738ADC769304E7A814065668&selectedIndex=49&itb=0&ajaxhist=0&ajaxserp=0";
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample=new Example(Users.class);
        Example.Criteria userExampleCriteria=userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        Users result=usersMapper.selectOneByExample(userExample);


        return result==null?false:true;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBo userBo) {
        String userId=sid.nextShort();
        Users user=new Users();
        user.setId(userId);
        user.setUsername(userBo.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认用户昵称同用户名
        user.setNickname(userBo.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        //默认性别 保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        Example userExample=new Example(Users.class);
        Example.Criteria userExampleCriteria=userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        userExampleCriteria.andEqualTo("password",password);
        Users result=usersMapper.selectOneByExample(userExample);
        return result;
    }


}
