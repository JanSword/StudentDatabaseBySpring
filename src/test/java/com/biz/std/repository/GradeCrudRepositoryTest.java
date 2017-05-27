package com.biz.std.repository;

import com.biz.std.service.GradeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/11.
 */
public class GradeCrudRepositoryTest {
    private ApplicationContext ctx = null;
    private GradeService gradeService=null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        gradeService = ctx.getBean(GradeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testSave(){
        gradeService.save("二班");
    }

//    @Test
//    public void testUpdate(){
//        gradeService.update(1,"三班",5,5);
//    }

//    @Test
//    public void testUpdateSome(){
//        gradeService.updateSome(1,"四班");
//    }
}
