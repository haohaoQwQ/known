package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 刘梦昊 2019/7/26 15:42
 */
@WebServlet(urlPatterns = {"/ImageServlet"})
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.画一个图片外框
        BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.getGraphics();
        Color c=new Color(200,150,255);
        g.setColor(c);
        g.fillRect(0,0,68,22);
        //2.添加图片内容
        char[]ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r=new Random();
        int len=ch.length,index;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++){
            index=r.nextInt(len);
            //随机获取一个颜色
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            //画一个字符串
            g.drawString(ch[index]+"",(i*15)+3,18);
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("picCode",sb.toString());
        ImageIO.write(bi,"JPG",response.getOutputStream());
    }
}
