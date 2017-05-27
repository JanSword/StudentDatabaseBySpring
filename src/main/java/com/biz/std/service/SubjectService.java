package com.biz.std.service;

import com.biz.std.repository.SubjectCrudRepository;
import com.biz.std.domain.Subject;
import com.biz.std.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Service("subjectService")
public class SubjectService {
    private Subject subject;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectCrudRepository subjectCrudRepository;

    @Autowired
    private ScoreService scoreService;

    /**
     * 批量新增课程
     * @param subjects
     */
    @Transactional
    public void save(List<Subject> subjects){
        subjectCrudRepository.save(subjects);
    }

    /**
     * 单独新增课程
     * @param subject
     */
    @Transactional
    public void save(Subject subject){
        subjectCrudRepository.save(subject);
    }

    /**
     * 新增课程
     * 不包括选课人数、平均分
     * @param subjectname
     */
    @Transactional
    public void save(String subjectname) {
        subject=new Subject();
        subject.setSubjectname(subjectname);
        subjectCrudRepository.save(subject);
    }

    /**
     * 更新课程信息
     * @param subjectid
     * @param subjectname
     */
    @Transactional
    public void update(int subjectid,String subjectname) {
        subject=subjectRepository.findBySubjectid(subjectid);
        subject.setSubjectid(subjectid);
        subject.setSubjectname(subjectname);
        subject.setElectivenum(scoreService.getElectiveNum(subjectid));
        subject.setSubjectavg(scoreService.getSubjectAvg(subjectid));
        subjectCrudRepository.save(subject);
    }

    /**
     * 更新课程信息
     * 不包括平均分
     * @param subjectid
     * @param subjectname
     */
    @Transactional
    public void updateExceptAvg(int subjectid,String subjectname) {
        subject=subjectRepository.findBySubjectid(subjectid);
        subject.setSubjectid(subjectid);
        subject.setSubjectname(subjectname);
        subject.setElectivenum(scoreService.getElectiveNum(subjectid));
        subjectCrudRepository.save(subject);
    }

    /**
     * 通过课程ID
     * 更新课程信息
     * @param subjectid
     */
    @Transactional
    public void updateBySubjectid(int subjectid) {
        subject=subjectRepository.findBySubjectid(subjectid);
        subject.setElectivenum(scoreService.getElectiveNum(subjectid));
        subject.setSubjectavg(scoreService.getSubjectAvg(subjectid));
        subjectCrudRepository.save(subject);
    }

    /**
     * 通过课程ID
     * 更新课程信息
     * 不包括平均分
     * @param subjectid
     */
    @Transactional
    public void updateBySubjectidExceptAvg(int subjectid) {
        subject=subjectRepository.findBySubjectid(subjectid);
        subject.setElectivenum(scoreService.getElectiveNum(subjectid));
        subjectCrudRepository.save(subject);
    }

    /**
     * 删除课程信息
     * @param subjectid
     */
    @Transactional
    public void  delete(int subjectid){
        subjectCrudRepository.delete(subjectid);
    }

    /**
     * 通过课程ID获取课程信息
     * @param subjectid
     * @return
     */
    public Subject getSubjectBySubjectid(int subjectid){
        return subjectRepository.findBySubjectid(subjectid);
    }

}
