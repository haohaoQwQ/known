package mapper;

import entity.Teacher;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/22 11:17
 */
public interface TeacherMapper {
    //查询推荐老师
    List<Teacher> findTeacherByStatus();
    //根据id查询老师
    Teacher findTeacherById(Integer id);
}
