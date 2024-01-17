package com.duruijuan.pojo.bo;

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
@Data
public class UserBo {
    private String username;
    private String password;
    private String confirmPassword;


}
