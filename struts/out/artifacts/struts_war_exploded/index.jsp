<%--
  Created by IntelliJ IDEA.
  User: sunqipeng
  Date: 11-8-11
  Time: 上午10:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ss" uri="/struts-tags" %>
<html>
<head><title>Simple jsp page</title><ss:url value="/" var="url"></ss:url>
    <style type="text/css" dir="${url}/aaaaa.jsp"></style>
</head>
<body>Place your content here

<ss:form action="index">
    <ss:textfield name="name" label="测试" labelposition="left">

    </ss:textfield>

    <a href="${url}">
        <ss:text name="hello"></ss:text>
    </a>
    <ss:text name="appname"></ss:text>
    <ss:text name="hello"></ss:text>
    <ss:select list="{1,2,3,4,5,6,7,8}" label="选择年级" multiple="true" size="5" name="hello2"></ss:select>
    <ss:radio list="{1,2,3,4,5,6,7,8,9}" label="Please Select on" name="hello3"></ss:radio>
    <ss:checkboxlist list="{1,2,3,4,5,6,7,8,9}" name="hello5"></ss:checkboxlist>
    <ss:textarea rows="20" cols="40" label="简历信息" name="hello4"></ss:textarea>
    <ss:submit value="提交"></ss:submit>
</ss:form>
</body>
</html>