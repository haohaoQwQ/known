package entity;

/**
 * @author 刘梦昊 2019/8/21 9:31
 */
public class User {
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String address;
    private String avatar;
    private String studyDirection;
    private String phone;
    private String email;
    private String motto;
    private int account;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", studyDirection='" + studyDirection + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStudyDirection() {
        return studyDirection;
    }

    public void setStudyDirection(String studyDirection) {
        this.studyDirection = studyDirection;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
