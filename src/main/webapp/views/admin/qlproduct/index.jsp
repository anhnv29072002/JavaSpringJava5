<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success" >${ sessionScope.message }</div>
	<c:remove var="message" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-warning" >${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<div class="text-center">
	<h2>Quản Lý Sản Phẩm</h2>
</div>
<div>
<a class="btn btn-success justify-content-end" href="/dog/create">Thêm sản phẩm</a>
<form method="get" action="${ pageContext.request.contextPath }/dog/search">
	<select name="name" class="form-control-sm">
		<c:forEach items="${ lst }" var="item">
			<option>${ item.name }</option>
		</c:forEach>
	</select>
	<button class="btn btn-primary">Tìm kiếm</button>
</form>
</div>
<c:if test="${ empty lstproduct }">
	<div class="alert alert-warning">
		Không có dữ liệu
	</div>
</c:if>

<c:if test="${ !empty lstproduct }">
<table class="table table-border table-hover table-tripper">
    <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Giá tiền</th>
            <th>Số lượng</th>
            <th>Ngày tạo</th>
            <th>Tên thể loại</th>
            <th>Hình ảnh</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${ lstproduct.content }" var="product" >
            <tr>
                <td>${ product.name }</td>
                <td><fmt:formatNumber>${ product.price }</fmt:formatNumber></td>
                <td>${ product.quantity }</td>
                <td>
					<fmt:formatDate value="${ product.createdDate }" pattern="dd/MM/yyyy" />
				</td>
				<td>${ product.category.name }</td>
                <td>${ product.image }</td>
                <td><a class="btn btn-primary" href="/dog/edit/${ product.id }">Cập nhật</a></td>
                <td><a class="btn btn-danger" href="/dog/delete/${ product.id }">Xóa</a></td>
            </tr>
            </c:forEach>
    </tbody>
</table>
<div class="col-12 d-flex justify-content-end">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${ lstproduct.number > 0  }">
						<li class="page-item"><a class="page-link" href="/dog/index?page=${ lstproduct.number-1 }">Previous</a></li>
						</c:if>
						<c:if test="${ lstproduct.number == 0  }">
										  		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						</c:if>
						<li class="page-item"><a class="page-link" href="#">${ (lstproduct.number + 1) }  / ${ lstproduct.getTotalPages() } </a></li>
						<c:if test="${ lstproduct.number < lstproduct.getTotalPages() -1 }">
						<li class="page-item"><a class="page-link" href="/dog/index?page=${ lstproduct.number+1 }">Next</a></li>
						</c:if>
						<c:if test="${ lstproduct.number >= lstproduct.getTotalPages() - 1 }">
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
</c:if>