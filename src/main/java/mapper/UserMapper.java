package mapper;

import entity.User;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/21 9:37
 */
public interface UserMapper {
    //查询某个用户信息
    User getUserById(Integer id);

    //查询所有用户信息
    List<User> getUsers();

    //删除用户
    int deleteUserById(Integer id);

    //修改用户
    int updateUser(User user);

    int saveUser(User user);

    //登录判断
    int loginUser(User user);
    //通过用户名查询除密码之外的信息
    User findUserInfoByUsername(String username);

    //修改头像，更新pic
    int updateAvatar(User user);
}
