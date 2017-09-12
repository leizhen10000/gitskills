package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.WeakHashMap;

/**
 * Created by leizhen on '2017/9/7'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class ErrorHandler extends HttpServlet {
    private static final long serialVersionUID = 9011889519281216598L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "servlet 设置异常";

        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1>异常过滤</h1>");

        if (throwable == null && statusCode == null) {
            writer.println("<h2>错误信息丢失</h2>");
            writer.println("请放回<a href=\"" + resp.encodeURL("http://www.google.com") + "\"" +
                    ">主页</a>。");
        } else if (statusCode != null) {
            writer.println("代码错误： " + statusCode);
        } else {
            writer.println("<h2>信息错误</h2>");
            writer.println("Servlet name " + servletName + "</br></br>");
            writer.println("异常类型: " + throwable.getClass().getName() + "</br></br>");
            writer.println("请求 URI: " + requestUri + "</br></br>");
            writer.println("异常信息: " + throwable.getMessage());
        }
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
