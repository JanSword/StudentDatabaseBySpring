package com.biz.std.service;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/12.
 */
public class StudentServiceTest {
    private ApplicationContext ctx = null;
    private StudentService studentService= null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentService = ctx.getBean(StudentService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

//    @Test
//    public void tsetUpdate(){
//        studentService.update(1,"张三","男", "1994-05-10",5,6,77);
//    }
}
