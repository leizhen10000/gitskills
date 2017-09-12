package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by leizhen on '2017/9/7'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class ReadCookies extends HttpServlet {
    private static final long serialVersionUID = -3595395309825195493L;

    public ReadCookies() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = req.getCookies();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String title = "Delete Cookie Example";
        String docType = "<!DOCTYPE html>\n";

        writer.println(docType +
                "<html>\n" +
                "<head><html>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if (cookies != null) {
            writer.println("<h2>Cookie 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().compareTo("name") == 0) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    writer.println("已删除的 cookie ：" + cookie.getName() + "<br/>");
                }
                writer.println("名称： " + cookie.getName() + ",");
                writer.println("值 ： " + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br/>");
            }
        } else {
            writer.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
        }

        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
