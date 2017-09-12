package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by leizhen on '2017/8/31'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class CheckBox extends HttpServlet {

    private static final long serialVersionUID = 4635109541337661312L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String title = "读取复选框数据";
        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "   <li><b>Google 标识:</b>:" +
                req.getParameter("google") + "\n" +
                "   <li><b>taobao 标识：</b>:" +
                req.getParameter("taobao") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
