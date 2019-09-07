package mapper;

import entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 9:52
 */
public interface ChapterMapper {
    //根据课程id查询该课程所有章节
    List<Chapter> getChaptersByCourseId(Integer id);
    //添加章节
    int addChapter(Chapter chapter);
    //删除章节
    int deleteChapterById(Integer id);
    //更新章节
    int updateChapterInfo(Chapter chapter);
    //批量删除章节
    int batchDeleteChapter(@Param("ids") List<Integer> ids);
}
