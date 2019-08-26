package service;

import entity.Teacher;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 14:13
 */
public interface TeacherService {
    //查询推荐老师
    List<Teacher> findTeacherByStatus();
    //根据id查询老师
    Teacher findTeacherById(Integer id);
    //查询老师的粉丝数
    int countUsersByTid(Integer tid);
}
