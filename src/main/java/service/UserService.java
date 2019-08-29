package service;

import entity.Course;
import entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/21 9:36
 */
public interface UserService {
    // 查询某个用户
    User getUserById(Integer id);
    // 查询所有用户信息
    List<User> getUsers();
    // 删除用户
    int deleteUserById(Integer id);
    // 修改
    int updateUser(User user);

    int saveUser(User user);

    boolean loginUser(User user);

    boolean checkCode(HttpSession session,String checkCode);

    //通过用户名查询除密码之外的信息
    User findUserInfoByUsername(String username);

    //修改头像
    int updateAvatar(User user);

    //查询我的课程
    List<Course> selectMyCourses(Integer id);
    //查询我的收藏
    List<Course> selectMyCollects(Integer id);

    //用户是否收藏该课程
    Integer isCollectCourse(Integer uid,Integer cid);
    //用户收藏课程
    int userCollectCourse(Integer uid,Integer cid);
    //用户取消收藏课程
    int delCollectCourse(Integer uid,Integer cid);

    //是否已经关注该老师
    int isFocusTeacher(Integer uid,Integer tid);
    //关注老师
    int userFocusTeacher(Integer uid,Integer tid);
    //取消关注该老师
    int delFocusTeacher(Integer uid,Integer tid);
}
