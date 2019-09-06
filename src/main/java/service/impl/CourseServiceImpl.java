package service.impl;

import entity.Chapter;
import entity.Course;
import entity.Teacher;
import entity.Video;
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
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateCourseInfo(course);
    }

    @Override
    public int deleteCourse(Integer id) {
        return courseMapper.deleteCourse(id);
    }

    @Override
    public int batchDeleteCourse(List<Integer> ids) {
        return courseMapper.batchDeleteCourse(ids);
    }

    @Override
    public List<Course> findCourseByStatus() {
        List<Course> courses=courseMapper.findCourseByStatus();
        //遍历课程集合，找到课程对应的老师，章节，进行赋值
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            List<Chapter> chapters=courseMapper.findChaptersByCid(course.getId());
            //遍历章节集合,给各个章节赋值videos
            for (int j=0;j<chapters.size();j++){
                Chapter chapter=chapters.get(j);
                List<Video> videos=courseMapper.findVideosById(chapter.getId());
                chapter.setVideos(videos);
            }
            course.setTeacher(teacher);
            course.setChapters(chapters);
        }
        return courses;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses=courseMapper.findAllCourses();
        //遍历课程集合，找到课程对应的老师，章节，进行赋值
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            List<Chapter> chapters=courseMapper.findChaptersByCid(course.getId());
            for(int j=0;j<chapters.size();j++){
                Chapter chapter=chapters.get(j);
                List<Video> videos=courseMapper.findVideosById(chapter.getId());
                chapter.setVideos(videos);
            }
            course.setTeacher(teacher);
            course.setChapters(chapters);
        }
        return courses;
    }

    @Override
    public List<Course> findCoursesByTid(Integer tid) {
        List<Course> courses=courseMapper.findCoursesByTid(tid);
        //遍历课程集合，找到课程对应章节，进行赋值
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            List<Chapter> chapters=courseMapper.findChaptersByCid(course.getId());
            for(int j=0;j<chapters.size();j++){
                Chapter chapter=chapters.get(j);
                List<Video> videos=courseMapper.findVideosById(chapter.getId());
                chapter.setVideos(videos);
            }
            course.setChapters(chapters);
        }
        return courses;
    }

    @Override
    public int countCoursesByTid(Integer tid) {
        return courseMapper.countCoursesByTid(tid);
    }

    @Override
    public Course findCourseByCid(Integer cid) {
        Course course=courseMapper.findCourseByCid(cid);
        List<Chapter> chapters=courseMapper.findChaptersByCid(course.getId());
        for(int j=0;j<chapters.size();j++){
            Chapter chapter=chapters.get(j);
            List<Video> videos=courseMapper.findVideosById(chapter.getId());
            chapter.setVideos(videos);
        }
        course.setChapters(chapters);
        return course;
    }

    @Override
    public Video findVideoByVid(Integer vid) {
        return courseMapper.findVideoByVid(vid);
    }

    @Override
    public int findChapterIdByVid(Integer vid) {
        return courseMapper.findChapterIdByVid(vid);
    }

    @Override
    public Chapter findChapterById(Integer id) {
        return courseMapper.findChapterById(id);
    }

    @Override
    public int findCourseIdByChapterId(Integer chapterId) {
        return courseMapper.findCourseIdByChapterId(chapterId);
    }

    @Override
    public List<Course> findRelatedCourses(String direction) {
        return courseMapper.findRelatedCourses(direction);
    }


}
