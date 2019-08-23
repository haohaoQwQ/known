package servlet;


import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import util.GetFileName;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author 刘梦昊 2019/7/22 22:49
 */
@MultipartConfig(maxFileSize = 5765004, fileSizeThreshold = 1000)
@WebServlet(urlPatterns = {"/upload"})
public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Part fileName = request.getPart("avatar");
            //获取头文件信息
            String header = fileName.getHeader("Content-Disposition");
            System.out.println("头文件中的信息为：" + header);
            //获取图片文件名
            String picName = GetFileName.getName(header);
            System.out.println(picName);
            //将图片存在服务器中
            //1.指明存放的路径
            String path = "C:\\D\\known\\images\\avatar";
            System.out.println(path);
            User user = (User) request.getSession().getAttribute("user");
            user.setAvatar(picName);

            //2.存放
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService = webApplicationContext.getBean(UserService.class);
        try {
                fileName.write(path + File.separator + picName);
                userService.updateAvatar(user);
                System.out.println("文件上传成功");
                response.sendRedirect(request.getContextPath()+"/info");
            } catch (IOException e) {
                System.out.println("文件上传失败");
                response.sendRedirect(request.getContextPath()+"/info");
            }

    }
}
