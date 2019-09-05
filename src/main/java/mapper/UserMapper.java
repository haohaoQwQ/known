package mapper;

import entity.Course;
import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/21 9:37
 */
public interface UserMapper {
    //查询某个用户信息
    User getUserById(Integer id);

    //查询所有用户信息
    List<User> getUsers();



    //修改用户
    int updateUser(User user);

    int saveUser(User user);

    //登录判断
    int loginUser(User user);
    //通过用户名查询除密码之外的信息
    User findUserInfoByUsername(String username);

    //修改头像，更新pic
    int updateAvatar(User user);

    //查询我的课程
    List<Course> selectMyCourses(Integer id);
    //查询我的收藏
    List<Course> selectMyCollects(Integer id);
    //用户是否收藏该课程
    Integer isCollectCourse(@Param("uid") Integer uid,@Param("cid") Integer cid);
    //用户收藏课程
    int userCollectCourse(@Param("uid") Integer uid,@Param("cid") Integer cid);
    //用户取消收藏课程
    int delCollectCourse(@Param("uid") Integer uid,@Param("cid") Integer cid);

    //用户是否已经关注该老师
    Integer isFocusTeacher(@Param("uid") Integer uid,@Param("tid") Integer tid);
    //用户关注该老师
    int userFocusTeacher(@Param("uid") Integer uid, @Param("tid") Integer tid);
    //用户取消关注该老师
    int delFocusTeacher(@Param("uid") Integer uid, @Param("tid") Integer tid);

}
