package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class CourseController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @RequestMapping("/allcourses")
    public String allCoureses(HttpSession session){
        List<Course> courses=courseService.findAllCourses();
        session.setAttribute("courselist", courses);
        return "course";
    }

    @RequestMapping("/courseDisplay")
    public String courseDisplay(Integer cid,HttpSession session){
        Course course=courseService.findCourseByCid(cid);
        User user= (User) session.getAttribute("user");
        if(user!=null){
            if(userService.isCollectCourse(user.getId(), course.getId())>0){
                session.setAttribute("isCollect", "yes");
            }
        }
        session.setAttribute("course", course);
        return "courseDisplay";
    }

    @RequestMapping("/collectCourse")
    @ResponseBody
    public Msg collectCourse(HttpSession session){
        User user= (User) session.getAttribute("user");
        Course course= (Course) session.getAttribute("course");
        if(userService.isCollectCourse(user.getId(), course.getId())>0){
            System.out.println("取消收藏成功");
            userService.delCollectCourse(user.getId(), course.getId());
            return Msg.success();
        }else {
            System.out.println("收藏成功");
            userService.userCollectCourse(user.getId(), course.getId());
            return Msg.fail();
        }
    }

    @RequestMapping("/delCollectCourse")
    public String delCollectCourse(HttpSession session,Integer cid){
        User user= (User) session.getAttribute("user");
        Course course=courseService.findCourseByCid(cid);
        userService.delCollectCourse(user.getId(), course.getId());
        List<Course> courses=userService.selectMyCollects(user.getId());
        session.setAttribute("mycollects", courses);
        return "info";
    }

    @RequestMapping("/video")
    public String video(HttpSession session,Integer vid){
        System.out.println(vid);
        Video video=courseService.findVideoByVid(vid);
        int chapterId=courseService.findChapterIdByVid(vid);
        int course_id=courseService.findCourseIdByChapterId(chapterId);
        Chapter chapter=courseService.findChapterById(chapterId);
        Course course=courseService.findCourseByCid(course_id);
        String videoPath=course.getDirection()+"/"+course.getCoursePath()+"/"+chapter.getChapterPath()+"/"+video.getVideoPath()+".mp4";
        List<Course> courses=courseService.findCourseByStatus();
        List<Course> courses1=courseService.findRelatedCourses(course.getDirection());
        session.setAttribute("videoPath", videoPath);
        session.setAttribute("video", video);
        session.setAttribute("hotcourses", courses);
        session.setAttribute("commendcourses", courses1);
        return "video";
    }

    @RequestMapping("/getAllCourses")
    @ResponseBody
    public Msg getAllCourses(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 3);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Course> courses = courseService.findAllCourses();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(courses, 3);
        return  Msg.success().add("pageInfo03",page);
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public Msg addCourse(Course course){
        if(courseService.addCourse(course)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/getCourseInfo")
    @ResponseBody
    public Msg getCourseInfo(Integer id){
        Course course=courseService.findCourseByCid(id);
        if(course!=null){
            return Msg.success().add("course", course);
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateCourseInfo")
    @ResponseBody
    public Msg updateCourseInfo(Course course){
        if(courseService.updateCourseInfo(course)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public Msg deleteCourse(Integer id){
        if(courseService.deleteCourse(id)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDeleteCourse")
    @ResponseBody
    public Msg batchDeleteCourse(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        courseService.batchDeleteCourse(del_ids);
        return  Msg.success();
    }

}
