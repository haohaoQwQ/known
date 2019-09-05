package entity;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/28 20:25
 */
public class Chapter {
    private Integer id;
    private String chapterName;
    private String chapterPath;
    private Integer courseId;
    private List<Video> videos;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", chapterName='" + chapterName + '\'' +
                ", courseId=" + courseId +
                ", videos=" + videos +
                '}';
    }

    public String getChapterPath() {
        return chapterPath;
    }

    public void setChapterPath(String chapterPath) {
        this.chapterPath = chapterPath;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
