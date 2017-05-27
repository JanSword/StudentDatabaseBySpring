package com.biz.std.util;

import com.biz.std.repository.ScoreRepository;
import com.biz.std.service.ScoreService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/15.
 */
public class RoundOffTest {

    private ApplicationContext ctx = null;
    private ScoreService scoreService=null;
    private ScoreRepository scoreRepository=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("beans.xml");
        scoreRepository=ctx.getBean(ScoreRepository.class);
        scoreService=ctx.getBean(ScoreService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testRoundOff(){
        RoundOff roundOff=new RoundOff();
        float a=Float.valueOf(String.valueOf(scoreRepository.getSubjectAvg(1)));
        System.out.println(a);
        float b=roundOff.roundOff(a);
        System.out.println(b);
        float c=scoreService.getSubjectAvg(1);
        System.out.println(c);
    }
}
