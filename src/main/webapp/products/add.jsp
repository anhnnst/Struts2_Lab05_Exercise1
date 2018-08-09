<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../common/header.jsp"%>
<h1>Add Or Edit Product</h1>
<hr>
<div class="container">
    <a href="index.action">Home</a>
    <a href="/product/list.action">List Products</a>
    <s:form action="saveOrUpdate" method="POST" validate="true" theme="simple">
        <s:hidden name="idEdit"/>

        <div class="form-group row">
            <s:label for="categoryId" key="product.category" cssClass="col-sm-2 col-form-label"></s:label>
            <s:select list="categories" key="product.category" cssClass="form-control col-sm-10"
                  name="categoryId" listKey="id" listValue="name" />
        </div>
        <div class="form-group row">
            <s:label for="id" key="product.id" cssClass="col-sm-2 col-form-label"></s:label>
            <s:textfield key="product.id" name="id" readonly="true" cssClass="form-control col-sm-10"/>
        </div>
        <div class="form-group row">
            <s:label for="name" key="product.name" cssClass="col-sm-2 col-form-label"></s:label>
            <s:textfield key="product.name" name="name" cssClass="form-control col-sm-10" />
        </div>
        <div class="form-group row">
            <s:label for="quantity" key="product.quantity" cssClass="col-sm-2 col-form-label"></s:label>

            <s:textfield key="product.quantity" name="quantity" cssClass="form-control col-sm-10" />
        </div>
        <div class="form-group row">
            <s:label for="unitPrice" key="product.unit_price" cssClass="col-sm-2 col-form-label"></s:label>

            <s:textfield key="product.unit_price" name="unitPrice" cssClass="form-control col-sm-10" />
        </div>
        <div class="form-group row">
            <s:label for="description" key="product.description" cssClass="col-sm-2 col-form-label"></s:label>

            <s:textfield key="product.description" name="description" cssClass="form-control col-sm-10" />
        </div>

        <s:submit key="category.add" name="" cssClass="btn btn-primary"/>
    </s:form>
</div>
<%@include file="../common/footer.jsp"%>