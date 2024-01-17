package com.duruijuan;

import com.duruijuan.Application;
import com.duruijuan.service.StuService;
import com.duruijuan.service.TestTransService;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @projectName: food
 * @package: com.duruijuan
 * @className: TransTest
 * @author: duruijuan
 * @description:
 * @since: 2024-01-14 19:35
 * @version: 1.0
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

      //  @Test
    public void myTest() {
//        stuService.testPropagationTrans();
        testTransService.testPropagationTrans();
    }

}
