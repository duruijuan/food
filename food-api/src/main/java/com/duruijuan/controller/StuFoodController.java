package com.duruijuan.controller;

import com.duruijuan.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

@RestController
public class StuFoodController {
    @Autowired
    private StuService stuService;
    @GetMapping("/getStu")
    public Object getStu(int id){
        return stuService.getStuInfo(id);
    }
    @PostMapping("/saveStu")
    public Object saveStu(){
         stuService.saveStu();
         return "OK";
    }
    @PostMapping("/updateStu")
    public Object updateStu(int id){
        stuService.updateStu(id);
        return "OK";
    }
    @PostMapping("/deleteStu")
    public Object deleteStu(int id){
        stuService.deleteStu(id);
        return "OK";
    }
}
