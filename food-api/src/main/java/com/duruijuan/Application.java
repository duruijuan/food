package com.duruijuan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @projectName: food
 * @package: com.duruijuan
 * @className: Application
 * @author: duruijuan
 * @description:
 * @since: 2024-01-06 18:56
 * @version: 1.0
 */
@SpringBootApplication
//扫描mybatis通用mapper所有的包
@MapperScan(basePackages = "com.duruijuan.mapper")
//扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.duruijuan","org.n3r.idworker"})
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
    }
}

