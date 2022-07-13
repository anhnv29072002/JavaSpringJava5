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
	<h2>Quản Lý Account</h2>
</div>
<div>
<a class="btn btn-success justify-content-end" href="/account/create">Thêm tài khoản</a>
</div>
<c:if test="${ empty lstaccount }">
	<div class="alert alert-warning">
		Không có dữ liệu
	</div>
</c:if>

<c:if test="${ !empty lstaccount }">
<table class="table table-border table-hover table-tripper">
    <thead>
        <tr>
            <th>Họ tên</th>
            <th>Tài khoản</th>
            <th>Email</th>
            <th>Vai trò</th>
            <th>Avatar</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${ lstaccount }" var="account" >
            <tr>
                <td>${ account.fullname }</td>
                <td>${ account.username }</td>
                <td>${ account.email }</td>
                <td>
                	${ account.admin == 1 ? "Quản Lý" : "" }
                	${ account.admin == 0 ? "Khách Hàng" : "" }
                </td>
                <td>${ account.photo }</td>
                <td></td>
                <td><a class="btn btn-primary" href="/account/edit/${ account.id }">Cập nhật</a></td>
                <td><a class="btn btn-danger" href="/account/delete/${ account.id }">Xóa</a></td>
            </tr>
            </c:forEach>
    </tbody>
</table>
</c:if>