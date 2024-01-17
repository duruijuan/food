package com.duruijuan.controller;

import com.duruijuan.pojo.bo.UserBo;
import com.duruijuan.service.UserService;
import com.duruijuan.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @param null
 * @return {@link null}
 * @author: duruijuan
 * @since: 2024-01-16 15:22
 **/

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


}
