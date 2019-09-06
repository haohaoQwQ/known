package service;

import entity.Chapter;
import entity.Course;
import entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:18
 */
public interface CourseService {
    //添加课程
    int addCourse(Course course);
    //更新课程信息
    int updateCourseInfo(Course course);
    //删除课程
    int deleteCourse(Integer id);
    //批量删除课程
    int batchDeleteCourse(@Param("ids") List<Integer> ids);

    //查询热门推荐课程
    List<Course> findCourseByStatus();
    List<Course> findAllCourses();
    //根据tid查询老师教的所有课程
    List<Course> findCoursesByTid(Integer tid);
    //查询该老师总共教了多少门课
    int countCoursesByTid(Integer tid);
    Course findCourseByCid(Integer cid);

    //根据视频id查询video
    Video findVideoByVid(Integer vid);

    //根据vid查询出chapterId
    int findChapterIdByVid(Integer vid);
    //根据chapterId查询chapter所有信息
    Chapter findChapterById(Integer id);
    //根据chapterId查询courseId
    int findCourseIdByChapterId(Integer chapterId);

    //根据direction查询相关课程
    List<Course> findRelatedCourses(String direction);
}
