package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Course;
import entity.Teacher;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CourseService;
import service.TeacherService;
import service.UserService;
import util.Msg;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @RequestMapping("/getAllTeachers")
    @ResponseBody
    public Msg getAllTeachers(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 2);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Teacher> teachers = teacherService.getAllTeachers();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(teachers, 3);
        return  Msg.success().add("pageInfo02",page);
    }

    @RequestMapping("/addTeacher")
    @ResponseBody
    public Msg addTeacher(Teacher teacher){
        if(teacherService.saveTeacher(teacher)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/getTeacherInfo")
    @ResponseBody
    public Msg getTeacherInfo(Integer id){
        Teacher teacher=teacherService.findTeacherById(id);
        if(teacher!=null){
            return Msg.success().add("teacher", teacher);
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateTeacherInfo")
    @ResponseBody
    public Msg updateTeacherInfo(Teacher teacher){
        if(teacherService.updateTeacherInfo(teacher)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public Msg deleteTeacher(Integer id){
        if(teacherService.deleteTeacherById(id)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    //批量删除
    @RequestMapping("/batchDeleteTeacher")
    @ResponseBody
    public Msg batchDeleteTeacher(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        teacherService.batchDeleteTeacher(del_ids);
        return  Msg.success();
    }

}
