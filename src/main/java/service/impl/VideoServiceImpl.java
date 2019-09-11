package service.impl;

import entity.Video;
import mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.VideoService;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 10:57
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> getVideosByChapterId(Integer id) {
        return videoMapper.getVideosByChapterId(id);
    }

    @Override
    public int addVideo(Video video) {
        return videoMapper.addVideo(video);
    }

    @Override
    public Video getVideoInfo(Integer id) {
        return videoMapper.getVideoInfo(id);
    }

    @Override
    public int deleteVideoById(Integer id) {
        return videoMapper.deleteVideoById(id);
    }

    @Override
    public int updateVideoInfo(Video video) {
        return videoMapper.updateVideoInfo(video);
    }

    @Override
    public int batchDeleteVideo(List<Integer> ids) {
        return videoMapper.batchDeleteVideo(ids);
    }
}
