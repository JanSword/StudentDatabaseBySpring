package com.biz.std.controller;

import com.biz.std.domain.Score;
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
@RequestMapping("/stddb/score")
public class ScoreController {

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
     * 选课页面
     *
     * @param page
     * @param model
     * @param studentid
     * @return
     */
    @RequestMapping(value = "/addScoreMain")
    public String addScoreMain(String page, Model model, int studentid) {
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
        Page<Subject> sbjPage = subjectPagingAndSortingRepository.findAll(pageable);
        model.addAttribute("sbjs", sbjPage.getContent());
        model.addAttribute("subjectPage", sbjPage);
        model.addAttribute("student", studentService.getStudentByStudentid(studentid));
        model.addAttribute("scoreService", scoreService);
        return "addScoreMain";
    }

    /**
     * 选课
     *
     * @param subjectid
     * @param studentid
     * @return
     */
    @RequestMapping(value = "/addScore")
    public String addScore(Integer subjectid, Integer studentid) {
        if (!scoreService.checkHaveElectived(studentid, subjectid)) {
            scoreService.save(subjectid, studentid);
            studentService.updateByStudentidExceptAvg(studentid);
            subjectService.updateBySubjectidExceptAvg(subjectid);
        }
        return "redirect:addScoreMain?studentid=" + studentid;
    }

    /**
     * 分数录入界面
     * 显示该学生已选的所有课程
     *
     * @param model
     * @param studentid
     * @return
     */
    @RequestMapping(value = "/updateScoreMain")
    public String updateScoreMain(Model model, int studentid) {
        List<Score> scores = scoreService.getScoreByStudentid(studentid);
        model.addAttribute("student", studentService.getStudentByStudentid(studentid));
        model.addAttribute("scores", scores);
        model.addAttribute("subjectService", subjectService);
        return "updateScoreMain";
    }

    /**
     * 分数录入
     *
     * @param id
     * @param subjectid
     * @param studentid
     * @param score
     * @return
     */
    @RequestMapping(value = "/updateScore")
    public String updateScore(int id, int subjectid, int studentid, int score) {
        scoreService.update(id, subjectid, studentid, score);
        studentService.updateByStudentid(studentid);
        subjectService.updateBySubjectid(subjectid);
        gradeService.updateByGradeid(studentService.getGradeByStudentid(studentid));
        return "redirect:updateScoreMain?studentid=" + studentid;
    }

    /**
     * 退课功能
     * 暂未使用
     *
     * @param id
     * @param subjectid
     * @param studentid
     * @return
     */
    @RequestMapping(value = "/deleteScore")
    public String deleteScore(int id, int subjectid, int studentid) {

        scoreService.delete(id);

        int gradeid = studentService.getGradeByStudentid(studentid);

        if (scoreService.checkStudentHaveScore(studentid) == 0) {
            studentService.updateByStudentidExceptAvg(studentid);
        } else {
            studentService.updateByStudentid(studentid);
        }

        if (studentService.checkStudentsHaveScore(gradeid) != 0) {
            gradeService.updateByGradeid(gradeid);
        }

        if (scoreService.checkSubjectHaveScore(subjectid) == 0) {
            subjectService.updateBySubjectidExceptAvg(subjectid);
        } else {
            subjectService.updateBySubjectid(subjectid);
        }

        return "redirect:studentMain";
    }
}
