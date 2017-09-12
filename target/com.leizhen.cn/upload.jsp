<%@ page import="java.util.Date" %><%--
  Created by GrayHouse.
  User: 
  Date: 2017/9/8
  Time: 16:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传实例</h1>

<%!
    private int intVar = 0;
    private int serviceVar = 0;
    private int destoryVar = 0;
%>

<%!
    public void jspInit() {
        intVar++;
        System.out.println("jspInit(): JSP 被初始化了" + intVar + "次");
    }

    public void jspDestory() {
        destoryVar++;
        System.out.println("jspDestory(): JSP 被销毁了" + destoryVar + "次");
    }
%>

<%
    serviceVar++;
    System.out.println("_jspService(): JSP 共响应了" + serviceVar + "次");

    String content1 = "初始化次数:" + intVar;
    String content2 = "响应客户请求次数:" + serviceVar;
    String content3 = "销毁次数:" + destoryVar;
%>

<h1>菜鸟教程 JSP 测试实例</h1>
<p><%=content1%>
</p>
<p><%=content2%>
</p>
<p><%=content3%>
</p>
<p>
    今天的日期是：<%=(new Date())%>
</p>

<% for (int fontSize = 0; fontSize < 4; fontSize++) {%>
<font color="#696969" size="<%=fontSize%>"></font><br/>
<%}%>
</body>
</html>
