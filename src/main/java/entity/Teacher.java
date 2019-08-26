package entity;

/**
 * @author 刘梦昊 2019/8/22 11:20
 */
public class Teacher {
    private Integer id;
    private String tname;
    private String major;
    private String introduction;
    private Integer teacherStatus;
    private String avatar;

    @Override
    public String toString() {
        return "Teacher{" +
                "tname='" + tname + '\'' +
                ", major='" + major + '\'' +
                ", introduction='" + introduction + '\'' +
                ", teacherStatus=" + teacherStatus +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Integer teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
