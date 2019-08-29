package controller;

import entity.Chapter;
import entity.Course;
import entity.User;
import entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        String videoPath=course.getDirection()+"/"+course.getCname()+"/"+chapter.getChapterName()+"/"+video.getVideoName()+".mp4";
        List<Course> courses=courseService.findCourseByStatus();
        List<Course> courses1=courseService.findRelatedCourses(course.getDirection());
        session.setAttribute("videoPath", videoPath);
        session.setAttribute("video", video);
        session.setAttribute("hotcourses", courses);
        session.setAttribute("commendcourses", courses1);
        return "video";
    }

}
