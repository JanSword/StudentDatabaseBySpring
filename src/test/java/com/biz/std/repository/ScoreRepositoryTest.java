package com.biz.std.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by dell on 2017/5/11.
 */
public class ScoreRepositoryTest {

    private ApplicationContext ctx = null;
    private ScoreRepository scoreRepository= null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        scoreRepository = ctx.getBean(ScoreRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testGetSubjectAvg() {
        System.out.println(scoreRepository.getSubjectAvg(1));
    }

    @Test
    public void testCheckStudentHaveScore() {
        System.out.println(scoreRepository.checkStudentHaveScore(17041001));
    }

    @Test
    public void testCheckSubjectHaveScore() {
        System.out.println(scoreRepository.checkSubjectHaveScore(1));
    }

    @Test
    public void testFindByStudentid(){
        System.out.println(scoreRepository.findByStudentid(17041007).toString());
    }
}
