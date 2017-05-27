package com.biz.std.controller;

import com.biz.std.domain.Subject;
import com.biz.std.repository.SubjectPagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by dell on 2017/5/11.
 */
public class SubjectControllerTest {
    private ApplicationContext ctx = null;
    private SubjectController subjectController=null;
    private SubjectPagingAndSortingRepository subjectPagingAndSortingRepository=null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        subjectController = ctx.getBean(SubjectController.class);
        subjectPagingAndSortingRepository = ctx.getBean(SubjectPagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

//    @Test
//   public void testAddStudent(){
//        studentController.addStudent(17000141,"雨婷","女","1994-05-10",5);
//    }

    @Test
    public void testPage(){
        Pageable pageable=new PageRequest(0,10);
        Page<Subject> page =subjectPagingAndSortingRepository.findAll(pageable);
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
        System.out.println(page.getNumber());
        System.out.println(page.getContent().toString());
    }

    @Test
    public void testDeleteSubject(){
        subjectController.deleteSubject(6);
    }
}
