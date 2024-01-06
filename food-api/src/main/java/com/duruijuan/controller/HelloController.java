package com.duruijuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: food
 * @package: com.duruijuan.controller
 * @className: HelloController
 * @author: duruijuan
 * @description:
 * @since: 2024-01-06 19:00
 * @version: 1.0
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("/test")
    public String test(){
        return "hello world";
    }
}
