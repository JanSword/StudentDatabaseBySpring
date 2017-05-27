package com.biz.std.repository;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by dell on 2017/5/11.
 */
public class GradeRepositoryTest {

    private ApplicationContext ctx = null;
    private GradeRepository gradeRepository= null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        gradeRepository = ctx.getBean(GradeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

//    @Test
//    public void testUpdateSome() {
//        gradeRepository.updateSome(1,"一班");
//    }

//    @Test
//    public void testUpdate() {
//        gradeRepository.update(1,"一班",5,5);
//    }
}
