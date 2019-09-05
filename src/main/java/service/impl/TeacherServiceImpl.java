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

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }

    @Override
    public int saveTeacher(Teacher teacher) {
        return teacherMapper.saveTeacher(teacher);
    }

    @Override
    public int updateTeacherInfo(Teacher teacher) {
        return teacherMapper.updateTeacherInfo(teacher);
    }

    @Override
    public int deleteTeacherById(Integer id) {
        return teacherMapper.deleteTeacherById(id);
    }

    @Override
    public int batchDeleteTeacher(List<Integer> ids) {
        return teacherMapper.batchDeleteTeacher(ids);
    }
}
