package service.impl;

import entity.Teacher;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TeacherService;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 14:15
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findTeacherByStatus() {
        return teacherMapper.findTeacherByStatus();
    }

    @Override
    public Teacher findTeacherById(Integer id) {
        return teacherMapper.findTeacherById(id);
    }

    @Override
    public int countUsersByTid(Integer tid) {
        return teacherMapper.countUsersByTid(tid);
    }
}
