<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-warning" >${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

    <form:form action="${ pageContext.request.contextPath }/category/update/${ category.id }" method="post" modelAttribute="category" >
        <div class="card">
            <div class="card-header text-center">
                <p style="font-size: x-large;">Quản lý Thể Loại</p>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="">Tên thể loại</label> 
                    <form:input path="name" class="form-control" name="name" />
                    <form:errors path="name" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Tên người tạo</label> 
                    <form:select path="account.id" cssClass="form-control" >
                    	<form:options items="${ lstaccount }" itemValue="id" itemLabel="fullname" />
                    </form:select>
                </div>
            </div>
            <div class="card-footer text-center">
                <button class="btn btn-success">Sửa</button>
            </div>
        </div>
    </form:form>
