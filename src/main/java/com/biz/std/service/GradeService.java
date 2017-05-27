package com.biz.std.service;

import com.biz.std.domain.Grade;
import com.biz.std.repository.GradeCrudRepository;
import com.biz.std.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Service("gradeService")
public class GradeService {

    private Grade grade;

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private GradeCrudRepository gradeCrudRepository;

    /**
     * 批量增加班级信息
     * @param grades
     */
    @Transactional
    public void save(List<Grade> grades){
        gradeCrudRepository.save(grades);
    }

    /**
     * 单独增加班级信息
     * @param grade
     */
    @Transactional
    public void save(Grade grade){
        gradeCrudRepository.save(grade);
    }

    /**
     * 新增班级
     * default平均分和班级人数
     * @param gradename
     */
    @Transactional
    public void save(String gradename) {
        grade=new Grade();
        grade.setGradename(gradename);
        gradeCrudRepository.save(grade);
    }

    /**
     * 更新班级全部信息
     * @param gradeid
     * @param gradename
     */
    @Transactional
    public void update(int gradeid,String gradename) {
        grade=new Grade();
        grade.setGradeid(gradeid);
        grade.setGradename(gradename);
        grade.setStudentnum(studentService.getStudentNum(gradeid));
        grade.setGradeavg(studentService.getStudentAvg(gradeid));
        gradeCrudRepository.save(grade);
    }

    /**
     * 已知班级ID
     * 更新班级人数、平均分
     * @param gradeid
     */
    @Transactional
    public void updateByGradeid(int gradeid) {
        grade=gradeRepository.findByGradeid(gradeid);
        grade.setStudentnum(studentService.getStudentNum(gradeid));
        grade.setGradeavg(studentService.getStudentAvg(gradeid));
        gradeCrudRepository.save(grade);
    }

    /**
     * 已知班级ID
     * 更新班级人数
     * @param gradeid
     */
    @Transactional
    public void updateByGradeidExceptAvg(int gradeid) {
        grade=gradeRepository.findByGradeid(gradeid);
        grade.setStudentnum(studentService.getStudentNum(gradeid));
        gradeCrudRepository.save(grade);
    }

    /**
     * 更新除平均分以外的信息
     * @param gradeid
     * @param gradename
     */
    @Transactional
    public void updateExceptAvg(int gradeid,String gradename) {
        grade=gradeRepository.findByGradeid(gradeid);
        grade.setGradeid(gradeid);
        grade.setGradename(gradename);
        grade.setStudentnum(studentService.getStudentNum(gradeid));
        gradeCrudRepository.save(grade);
    }

    /**
     * 删除班级
     * @param gradeid
     */
    @Transactional
    public void  delete(int gradeid){
        gradeCrudRepository.delete(gradeid);
    }

    /**
     * 通过班级ID查询班级
     * @param gradeid
     * @return
     */
    public Grade getGradeByGradeid(int gradeid){
        return gradeRepository.findByGradeid(gradeid);
    }

    /**
     * 查询所有班级的班级ID
     * @return
     */
    public List findAllGradeid(){
        return gradeRepository.findAllGradeid();
    }

    /**
     * 检查该班级是否存在
     * @param gradeid
     * @return
     */
    public int checkGradeExist(int gradeid){
        if (null==gradeRepository.checkGradeExist(gradeid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(gradeRepository.checkGradeExist(gradeid)));
    }
}
