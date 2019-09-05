package mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/4 14:35
 */
public interface AdminMapper {
    //删除用户
    int deleteUserById(Integer id);

    //按条件搜索user
    List<User> searchByCondition(User user);

    //修改用户信息
    int modifyUser(User user);

    //查询学生id在给定集合中的 测试 id in(1,2,3)foreach拼接
    int batchDelete(@Param("ids") List<Integer> ids);

}
