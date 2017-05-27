package com.biz.std.controller;

import com.biz.std.domain.Grade;
import com.biz.std.repository.GradePagingAndSortingRepository;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell on 2017/5/5.
 */
@Controller
@RequestMapping("/stddb/grade")
public class GradeController {

    @Autowired
    private GradePagingAndSortingRepository gradePagingAndSortingRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    /**
     * 查看班级信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/gradeMain")
    public String gradeMain(String page, Model model) {
        if (null == page) {
            page = "1";
        }
        Pageable checkPageable = new PageRequest(0, 10);
        Page<Grade> checkgradePage = gradePagingAndSortingRepository.findAll(checkPageable);
        int checkPage = checkgradePage.getTotalPages();
        int p = Integer.valueOf(page);
        if (p <= 1) {
            p = 1;
        } else if (p >= checkPage) {
            p = checkPage;
        }
        Pageable pageable = new PageRequest(p - 1, 10);
        Page<Grade> gradePage = gradePagingAndSortingRepository.findAll(pageable);
        model.addAttribute("grades", gradePage.getContent());
        model.addAttribute("gradePage", gradePage);
        return "gradeMain";
    }

    @RequestMapping(value = "/addGradePrompt")
    public String addGradePrompt() {
        return "addGrade";
    }

    @RequestMapping(value = "/updateGradePrompt")
    public String updateGradePrompt(Model model, int gradeid) {
        model.addAttribute("grade", this.gradeService.getGradeByGradeid(gradeid));
        return "updateGrade";
    }

    /**
     * 新增班级信息
     *
     * @param gradename
     * @return
     */
    @RequestMapping(value = "/addGrade")
    public String addGrade(String gradename) {
        gradeService.save(gradename);
        return "redirect:gradeMain";
    }

    /**
     * 更新班级信息
     *
     * @param gradeid
     * @param gradename
     * @return
     */
    @RequestMapping(value = "/updateGrade")
    public String updateGrade(int gradeid, String gradename) {
        gradeService.updateExceptAvg(gradeid, gradename);
        return "redirect:gradeMain";
    }

    /**
     * 刷新
     *
     * @param page
     * @param gradeid
     * @return
     */
    @RequestMapping(value = "/refreshGrade")
    public String refreshSubject(int page, int gradeid) {
        if (studentService.checkGradesHaveNoZeroScore(gradeid) == 0 && studentService.checkGradeHaveStudents(gradeid) != 0) {
            gradeService.updateByGradeidExceptAvg(gradeid);
        } else {
            gradeService.updateByGradeid(gradeid);
        }
        return "redirect:gradeMain?page=" + page;
    }

    /**
     * 删除班级信息
     *
     * @param model
     * @param gradeid
     * @return
     */
    @RequestMapping(value = "/deleteGrade")
    public String deleteGrade(Model model, int gradeid) {
        boolean checkStudentNum = true;
        if (studentService.getStudentNum(gradeid) == 0) {
            gradeService.delete(gradeid);
        } else {
            checkStudentNum = false;
        }
        ;
        model.addAttribute("checkStudentNum", checkStudentNum);
        return "redirect:gradeMain";
    }
}
