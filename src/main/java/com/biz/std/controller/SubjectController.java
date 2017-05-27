package com.biz.std.controller;

import com.biz.std.domain.Subject;
import com.biz.std.repository.SubjectPagingAndSortingRepository;
import com.biz.std.service.GradeService;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Controller
@RequestMapping("/stddb/subject")
public class SubjectController {

    @Autowired
    private SubjectPagingAndSortingRepository subjectPagingAndSortingRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 查看所有课程信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/subjectMain")
    public String subjectMain(String page, Model model) {
        if (null == page) {
            page = "1";
        }
        Pageable checkPageable = new PageRequest(0, 10);
        Page<Subject> checksubjectPage = subjectPagingAndSortingRepository.findAll(checkPageable);
        int checkPage = checksubjectPage.getTotalPages();
        int p = Integer.valueOf(page);
        if (p <= 1) {
            p = 1;
        } else if (p >= checkPage) {
            p = checkPage;
        }
        Pageable pageable = new PageRequest(p - 1, 10);
        Page<Subject> subjectPage = subjectPagingAndSortingRepository.findAll(pageable);
        model.addAttribute("subjects", subjectPage.getContent());
        model.addAttribute("subjectPage", subjectPage);
        return "subjectMain";
    }

    @RequestMapping(value = "/addSubjectPrompt")
    public String addSubjectPrompt() {
        return "addSubject";
    }

    @RequestMapping(value = "/updateSubjectPrompt")
    public String updateSubjectPrompt(Model model, int subjectid) {
        model.addAttribute("subject", this.subjectService.getSubjectBySubjectid(subjectid));
        return "updateSubject";
    }

    /**
     * 新增课程
     *
     * @param subjectname
     * @return
     */
    @RequestMapping(value = "/addSubject")
    public String addSubject(String subjectname) {
        subjectService.save(subjectname);
        return "redirect:subjectMain";
    }

    /**
     * 更新课程信息
     *
     * @param subjectid
     * @param subjectname
     * @return
     */
    @RequestMapping(value = "/updateSubject")
    public String updateSubject(int subjectid, String subjectname) {
        subjectService.updateExceptAvg(subjectid, subjectname);
        return "redirect:subjectMain";
    }

    /**
     * 刷新课程信息
     *
     * @param page
     * @param subjectid
     * @return
     */
    @RequestMapping(value = "/refreshSubject")
    public String refreshSubject(int page, int subjectid) {
        if (scoreService.checkSubjectHaveScore(subjectid) == 0) {
            subjectService.updateBySubjectidExceptAvg(subjectid);
        } else {
            subjectService.updateBySubjectid(subjectid);
        }
        return "redirect:subjectMain?page=" + page;
    }

    @RequestMapping(value = "/deleteSubject")
    public String deleteSubject(int subjectid) {

        subjectService.delete(subjectid);
        /**
         * 对该课程相关的学生、班级、分数信息进行更新
         */
        List<Integer> studentids = scoreService.getStudentidBySubjectid(subjectid);
        System.out.println(studentids);
        List<Integer> ids = scoreService.getIdBySubjectid(subjectid);
        if (scoreService.checkSubjectHaveStudent(subjectid) != 0) {
            for (Integer id : ids) {
                scoreService.delete(id);
            }
            for (Integer studentid : studentids) {
                studentService.updateByStudentid(studentid);
                Integer gradeid = studentService.getGradeByStudentid(studentid);
                gradeService.updateByGradeid(gradeid);
            }
        }
        return "redirect:subjectMain";
    }
}
