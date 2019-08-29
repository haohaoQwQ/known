package entity;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 16:04
 */
public class Course {
    private Integer id;
    private String cname;
    private String level;
    private List<Chapter> chapters;
    private String direction;
    private Integer isfress;
    private double price;
    private String pic;
    private Integer courseStatus;
    private Integer tid;
    private Integer focus;
    private String startTime;
    private String time;
    private String introduction;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", level='" + level + '\'' +
                ", chapters=" + chapters +
                ", direction='" + direction + '\'' +
                ", isfress=" + isfress +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", courseStatus=" + courseStatus +
                ", tid=" + tid +
                ", focus=" + focus +
                ", startTime='" + startTime + '\'' +
                ", time='" + time + '\'' +
                ", introduction='" + introduction + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getIsfress() {
        return isfress;
    }

    public void setIsfress(Integer isfress) {
        this.isfress = isfress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
