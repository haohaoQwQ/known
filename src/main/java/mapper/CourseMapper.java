package mapper;

import entity.Course;
import entity.Teacher;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:04
 */
public interface CourseMapper {
    //查询推荐课程
    List<Course> findCourseByStatus();
    //查询所有课程
    List<Course> findAllCourses();
}
