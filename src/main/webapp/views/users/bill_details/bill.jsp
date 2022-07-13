<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${ pageContext.request.contextPath }/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Hóa đơn</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>Tên sản phẩm</th>
                                    <th>Đơn giá</th>
                                    <th>Số lượng</th>
                                    <th>Tên người mua</th>
                                    <th>Tổng tiền</th>
                                    <th>Ảnh sản phẩm</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ lstoderdetails.content }" var="oderdetails" >
                                <tr>
                                	<td>${ oderdetails.product.name }</td>
                                	<td>$<fmt:formatNumber type="number" >${ oderdetails.product.price }</fmt:formatNumber></td>
                                	<td>${ oderdetails.quantity }</td>
                                	<td>${ oderdetails.oder.account.fullname }</td>
                                	<td>$<fmt:formatNumber type="number" >${ oderdetails.tongTien }</fmt:formatNumber></td>
                                	<td>
                                		<img src="${ pageContext.request.contextPath }/img/${ oderdetails.product.image }" width="100px" height="80px">
                                	</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-12 d-flex justify-content-end">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${ lstoderdetails.number > 0  }">
						<li class="page-item"><a class="page-link" href="/bill?page=${ lstoderdetails.number-1 }">Previous</a></li>
						</c:if>
						<c:if test="${ lstoderdetails.number == 0  }">
										  		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						</c:if>
						<li class="page-item"><a class="page-link" href="#">${ (lstoderdetails.number + 1) }  / ${ lstoderdetails.getTotalPages() } </a></li>
						<c:if test="${ lstoderdetails.number < lstoderdetails.getTotalPages() -1 }">
						<li class="page-item"><a class="page-link" href="/bill?page=${ lstoderdetails.number+1 }">Next</a></li>
						</c:if>
						<c:if test="${ lstoderdetails.number >= lstoderdetails.getTotalPages() - 1 }">
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
            </div>
    </section>
    <!-- Shoping Cart Section End -->
