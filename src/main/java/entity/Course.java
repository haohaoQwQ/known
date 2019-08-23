package entity;

/**
 * @author 刘梦昊 2019/8/22 16:04
 */
public class Course {
    private String cname;
    private String video;
    private String chapter;
    private Integer directionId;
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
                "cname='" + cname + '\'' +
                ", video='" + video + '\'' +
                ", chapter='" + chapter + '\'' +
                ", directionId=" + directionId +
                ", isfress=" + isfress +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", courseStatus=" + courseStatus +
                ", tid=" + tid +
                ", focus=" + focus +
                ", startTime='" + startTime + '\'' +
                ", time='" + time + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
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
