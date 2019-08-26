package service;

import entity.Course;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:18
 */
public interface CourseService {
    List<Course> findCourseByStatus();
    List<Course> findAllCourses();
    //根据tid查询老师教的所有课程
    List<Course> findCoursesByTid(Integer tid);
    //查询该老师总共教了多少门课
    int countCoursesByTid(Integer tid);
}
