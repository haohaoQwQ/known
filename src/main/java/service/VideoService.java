package service;

import entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 10:57
 */
public interface VideoService {
    //根据章节id查询该课程所有视频
    List<Video> getVideosByChapterId(Integer id);
    //添加视频
    int addVideo(Video video);
    //删除视频
    int deleteVideoById(Integer id);
    //更新视频
    int updateVideoInfo(Video video);
    //批量删除视频
    int batchDeleteVideo(@Param("ids") List<Integer> ids);
}
