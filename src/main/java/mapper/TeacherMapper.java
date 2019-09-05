package mapper;

import entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 11:17
 */
public interface TeacherMapper {
    //查询推荐老师
    List<Teacher> findTeacherByStatus();
    //根据id查询老师
    Teacher findTeacherById(Integer id);
    //查询老师的粉丝数
    int countUsersByTid(Integer tid);

    //查询所有老师
    List<Teacher> getAllTeachers();
    //添加老师
    int saveTeacher(Teacher teacher);
    //更新老师信息
    int updateTeacherInfo(Teacher teacher);
    //根据id删除老师
    int deleteTeacherById(Integer id);
    //批量删除老师
    int batchDeleteTeacher(@Param("ids") List<Integer> ids);

}
