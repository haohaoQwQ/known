package service;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/4 14:57
 */
public interface AdminService {
    //删除用户
    int deleteUserById(Integer id);

    //按条件搜索user
    List<User> searchByCondition(User user);

    //修改用户信息
    int modifyUser(User user);

    //批量删除
    int batchDelete(@Param("ids") List<Integer> ids);
}
