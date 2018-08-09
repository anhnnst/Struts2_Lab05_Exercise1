<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<h1>Add Or Edit Category</h1>
<hr>
<div>
    <s:actionerror/>
    <s:form action="/category/saveOrUpdate" method="POST" validate="true">
        <s:textfield key="category.id" name="id" readonly="true"/>
        <s:textfield key="category.name" name="name"/>
        <s:hidden name="idEdit"/>
        <s:submit key="category.add" name=""/>
    </s:form>

    <hr>
    <a href="/index.action">Home</a>
    <a href="/category/list.action">List Categories</a>
</div>
</body>
</html>