package com.biz.std.repository;

import com.biz.std.domain.Student;
import com.biz.std.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/5/11.
 */
public class StudentCrudRepositoryTest {
    private ApplicationContext ctx = null;
    private StudentService studentService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentService = ctx.getBean(StudentService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testSave() {

        List<Student> students = new ArrayList<Student>();

        Student student = null;
        for (int i = 0; i < 100; i++) {
            student = new Student();
            student.setName("test" + i);
            //……
            students.add(student);
        }
        studentService.save(students);
    }

    @Test
    public void testSaveOne() {

        studentService.save(17041004, "李白", "男", "1994-05-10", 1);
    }

}