<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success" >${ sessionScope.message }</div>
	<c:remove var="message" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-warning" >${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<div class="text-center">
	<h2>Quản Lý Thể Loại</h2>
</div>

<div>
<a class="btn btn-success justify-content-end" href="/category/create">Thêm thể loại</a>
</div>
<c:if test="${ empty lstcategory }">
	<div class="alert alert-warning">
		Không có dữ liệu
	</div>
</c:if>

<c:if test="${ !empty lstcategory }">
<table class="table table-border table-hover table-tripper">
    <thead>
        <tr>
            <th>Tên thể loại</th>
            <th>Tên người tạo</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${ lstcategory }" var="category" >
            <tr>
                <td>${ category.name }</td>
                <td>${ category.account.fullname }</td>
                <td><a class="btn btn-primary" href="/category/edit/${ category.id }">Cập nhật</a></td>
                <td><a class="btn btn-danger" href="/category/delete/${ category.id }">Xóa</a></td>
            </tr>
            </c:forEach>
    </tbody>
</table>
</c:if>