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
<div>
    <h1>List Categories</h1>
    <div style="margin-top: 40px;">
        <s:if test="noData==false">
            <table>
                <thead>
                <tr style="background-color: #E0E0E1;">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <s:iterator value="categories">
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="name" /></td>
                        <td>
                            <a href="/category/addOrEdit.action?idEdit=<s:property value="id"/>">
                                <button class="button-update">Update</button>
                            </a>
                            <a href="/category/delete.action?idEdit=<s:property value="id"/>">
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
        <a href="/category/addOrEdit.action">Add New Category</a>
    </div>
</body>
</html>