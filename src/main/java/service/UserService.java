package service;

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

    boolean loginUser(User user, String checkCode, HttpSession session);

    //通过用户名查询除密码之外的信息
    User findUserInfoByUsername(String username);

    //修改头像
    int updateAvatar(User user);
}
