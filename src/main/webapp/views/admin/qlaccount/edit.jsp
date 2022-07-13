<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-warning" >${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

    <form:form action="${ pageContext.request.contextPath }/account/update/${ account.id }" method="post" modelAttribute="account" enctype="multipart/form-data" >
        <div class="card">
            <div class="card-header text-center">
                <p style="font-size: x-large;">Quản lý Account</p>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="">Họ tên</label> 
                    <form:input path="fullname" class="form-control" name="fullname" />
                    <form:errors path="fullname" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Tài khoản</label> 
                    <form:input path="username" class="form-control" name="username" />
                    <form:errors path="username" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Email</label> 
                    <form:input path="email" class="form-control" name="email" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Vai Trò </label>
                    <form:radiobutton path="admin" name="admin" value="1" label="Quản lý" />
                    <form:radiobutton path="admin" name="admin" value="0" label="Khách hàng" />
                </div>
                <div class="form-group">
                    <label for="">Hình ảnh</label> 
                    <input class="form-control" type="file" name="photo_file" value="${ account.photo }" placeholder="Vui lòng chọn hình ảnh">
                    <img src="${ pageContext.request.contextPath }/img/${account.photo}" width="150px" height="150px" >
                </div>
            </div>
            <div class="card-footer text-center">
                <button class="btn btn-success">Sửa</button>
            </div>
        </div>
    </form:form>
