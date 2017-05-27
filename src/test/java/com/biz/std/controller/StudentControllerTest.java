package com.biz.std.controller;

import com.biz.std.domain.Student;
import com.biz.std.repository.StudentPagingAndSortingRepository;
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
public class StudentControllerTest {
    private ApplicationContext ctx = null;
    private StudentController studentController=null;
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository=null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentController = ctx.getBean(StudentController.class);
        studentPagingAndSortingRepository = ctx.getBean(StudentPagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

//    @Test
//   public void testAddStudent(){
//        studentController.addStudent(17014011,"雨婷","女","1994-05-10",2);
//    }

    @Test
    public void testPage(){
        Pageable pageable=new PageRequest(0,10);
        Page<Student> page =studentPagingAndSortingRepository.findAll(pageable);
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent().toString());
    }
}
