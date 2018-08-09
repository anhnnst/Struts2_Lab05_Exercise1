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
<a href="index.action">Home</a>
<h1>List Products</h1>

<div style="margin-top: 40px;">
<s:if test="noData==false">
    <table>
        <thead>
        <tr style="background-color: #E0E0E1;">
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Category ID</th>
            <th>Category Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <s:iterator value="products">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="quantity"/></td>
                <td><s:property value="unitPrice"/></td>
                <td><s:property value="category.id"/></td>
                <td><s:property value="category.name"/></td>
                <td>
                    <a href='/product/addOrEdit.action?idEdit=<s:property value="id"/>'>
                        <button class="button-update">Edit</button>
                    </a>
                    <a href='/product/delete.action?idEdit=<s:property value="id"/>'>
                        <button class="button-delete">Delete</button>
                    </a>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>
<s:else>
    <div style="color: red;">No Data Found.</div>
</s:else>
<hr>
<a href="/index.action">Home</a>
<a href="/product/addOrEdit.action">Add New Product</a>
</div>
</body>
</html>