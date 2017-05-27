package com.biz.std.repository;

import com.biz.std.domain.Subject;
import com.biz.std.service.ScoreService;
import com.biz.std.service.SubjectService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2017/5/11.
 */
public class SubjectCrudRepositoryTest {
    private ApplicationContext ctx = null;
    private SubjectService subjectService=null;
    private ScoreService scoreService=null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        subjectService = ctx.getBean(SubjectService.class);
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
        Subject subject=null;
        subject=new Subject();
        subject.setSubjectname("数学");
        System.out.println(subject.getSubjectid());
        System.out.println(scoreService.getElectiveNum(subject.getSubjectid()));
        subject.setElectivenum(scoreService.getElectiveNum(subject.getSubjectid()));
        subject.setSubjectavg(scoreService.getSubjectAvg(subject.getSubjectid()));
        subjectService.save(subject);
    }

    @Test
    public void testSave1(){
        Subject subject=null;
        subject=new Subject();
//        System.out.println(subject.getSubjectid());
        subject.setSubjectname("政治");
//        System.out.println(subject.getSubjectid());
////        System.out.println(scoreService.getElectiveNum(subject.getSubjectid()));
//        subject.setElectivenum(1);
//        System.out.println(subject.getSubjectid());
////        System.out.println(scoreService.getSubjectAvg(subject.getSubjectid()));
//        subject.setSubjectavg(55.5f);
//        System.out.println(subject.getSubjectid());
        subjectService.save(subject);
        System.out.println(subject.getSubjectid());
    }

    @Test
    public void testEasySave(){
        for(int i=0;i<50;i++) {
            subjectService.save("数学");
        }
    }

//    @Test
//    public void testUpdate(){
//        if(scoreService.checkSubjectHaveScore(2)!=0){
//            subjectService.update(2,"体育1");
//        }
//        else subjectService.updateSome(2,"体育2");
//    }

    @Test
    public void testGetSubjectAvg(){
        System.out.println(scoreService.getSubjectAvg(4));
    }

    @Test
    public void testGetSubjectNum(){
        System.out.println(scoreService.getSubjectNum(4));
    }

}
