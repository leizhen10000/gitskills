package com.leizhen.cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leizhen on '2017/9/8'.
 * code is far away from bugs with the god animal protecting
 * I love animals. They taste delicious.
 */
public class SessionTrack extends HttpServlet {
    private static final long serialVersionUID = -1215714549990737085L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果不存在 session 会话，则创建一个 session 对象
        HttpSession session = req.getSession(true);
        // 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
        // 获取该网页最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String title = "Servlet Session 实例";
        Integer visitCount = new Integer(0);
        String userIdKey = "userId";
        String userId = "leizhen";
        String visitCountKey = "visitCount";

        session.setAttribute(visitCountKey, 0);

        // 检查网页上是否有新的访问者
        if (session.isNew()) {
            session.setAttribute(userIdKey, userId);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            if (visitCount != null) {
                visitCount = visitCount + 1;
            }
            userId = (String) session.getAttribute(userIdKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        // 设置响应类型
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String docType = "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session 信息</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"3949494\">\n" +
                "<th>Session 信息</th><th>值</th>" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>id</td>\n" +
                "<td>" + session.getId() + "</td>" +
                "</tr>\n" +
                "<tr>" +
                "<td>创建时间</td>\n" +
                "<td>" + sdf.format(createTime) + "</td>\n" +
                "</tr>\n" +
                "<tr>" +
                "<td>最后访问时间</td>\n" +
                "<td>" + sdf.format(lastAccessTime) + "</td>\n" +
                "</tr>\n" +
                "<tr>" +
                "<td>用户 ID</td>\n" +
                "<td>" + userId + "</td>\n" +
                "</tr>\n" +
                "<tr>" +
                "<th>访问统计：</th>\n" +
                "<th>" + visitCount + "</th>\n" +
                "</tr>\n" +
                "</table>" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
