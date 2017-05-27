package com.biz.std.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/11.
 */
public class ScoreControllerTest {
    private ApplicationContext ctx = null;
    private ScoreController scoreController;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        scoreController = ctx.getBean(ScoreController.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
   public void testAdd(){
        scoreController.addScore(5,17041002);

    }

//    @Test
//    public void testEasySave(){
//            scoreService.saveOne(2,17041001);
//    }
//
//    @Test
//    public void testUpdate(){
//        for(int i=0;i<10;i++)
//        scoreService.update(16+i,2,17041001+i,70+i);
//    }
//
//    @Test
//    public void testDelete(){
//        scoreService.deleteOne(1);
//    }
}
