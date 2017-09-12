package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by leizhen on '2017/8/30'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class HelloForm extends HttpServlet {
    private static final long serialVersionUID = 3979971042872363828L;

    public HelloForm() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 为名字和姓氏创建 Cookie
        Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"), "UTF-8"));
        Cookie url = new Cookie("url", URLEncoder.encode(req.getParameter("url")));

        // 设置失效时间
        name.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);

        // 响应中添加 Cookie
        resp.addCookie(name);
        resp.addCookie(url);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String title = "使用 GET 方法读取表单数据";
        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f\"\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<li><b>站点名</b> : " + req.getParameter("name") + "</li>" +
                "<li><b>网址</b> : " + req.getParameter("url") + "</li>" +
                "</ul>\n" +
                "</body></html>");
    }


}
