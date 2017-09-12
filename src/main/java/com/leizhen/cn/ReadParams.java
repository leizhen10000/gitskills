package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by leizhen on '2017/9/6'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class ReadParams extends HttpServlet {

    private static final long serialVersionUID = 4111364787350046428L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title = "读取所有的表单数据";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        writer.println(docType +
                "<html>\n" +
                "<head><meat charset = \"utf-8\"><title>"
                + title + "</title></head>\n" +
                "<bocy bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>参数名称</th>" +
                "<th>参数值</th>\n" +
                "</tr>\n");

        Enumeration paramNames = req.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            writer.print("<tr><td>" + paramName + "</td>\n");
            String[] paramValues = req.getParameterValues(paramName);
            // 读取单个值的数据
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    writer.println("<td><i>没有值</i></td>");
                } else {
                    writer.println("<td>" + paramValue + "</td>");
                }
            } else {
                // 读取多个值
                writer.println("<td><ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    writer.println("<li>" + paramValues[i]);
                }
                writer.println("</ul></td>");
            }
            writer.println("</tr>");
        }
        writer.println("\n</table>\n</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
