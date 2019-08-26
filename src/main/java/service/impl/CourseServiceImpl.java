package service.impl;

import entity.Course;
import entity.Teacher;
import mapper.CourseMapper;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:19
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Course> findCourseByStatus() {
        List<Course> courses=courseMapper.findCourseByStatus();
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            course.setTeacher(teacher);
        }
        return courses;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses=courseMapper.findAllCourses();
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            course.setTeacher(teacher);
        }
        return courses;
    }

    @Override
    public List<Course> findCoursesByTid(Integer tid) {
        return courseMapper.findCoursesByTid(tid);
    }

    @Override
    public int countCoursesByTid(Integer tid) {
        return courseMapper.countCoursesByTid(tid);
    }
}
