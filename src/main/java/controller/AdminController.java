package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.User;
import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import service.AdminService;
import service.CourseService;
import service.TeacherService;
import service.UserService;
import util.Msg;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘梦昊 2019/8/30 14:18
 */
@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin")
    public String admin(){
        return "admin/admin";
    }
    @RequestMapping("/adminExitLogin")
    public String exit(HttpSession session){
        session.removeAttribute("admin");
        return "index";
    }
    @RequestMapping("/userManagement")
    public String userManagement(){
        return "admin/userManagement";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public Msg getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 3);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<User> users = userService.getUsers();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(users, 3);
        return  Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Msg deleteUser(Integer id){
        if (adminService.deleteUserById(id)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }

    @RequestMapping("editUser")
    @ResponseBody
    public Msg edit(Integer id){
        User user=userService.getUserById(id);
        if (user!=null) {
            return Msg.success().add("user",user);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/modifyUser")
    @ResponseBody
    public Msg modifyUser(User user){
        if(adminService.modifyUser(user)>0){
            return Msg.success();
        }
        return Msg.fail();
    }

    //批量删除
    @RequestMapping("/batchDelete")
    @ResponseBody
    public Msg batchDelete(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        adminService.batchDelete(del_ids);
        return  Msg.success();
    }

    @RequestMapping("searchByCondition")
    public String searchByCondition(User user,HttpSession session){
        List<User> users=adminService.searchByCondition(user);
        session.setAttribute("userlist", users);
        return "admin/userManagement";
    }

    @RequestMapping("/teacherManagement")
    public String teacherManagement(){
        return "admin/teacherManagement";
    }

    @RequestMapping("/courseManagement")
    public String courseManagement(){
        return "admin/courseManagement";
    }

    @RequestMapping("/chapterManagement")
    public String chapterManagement(){
        return "admin/chapterManagement";
    }

    @RequestMapping("/videoManagement")
    public String videoManagement(){
        return "admin/videoManagement";
    }

    @RequestMapping("/commentManagement")
    public String commentManagement(){
        return "admin/commentManagement";
    }

    @RequestMapping("/orderManagement")
    public String orderManagement(){
        return "admin/orderManagement";
    }

    @RequestMapping("/rechargeManagement")
    public String rechargeManagement(){
        return "admin/rechargeManagement";
    }

}
