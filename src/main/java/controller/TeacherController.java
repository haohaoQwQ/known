package controller;

import entity.Course;
import entity.Teacher;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CourseService;
import service.TeacherService;
import service.UserService;
import util.Msg;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/28 14:44
 */
@Controller
public class TeacherController {
    @Autowired
     UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/teacherInfo")
    public String teacherInfo(Integer tid, HttpSession session, Model model){
        Teacher teacher=teacherService.findTeacherById(tid);
        session.setAttribute("teacher", teacher);
        User user= (User) session.getAttribute("user");
        if(user!=null){
            if(userService.isFocusTeacher(user.getId(), teacher.getId())>0){
                session.setAttribute("isfocus","已关注");
                System.out.println("1");
            }else {
                session.setAttribute("isfocus","关注ta");
                System.out.println("2");
            }
        }
        List<Course> courses=courseService.findCoursesByTid(teacher.getId());
        session.setAttribute("teachercourses", courses);
        int coursetotal=courseService.countCoursesByTid(teacher.getId());
        session.setAttribute("coursetotal", coursetotal);
        int teacherfans=teacherService.countUsersByTid(teacher.getId());
        session.setAttribute("teacherfans", teacherfans);
        return "teacherInfo";
    }

    @RequestMapping("/focusTeacher")
    @ResponseBody
    public Msg focusTeacher(HttpSession session){
        User user= (User) session.getAttribute("user");
        Teacher teacher= (Teacher) session.getAttribute("teacher");
        if(userService.isFocusTeacher(user.getId(), teacher.getId())>0){
            userService.delFocusTeacher(user.getId(), teacher.getId());
            System.out.println("取消关注成功！");
            return Msg.success();
        }else {
            userService.userFocusTeacher(user.getId(), teacher.getId());
            System.out.println("关注成功！");
            return Msg.fail();
        }
    }
}
