package com.duruijuan.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @projectName: food
 * @package: com.duruijuan.pojo.bo
 * @className: UserBo
 * @author: duruijuan
 * @description:
 * @since: 2024-01-16 20:07
 * @version: 1.0
 */
@ApiModel(value = "用户对象Bo",description = "从客户端由用户传入的数据封装在此entity中")

@Data
public class UserBo {
    @ApiModelProperty(value = "用户名",name="username",example = "duruijuan",required = true)
    private String username;
    @ApiModelProperty(value = "密码",name="password",example = "123456",required = true)
    private String password;
    @ApiModelProperty(value = "确认密码",name="confirmPassword",example = "123456",required = true)
    private String confirmPassword;


}
