package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leizhen on '2017/9/6'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class RefreshTime extends HttpServlet {
    private static final long serialVersionUID = -8944080153412462110L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setIntHeader("refresh", 5);

        // 使用默认时区和语言环境获得一个日历
        Calendar calendar = Calendar.getInstance();
        // 将 calendar 转换成 Date 类型
        Date taskTime = calendar.getTime();
        // 设置日志输出格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 格式化输出
        String nowTime = sdf.format(taskTime);

        PrintWriter writer = resp.getWriter();
        String title = "自动刷新 Header 设置";
        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<p>当前时间是" + nowTime + "</p>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
