package com.biz.std.controller;

import com.biz.std.domain.Student;
import com.biz.std.repository.GradePagingAndSortingRepository;
import com.biz.std.repository.StudentPagingAndSortingRepository;
import com.biz.std.service.GradeService;
import com.biz.std.service.ScoreService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by dell on 2017/5/5.
 */
@Controller
@RequestMapping("/stddb/student")
public class StudentController {

    @Autowired
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository;
    @Autowired
    private GradePagingAndSortingRepository gradePagingAndSortingRepository;
    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 查看所有学生信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/studentMain")
    public String studentMain(String page, Model model) {
        if (null == page) {
            page = "1";
        }
        Pageable checkPageable = new PageRequest(0, 10);
        Page<Student> checkstudentPage = studentPagingAndSortingRepository.findAll(checkPageable);
        int checkPage = checkstudentPage.getTotalPages();
        int p = Integer.valueOf(page);
        if (p <= 1) {
            p = 1;
        } else if (p >= checkPage) {
            p = checkPage;
        }
        Pageable pageable = new PageRequest(p - 1, 10);
        Page<Student> studentPage = studentPagingAndSortingRepository.findAll(pageable);
        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("studentPage", studentPage);
        return "studentMain";
    }

    @RequestMapping(value = "/addStudentPrompt")
    public String addStudentPrompt(Model model) {
        List<Integer> gradeids = gradeService.findAllGradeid();
        model.addAttribute("gradeids", gradeids);
        return "addStudent";
    }

    @RequestMapping(value = "/updateStudentPrompt")
    public String updateStudentPrompt(Model model, int studentid) {
        model.addAttribute("student", this.studentService.getStudentByStudentid(studentid));
        List<Integer> gradeids = gradeService.findAllGradeid();
        model.addAttribute("gradeids", gradeids);
        return "updateStudent";
    }

    /**
     * 新增学生
     *
     * @param request
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     * @param model
     * @param img
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest request, int studentid, String name, String sex, String birthday, int grade, Model model, @RequestParam("img") MultipartFile img) throws IOException {
        String notice = "";
        if (null == studentService.getStudentByStudentid(studentid) && null != gradeService.getGradeByGradeid(grade)) {
            if (!img.isEmpty()) {
                long nowTime = System.currentTimeMillis();
                FileUtils.copyInputStreamToFile(img.getInputStream(), new File(request.getSession().getServletContext().getRealPath("Images"), nowTime + img.getOriginalFilename()));
                studentService.saveExceptAvgIncludeImg(studentid, name, sex, birthday, grade, nowTime + img.getOriginalFilename());
            } else {
                studentService.saveExceptAvg(studentid, name, sex, birthday, grade);
            }
            gradeService.updateByGradeidExceptAvg(grade);
            return "redirect:studentMain";
        } else {
            List<Integer> gradeids = gradeService.findAllGradeid();
            notice = "该学号已被占用，请重新输入!";
            model.addAttribute("notice", notice);
            model.addAttribute("gradeids", gradeids);
            return "addStudent";
        }
    }

    /**
     * 刷新学生信息
     *
     * @param page
     * @param studentid
     * @return
     */
    @RequestMapping(value = "/refreshStudent")
    public String refreshStudent(int page, int studentid) {
        if (scoreService.checkStudentHaveScore(studentid) == 0) {
            studentService.updateByStudentidExceptAvg(studentid);
        } else {
            studentService.updateByStudentid(studentid);
        }
        return "redirect:studentMain?page=" + page;
    }

    /**
     * 更新学生信息
     *
     * @param studentid
     * @param name
     * @param sex
     * @param birthday
     * @param grade
     * @param pregrade
     * @return
     */
    @RequestMapping(value = "/updateStudent")
    public String updateStudent(int studentid, String name, String sex, String birthday, int grade, int pregrade) {
        studentService.updateExceptAvg(studentid, name, sex, birthday, grade);
        if (grade != pregrade) {
            if (studentService.checkGradesHaveNoZeroScore(grade) == 0) {
                gradeService.updateByGradeidExceptAvg(grade);
            } else {
                gradeService.updateByGradeid(grade);
            }
            if (studentService.checkGradesHaveNoZeroScore(pregrade) == 0 && studentService.checkGradeHaveStudents(pregrade) != 0) {
                gradeService.updateByGradeidExceptAvg(pregrade);
            } else {
                gradeService.updateByGradeid(pregrade);
            }
        }
        return "redirect:studentMain";
    }

    /**
     * 上传（更新）学生照骗
     *
     * @param studentid
     * @param img
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUpload(int studentid, @RequestParam("img") MultipartFile img, HttpServletRequest request) throws IOException {
        if (!img.isEmpty()) {
            long nowtime = System.currentTimeMillis();
            FileUtils.copyInputStreamToFile(img.getInputStream(), new File(request.getSession().getServletContext().getRealPath("Images"), nowtime + img.getOriginalFilename()));
            studentService.updateByStudentidIncludeImg(studentid, nowtime + img.getOriginalFilename());
        }

        return "redirect:updateStudentPrompt?studentid=" + studentid;
    }

    /**
     * 删除学生信息
     *
     * @param studentid
     * @param grade
     * @return
     */
    @RequestMapping(value = "/deleteStudent")
    public String deleteStudent(int studentid, int grade) {

        studentService.delete(studentid);

        /**
         * 对和该学生相关的班级、课程、分数信息进行更新
         */
        List<Integer> subjectids = scoreService.getSubjectidByStudentid(studentid);
        List<Integer> ids = scoreService.getIdByStudentid(studentid);
        if (scoreService.checkStudentHaveSubject(studentid) != 0) {
            for (int id : ids) {
                scoreService.delete(id);
            }
            for (Integer subjectid : subjectids) {
                subjectService.updateBySubjectid(subjectid);
            }
        }
        gradeService.updateByGradeid(grade);
        return "redirect:studentMain";
    }
}
