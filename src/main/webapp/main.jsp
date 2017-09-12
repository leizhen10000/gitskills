<%--
  Created by GrayHouse.
  User: 
  Date: 2017/9/9
  Time: 21:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>使用 JavaBean</title>
</head>
<body>
<h2>include 动作实例</h2>
<jsp:include page="date.jsp" flush="true"/>

<jsp:useBean id="test" class="com.leizhen.cn.TestBean"/>

<jsp:setProperty name="test" property="message" value="java bean 引入"/>

<p>输出信息</p>
<jsp:getProperty name="test" property="message"/>

<h2>forward 跳转</h2>
<jsp:forward page="date.jsp"/>

<%

%>

</body>
</html>
