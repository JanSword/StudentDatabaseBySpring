package com.biz.std.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/12.
 */
public class ScoreServiceTest {
    private ApplicationContext ctx = null;
    private ScoreService scoreService= null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        scoreService = ctx.getBean(ScoreService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void tsetGetSubjectAvg(){
        float a=scoreService.getSubjectAvg(1);
        System.out.println(a);
    }
}
