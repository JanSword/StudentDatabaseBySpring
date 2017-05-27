package com.biz.std.service;

import com.biz.std.domain.Student;
import com.biz.std.repository.StudentCrudRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.util.RoundOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Service("studentService")
public class StudentService {
    @Autowired
    private ScoreService scoreService;

    private Student student;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCrudRepository studentCrudRepository;

    /**
     * 新增学生信息
     * 不包括平均分、照片
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     */
    @Transactional
    public void saveExceptAvg(int studentid, String name, String sex, String birthday, int grade) {
        student = new Student();
        student.setStudentid(studentid);
        student.setName(name);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setGrade(grade);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 新增学生信息
     * 不包括平均分
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     * @param img
     */
    @Transactional
    public void saveExceptAvgIncludeImg(int studentid, String name, String sex, String birthday, int grade,String img) {
        student = new Student();
        student.setStudentid(studentid);
        student.setName(name);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setGrade(grade);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        student.setImg(img);
        studentCrudRepository.save(student);
    }

    /**
     * 批量新增学生信息
     * @param students
     */
    @Transactional
    public void save(List<Student> students) {
        studentCrudRepository.save(students);
    }

    /**
     * 单独新增学生信息
     * @param student
     */
    @Transactional
    public void save(Student student) {
        studentCrudRepository.save(student);
    }

    /**
     * 新增学生信息
     * 不包括照片
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     */
    @Transactional
    public void save(int studentid, String name, String sex, String birthday, int grade) {
        student = new Student();
        student.setStudentid(studentid);
        student.setName(name);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setGrade(grade);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        student.setAvg(scoreService.getAvg(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 更新学生信息
     * 不包括选课数量、平均分、照片
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     */
    @Transactional
    public void update(int studentid, String name, String sex, String birthday, int grade) {
        student = studentRepository.findByStudentid(studentid);
        student.setStudentid(studentid);
        student.setName(name);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setGrade(grade);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        student.setAvg(scoreService.getAvg(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 更新学生信息
     * 不包括平均分、照片
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     */
    @Transactional
    public void updateExceptAvg(int studentid, String name, String sex, String birthday, int grade) {
        student = studentRepository.findByStudentid(studentid);
        student.setStudentid(studentid);
        student.setName(name);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setGrade(grade);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 已知学生ID
     * 更新学生选课数量、平均分
     * @param studentid
     */
    @Transactional
    public void updateByStudentid(int studentid) {
        student = studentRepository.findByStudentid(studentid);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        student.setAvg(scoreService.getAvg(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 已知学生ID
     * 更新学生选课数量
     * @param studentid
     */
    @Transactional
    public void updateByStudentidExceptAvg(int studentid) {
        student = studentRepository.findByStudentid(studentid);
        student.setSubjectnum(scoreService.getSubjectNum(studentid));
        studentCrudRepository.save(student);
    }

    /**
     * 已知学生ID
     * 更新学生照片
     * @param studentid
     * @param img
     */
    @Transactional
    public void updateByStudentidIncludeImg(int studentid,String img){
        student=studentRepository.findByStudentid(studentid);
        student.setImg(img);
        studentCrudRepository.save(student);
    }

    /**
     * 删除学生
     * @param studentid
     */
    @Transactional
    public void delete(int studentid) {
        studentCrudRepository.delete(studentid);
    }

    /**
     * 已知班级ID
     * 查询该班总人数
     * @param grade
     * @return
     */
    public int getStudentNum(int grade) {
        if (null==studentRepository.getStudentNum(grade))
            return 0;
        else
        return Integer.valueOf(String.valueOf(studentRepository.getStudentNum(grade)));
    }

    /**
     * 已知班级ID
     * 查询该班平均分
     * @param grade
     * @return
     */
    float getStudentAvg(int grade) {
        if (null == studentRepository.getStudentAvg(grade))
            return 0f;
        else {
            RoundOff roundOff = new RoundOff();
            return roundOff.roundOff(Float.valueOf(String.valueOf(studentRepository.getStudentAvg(grade))));
        }
    }

    /**
     * 已知班级ID
     * 查询有分数录入的学生个数
     * @param grade
     * @return
     */
    public int checkStudentsHaveScore(int grade) {
        if (null==studentRepository.checkStudentsHaveScore(grade))
            return 0;
        else
        return Integer.valueOf(String.valueOf(studentRepository.checkStudentsHaveScore(grade)));
    }

    /**
     * 已知班级ID
     * 查询班级分数不为0的学生个数
     * @param grade
     * @return
     */
    public int checkGradesHaveNoZeroScore(int grade) {
        if (null==studentRepository.checkGradeHaveNoZeroScore(grade))
            return 0;
        else
            return Integer.valueOf(String.valueOf(studentRepository.checkGradeHaveNoZeroScore(grade)));
    }

    /**
     * 已知班级ID
     * 查询该班人数
     * @param grade
     * @return
     */
    public int checkGradeHaveStudents(int grade) {
        if (null==studentRepository.checkGradeHaveStudents(grade))
            return 0;
        else
            return Integer.valueOf(String.valueOf(studentRepository.checkGradeHaveNoZeroScore(grade)));
    }

    /**
     * 已知学生ID
     * 查询学生信息
     * @param studentid
     * @return
     */
    public Student getStudentByStudentid(int studentid) {
        return studentRepository.findByStudentid(studentid);
    }

    /**
     * 已知学生ID
     * 查询其所在班级
     * @param studentid
     * @return
     */
    public int getGradeByStudentid(int studentid) {
        if (null==studentRepository.getGradeByStudentid(studentid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(studentRepository.getGradeByStudentid(studentid)));
    }

}
