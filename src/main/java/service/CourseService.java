package service;

import entity.Course;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:18
 */
public interface CourseService {
    List<Course> findCourseByStatus();
    List<Course> findAllCourses();
}
