package com.biz.std.service;

import com.biz.std.domain.Score;
import com.biz.std.repository.ScoreCrudRepository;
import com.biz.std.repository.ScoreRepository;
import com.biz.std.util.RoundOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Service("scoreService")
public class ScoreService {
    private Score score;
    RoundOff roundOff = new RoundOff();

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    /**
     * 批量新增选课信息
     * @param scores
     */
    @Transactional
    public void save(List<Score> scores) {
        scoreCrudRepository.save(scores);
    }

    /**
     * 单独新增选课信息
     * @param score
     */
    @Transactional
    public void save(Score score) {
        scoreCrudRepository.save(score);
    }

    /**
     * 新增选课信息
     * 不包含分数录入
     * @param subjectid
     * @param studentid
     */
    @Transactional
    public void save(int subjectid, int studentid) {
        score = new Score();
        score.setSubjectid(subjectid);
        score.setStudentid(studentid);
        scoreCrudRepository.save(score);
    }

    /**
     * 分数录入
     * @param id
     * @param subjectid
     * @param studentid
     * @param examscore
     */
    @Transactional
    public void update(int id,int subjectid, int studentid,int examscore) {
        score = new Score();
        score.setId(id);
        score.setSubjectid(subjectid);
        score.setStudentid(studentid);
        score.setScore(examscore);
        scoreCrudRepository.save(score);
    }

    /**
     * 删除选课信息
     * @param id
     */
    @Transactional
    public void delete(int id) {
        scoreCrudRepository.delete(id);
    }

    /**
     * 获得某学生选的所有课程ID
     * @param studentid
     * @return
     */
    public List getSubjectidByStudentid(int studentid) {
        return scoreRepository.getSubjectidByStudentid(studentid);
    }

    /**
     * 查询某学生的所有选课编号
     * @param studentid
     * @return
     */
    public List getIdByStudentid(int studentid) {
        return scoreRepository.getIdByStudentid(studentid);
    }

    /**
     * 查询选某课程的所有学生
     * @param subjectid
     * @return
     */
    public List getStudentidBySubjectid(int subjectid) {
        return scoreRepository.getStudentidBySubjectid(subjectid);
    }

    /**
     * 查询某课程的所有选课编号
     * @param subjectid
     * @return
     */
    public List getIdBySubjectid(int subjectid) {
        return scoreRepository.getIdBySubjectid(subjectid);
    }

    /**
     * 查询某学生的选课总数
     * @param studentid
     * @return
     */
    public int getSubjectNum(int studentid) {
        if (null==scoreRepository.getSubjectNum(studentid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(scoreRepository.getSubjectNum(studentid)));
    }

    /**
     * 查询某课程的选课人数
     * @param subjectid
     * @return
     */
    public int getElectiveNum(int subjectid) {
        if (null == scoreRepository.getElectiveNum(subjectid))
            return 0;
        else {
            return Integer.valueOf(String.valueOf(scoreRepository.getElectiveNum(subjectid)));
        }
    }

    /**
     * 查询某学生的平均分
     * @param studentid
     * @return
     */
    public float getAvg(int studentid) {
        if (null==scoreRepository.getAvg(studentid))
            return 0f;
        else
        return roundOff.roundOff(Float.valueOf(String.valueOf(scoreRepository.getAvg(studentid))));
    }

    /**
     * 查询某课程的平均分
     * @param subjectid
     * @return
     */
    public float getSubjectAvg(int subjectid) {
        if (null==scoreRepository.getSubjectAvg(subjectid))
            return 0f;
        else
        return roundOff.roundOff(Float.valueOf(String.valueOf(scoreRepository.getSubjectAvg(subjectid))));
    }

    /**
     * 查询某学生已经录入分数的课程数量
     * @param studentid
     * @return
     */
    public int checkStudentHaveScore(int studentid) {
        if (null==scoreRepository.checkStudentHaveScore(studentid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(scoreRepository.checkStudentHaveScore(studentid)));
    }

    /**
     * 查询某课程已经录入分数的学生数量
     * @param subjectid
     * @return
     */
    public int checkSubjectHaveScore(int subjectid) {
        if (null==scoreRepository.checkSubjectHaveScore(subjectid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(scoreRepository.checkSubjectHaveScore(subjectid)));
    }

    /**
     * 查询某课程的选课学生数量
     * @param subjectid
     * @return
     */
    public int checkSubjectHaveStudent(int subjectid) {
        if (null==scoreRepository.checkSubjectHaveStudent(subjectid))
            return 0;
        else
        return Integer.valueOf(String.valueOf(scoreRepository.checkSubjectHaveStudent(subjectid)));
    }

    /**
     * 查询某学生的选课数量
     * @param studentid
     * @return
     */
    public int checkStudentHaveSubject(int studentid) {
        if (null==scoreRepository.checkStudentHaveSubject(studentid))
        {return 0;}
        else
        {return Integer.valueOf(String.valueOf(scoreRepository.checkStudentHaveSubject(studentid)));}
    }

    /**
     * 检查是否已存在某条选课信息
     * @param studentid
     * @param subjectid
     * @return
     */
    public boolean checkHaveElectived(int studentid,int subjectid){
        if (null==scoreRepository.checkHaveElectived(studentid,subjectid)) {return false;}
        else if (Integer.valueOf(String.valueOf(scoreRepository.checkHaveElectived(studentid,subjectid)))==0){
            return false;
        }
        else { return true;}
    }

    /**
     * 根据是否已存在某条选课信息
     * 判断可选状态
     * 返回“已选”/“选修”
     * @param studentid
     * @param subjectid
     * @return
     */
    public String checkHaveElectivedOfString(int studentid,int subjectid){
        if (null==scoreRepository.checkHaveElectived(studentid,subjectid)) {return "选课";}
        else if (Integer.valueOf(String.valueOf(scoreRepository.checkHaveElectived(studentid,subjectid)))==0){
            return "选课";
        }
        else { return "已选";}
    }

    /**
     * 根据是否已存在某条选课信息
     * 生成button的disable状态
     * @param studentid
     * @param subjectid
     * @return
     */
    public String checkHaveElectivedOfAble(int studentid,int subjectid){
        if (null==scoreRepository.checkHaveElectived(studentid,subjectid)) {return "";}
        else if (Integer.valueOf(String.valueOf(scoreRepository.checkHaveElectived(studentid,subjectid)))==0){
            return "";
        }
        else { return "disabled";}
    }

    /**
     * 根据是否已存在某条选课信息
     * 生成button颜色
     * @param studentid
     * @param subjectid
     * @return
     */
    public String checkHaveElectivedOfColor(int studentid,int subjectid){
        if (null==scoreRepository.checkHaveElectived(studentid,subjectid)) {return "info";}
        else if (Integer.valueOf(String.valueOf(scoreRepository.checkHaveElectived(studentid,subjectid)))==0){
            return "info";
        }
        else { return "warning";}
    }

    /**
     * 通过选课编号获得该选课信息
     * @param id
     * @return
     */
    public Score getScoreById(int id) {
        return scoreRepository.findById(id);
    }

    /**
     * 查询某学生的所有选课信息
     * @param studentid
     * @return
     */
    public List getScoreByStudentid(int studentid){
        return scoreRepository.findByStudentid(studentid);
    }

}
