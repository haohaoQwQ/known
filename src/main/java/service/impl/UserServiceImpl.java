package service.impl;

import entity.User;
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
    public boolean loginUser(User user, String checkCode, HttpSession session) {
        //获取后台随机生成的验证码信息
        String picCode= (String) session.getAttribute("picCode");
        if(userMapper.loginUser(user)>0&&picCode.equalsIgnoreCase(checkCode)){
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


}
