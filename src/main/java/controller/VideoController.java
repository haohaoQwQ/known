package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Chapter;
import entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.*;
import util.Msg;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘梦昊 2019/9/7 10:48
 */
@Controller
public class VideoController {
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    VideoService videoService;

    @RequestMapping("/getVideos")
    @ResponseBody
    public Msg getVideos(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Integer chapterId){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 3);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Video> videos=videoService.getVideosByChapterId(chapterId);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(videos, 3);
        return  Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/addVideo")
    @ResponseBody
    public Msg addVideo(Video video, HttpSession session){
        if(videoService.addVideo(video)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/getVideoInfo")
    @ResponseBody
    public Msg getVideoInfo(Integer id){
        Video video=videoService.getVideoInfo(id);
        if(video!=null){
            return Msg.success().add("video",video);
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateVideoInfo")
    @ResponseBody
    public Msg updateVideoInfo(Video video){
        if(videoService.updateVideoInfo(video)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteVideo")
    @ResponseBody
    public Msg deleteVideo(Integer id){
        if(videoService.deleteVideoById(id)>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    //批量删除
    @RequestMapping("/batchDeleteVideo")
    @ResponseBody
    public Msg batchDeleteVideo(String ids){
        //批量删除
        List<Integer> del_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            del_ids.add(Integer.parseInt(string));
        }
        videoService.batchDeleteVideo(del_ids);
        return Msg.success();
    }

    /*@ResponseBody
    @RequestMapping("/recordVideoTime")
    public void recordVideoTime(double time, HttpServletRequest request) {
        int videoId = (int) request.getSession().getAttribute("videoId");
        User user = (User) request.getSession().getAttribute("user");
        courseService.updateVideoHistory(user.getId(), videoId, time);
    }*/
}
