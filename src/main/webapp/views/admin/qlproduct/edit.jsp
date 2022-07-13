<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-warning" >${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

    <form:form action="${ pageContext.request.contextPath }/dog/update/${ product.id }" method="post" modelAttribute="product" enctype="multipart/form-data" >
        <div class="card">
            <div class="card-header text-center">
                <p style="font-size: x-large;">Quản lý Sản Phẩm</p>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="">Tên sản phẩm</label> 
                    <form:input path="name" class="form-control" name="name" />
                    <form:errors path="name" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Giá tiền</label> 
                    <form:input path="price" class="form-control" name="price" />
                    <form:errors path="price" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Số lượng</label> 
                    <form:input path="quantity" class="form-control" name="quantity" />
                    <form:errors path="quantity" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Ngày tạo</label> 
                    <form:input path="createdDate" name="createdDate" class="form-control"  />
                     <form:errors path="createdDate" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="">Tên thể loại </label>
                    <form:select path="category.id" cssClass="form-control" >
                    	<form:options items="${ lstcategory }" itemValue="id" itemLabel="name" />
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="">Hình ảnh</label> 
                    <input class="form-control" type="file" name="image_file" value="${ product.image }" placeholder="Vui lòng chọn hình ảnh">
                    <img src="${ pageContext.request.contextPath }/img/${ product.image }" width="150px" height="150px" >
                </div>
            </div>
            <div class="card-footer text-center">
                <button class="btn btn-success">Sửa</button>
            </div>
        </div>
    </form:form>
