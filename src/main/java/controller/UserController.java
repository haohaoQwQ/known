package controller;

import entity.Course;
import entity.Teacher;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.CourseService;
import service.TeacherService;
import service.UserService;
import util.Msg;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/21 9:56
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/")
    public String index(HttpSession session){
        List<Teacher> teachers=teacherService.findTeacherByStatus();
        List<Course> courses=courseService.findCourseByStatus();
        session.setAttribute("teacherlist", teachers);
        session.setAttribute("courselist",courses);
        return "index";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Msg register(User user){
        if (userService.saveUser(user) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/login")
    public String login(User user, String checkCode, HttpSession session, HttpServletRequest request){
        if(userService.loginUser(user)){
           if(userService.checkCode(session, checkCode)){
               User user1=userService.findUserInfoByUsername(user.getUsername());
               session.setAttribute("user", user1);
               System.out.println("登录成功");
               return "index";
           }else {
               request.setAttribute("msg", "验证码输入有误！");
               return "index";
           }
        }else {
            request.setAttribute("msg","用户名或密码错误!");
            System.out.println("登录失败");
            return "index";
        }
    }

    @RequestMapping("/exitLogin")
    public String exitLogin(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("isfocus");
        System.out.println("退出登录");
        return "index";
    }

    @RequestMapping("/info")
    public String info(HttpSession session){
        User user= (User) session.getAttribute("user");
        List<Course> courses=userService.selectMyCourses(user.getId());
        List<Course> courses1=userService.selectMyCollects(user.getId());
        session.setAttribute("mycourses", courses);
        session.setAttribute("mycollects", courses1);
        return "info";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        if(userService.updateUser(user)>0){
            System.out.println("修改用户信息成功！");
            return "index";
        }else {
            System.out.println("修改用户信息失败！");
            return "info";
        }
    }

}
