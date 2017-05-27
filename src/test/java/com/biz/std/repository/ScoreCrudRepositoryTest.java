package com.biz.std.repository;

import com.biz.std.domain.Score;
import com.biz.std.service.ScoreService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/11.
 */
public class ScoreCrudRepositoryTest {
    private ApplicationContext ctx = null;
    private ScoreService scoreService=null;

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
   public void testSave(){
        Score score=null;
        for (int i=0;i<5;i++){
            score=new Score();
            score.setSubjectid(27+i);
            score.setStudentid(17041005+i);
            scoreService.save(score);
            //……
        }
    }

    @Test
    public void testSaveExceptScore() {
        scoreService.save(1,1);

    }
    @Test
    public void testEasySave(){
            scoreService.save(2,17041001);
    }

    @Test
    public void testUpdateOne(){
        scoreService.update(51,29,17041007,63);
    }

//    @Test
//    public void testUpdate(){
//        for(int i=0;i<10;i++)
//        scoreService.update(16+i,2,17041001+i,70+i);
//    }

    @Test
    public void testDelete(){
        scoreService.delete(1);
    }

    @Test
    public void testCheckSubjectHaveStudent(){
        System.out.println(scoreService.checkSubjectHaveStudent(22));
    }

    @Test
    public void testCheckSubjectHaveScore(){
        System.out.println(scoreService.checkSubjectHaveScore(22));
    }

    @Test
    public void test(){
        System.out.println(scoreService.checkStudentHaveScore(1));
    }
//    @Test
//    public void testDeleteByStudentid(){
//        if (scoreService.checkStudentHaveSubject(17041006)!=0) {
//            scoreService.deleteByStudentid(17041006);
//        }
//        else System.out.println("没有该学生相关信息");
//    }
}
