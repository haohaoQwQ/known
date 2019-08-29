package mapper;

import entity.Chapter;
import entity.Course;
import entity.Teacher;
import entity.Video;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:04
 */
public interface CourseMapper {
    //查询推荐课程
    List<Course> findCourseByStatus();
    //查询所有课程
    List<Course> findAllCourses();
    //根据tid查询老师教的所有课程
    List<Course> findCoursesByTid(Integer tid);
    //查询该老师总共教了多少门课
    int countCoursesByTid(Integer tid);
    Course findCourseByCid(Integer cid);

    //根据课程id查询课程所有章节
    List<Chapter> findChaptersByCid(Integer cid);
    //根据章节id查询该章节所有小节视频
    List<Video> findVideosById(Integer id);
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
