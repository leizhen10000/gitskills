package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by leizhen on '2017/8/30'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = -965262014458195774L;

    private String message;

    public void init() {
        message = "hello world!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>" + message + "</h1>");
    }
}
