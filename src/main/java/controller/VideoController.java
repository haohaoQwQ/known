package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ChapterService;
import service.CourseService;
import service.TeacherService;
import service.UserService;

/**
 * @author 刘梦昊 2019/9/7 10:48
 */
@Controller
public class VideoController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    ChapterService chapterService;

}
