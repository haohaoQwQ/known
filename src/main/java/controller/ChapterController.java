package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Chapter;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ChapterService;
import service.CourseService;
import service.TeacherService;
import service.UserService;
import util.Msg;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 9:46
 */
@Controller
public class ChapterController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    ChapterService chapterService;

    @RequestMapping("/getChapters")
    @ResponseBody
    public Msg getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn,Integer courseId){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 3);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Chapter> chapters= chapterService.getChaptersByCourseId(courseId);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(chapters, 3);
        return  Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/addChapter")
    @ResponseBody
    public Msg addChapter(Chapter chapter, HttpSession session){
        if(chapterService.addChapter(chapter)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/getChapterInfo")
    @ResponseBody
    public Msg getChapterInfo(Integer id){
        Chapter chapter=chapterService.getChapterInfo(id);
        if(chapter!=null){
            return Msg.success().add("chapter", chapter);
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateChapterInfo")
    @ResponseBody
    public Msg updateChapterInfo(Chapter chapter){
        if(chapterService.updateChapterInfo(chapter)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteChapter")
    @ResponseBody
    public Msg deleteChapter(Integer id){
        if(chapterService.deleteChapterById(id)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    //批量删除
    @RequestMapping("/batchDeleteChapter")
    @ResponseBody
    public Msg batchDeleteChapter(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        chapterService.batchDeleteChapter(del_ids);
        return Msg.success();
    }
}
