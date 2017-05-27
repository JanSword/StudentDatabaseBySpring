package com.biz.std.repository;

import com.biz.std.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by dell on 2017/5/11.
 */
public class StudentRepositoryTest {

    private ApplicationContext ctx = null;
    private StudentRepository studentRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentRepository = ctx.getBean(StudentRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName() {
        Student student = studentRepository.findByStudentid(1111);
        System.out.println("学号:" + student.getStudentid()
                + " , 姓名:" + student.getName()
                + " , 性别:" + student.getSex()
                + " , 生日:" + student.getBirthday()
                + " , 所在班级:" + student.getGrade()
                + " , 选修科目数:" + student.getSubjectnum()
                + " , 平均分:" + student.getAvg()
        );
    }
}
