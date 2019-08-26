package service.impl;

import entity.Course;
import entity.Teacher;
import entity.User;
import mapper.TeacherMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/21 9:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public boolean loginUser(User user) {
        if(userMapper.loginUser(user)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean checkCode(HttpSession session, String checkCode) {
        //获取后台随机生成的验证码信息
        String picCode= (String) session.getAttribute("picCode");
        if(picCode.equalsIgnoreCase(checkCode)){
            return true;
        }else {
            return false;
        }

    }


    @Override
    public User findUserInfoByUsername(String username) {
        return userMapper.findUserInfoByUsername(username);
    }

    @Override
    public int updateAvatar(User user) {
        return userMapper.updateAvatar(user);
    }

    @Override
    public List<Course> selectMyCourses(Integer id) {
        List<Course> courses=userMapper.selectMyCourses(id);
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            course.setTeacher(teacher);
        }
        return courses;
    }

    @Override
    public List<Course> selectMyCollects(Integer id) {
        List<Course> courses=userMapper.selectMyCollects(id);
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            Teacher teacher=teacherMapper.findTeacherById(course.getTid());
            course.setTeacher(teacher);
        }
        return courses;
    }


}
