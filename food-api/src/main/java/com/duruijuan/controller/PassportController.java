package com.duruijuan.controller;

import com.duruijuan.pojo.Users;
import com.duruijuan.pojo.bo.UserBo;
import com.duruijuan.service.UserService;
import com.duruijuan.utils.JsonResult;
import com.duruijuan.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * @author: duruijuan
 * @since: 2024-01-16 15:22
 **/
@Api(value = "注册登录",tags={"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UserService userService;

    /**
     * description:判断用户名是否存在
     *
     * @param username
     * @return {@link int}
     * @author: duruijuan
     * @since: 2024-01-16 15:23
     **/
    @ApiOperation(value = "用户名是否存在",notes="用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JsonResult usernameIsExist(@RequestParam String username) {
//        判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return JsonResult.errorMsg("用户名不能为空");
        }
        //查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已经存在");
        }
        //请求成功，用户名没有重复
        else {
            return JsonResult.ok();
        }

    }
    @ApiOperation(value = "用户注册",notes="用户注册",httpMethod = "POST")
    @PostMapping("/regist")
    public JsonResult regist(@RequestBody UserBo userBo) {
        String username=userBo.getUsername();
        String password=userBo.getPassword();
        String confirmPassword=userBo.getConfirmPassword();
        //判断用户名和密码必须不为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)||StringUtils.isBlank(confirmPassword)){
            return JsonResult.errorMsg("用户名或密码不能为空");

        }
//        查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已经存在");
        }
//        密码长度不能少于6位
        if(password.length()<6){
            return JsonResult.errorMsg("密码长度不能少于6位");
        }
//        判断两次密码是否一致
        if(!password.equals(confirmPassword)){
            return JsonResult.errorMsg("两次密码不一致");
        }
//        实现注册
        userService.createUser(userBo);
        return JsonResult.ok();

    }

    @ApiOperation(value = "用户登录",notes="用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public JsonResult login(@RequestBody UserBo userBo) throws Exception {
        String username=userBo.getUsername();
        String password=userBo.getPassword();
        //String confirmPassword=userBo.getConfirmPassword();
        //判断用户名和密码必须不为空
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JsonResult.errorMsg("用户名或密码不能为空");

        }
//        查询用户名是否存在
//        boolean isExist = userService.queryUsernameIsExist(username);
//        if (isExist) {
//            return JsonResult.errorMsg("用户名已经存在");
//        }
//        密码长度不能少于6位
//        if(password.length()<6){
//            return JsonResult.errorMsg("密码长度不能少于6位");
//        }
//        判断两次密码是否一致
//        if(!password.equals(confirmPassword)){
//            return JsonResult.errorMsg("两次密码不一致");
//        }
//        实现登录
        Users userResult=userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));

//
        if(userResult==null){
            return JsonResult.errorMsg("用户名已经存在");
        }
        return JsonResult.ok(userResult);
    }
}
