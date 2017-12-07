<%--
  Created by IntelliJ IDEA.
  User: xiongcz
  Date: 17-12-4
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>hello struts</title>
    <s:head/>
</head>
<body>
<h1>hello world</h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
<s:form action="from">
    <s:textfield name="username"/>
    <s:submit value="提交"/>
</s:form>

<s:form action="register" method="POST">
    <s:textfield name="user.firstName"/>
    <s:textfield name="user.lastName"/>
    <s:textfield name="user.email"/>
    <s:submit value="提交"/>
</s:form>

<s:property value="user.firstName"></s:property>
<s:property value="user.lastName"></s:property>
<s:property value="user.email"></s:property>
</body>
</html>
