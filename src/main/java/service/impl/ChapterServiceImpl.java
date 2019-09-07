package service.impl;

import entity.Chapter;
import mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ChapterService;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 9:51
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<Chapter> getChaptersByCourseId(Integer id) {
        return chapterMapper.getChaptersByCourseId(id);
    }

    @Override
    public int addChapter(Chapter chapter) {
        return chapterMapper.addChapter(chapter);
    }

    @Override
    public int deleteChapterById(Integer id) {
        return chapterMapper.deleteChapterById(id);
    }

    @Override
    public int updateChapterInfo(Chapter chapter) {
        return chapterMapper.updateChapterInfo(chapter);
    }

    @Override
    public int batchDeleteChapter(List<Integer> ids) {
        return chapterMapper.batchDeleteChapter(ids);
    }
}
