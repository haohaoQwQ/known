package service;

import entity.Teacher;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 14:13
 */
public interface TeacherService {
    List<Teacher> findTeacherByStatus();
}
