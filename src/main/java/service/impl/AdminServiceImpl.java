package service.impl;

import entity.User;
import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService;

import java.util.List;

/**
 * @author 刘梦昊 2019/9/4 14:57
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public int deleteUserById(Integer id) {
        return adminMapper.deleteUserById(id);
    }

    @Override
    public List<User> searchByCondition(User user) {
        return adminMapper.searchByCondition(user);
    }

    @Override
    public int modifyUser(User user) {
        return adminMapper.modifyUser(user);
    }

    @Override
    public int batchDelete(List<Integer> ids) {
        return adminMapper.batchDelete(ids);
    }
}
