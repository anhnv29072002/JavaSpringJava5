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
                        <h2>Xác nhận thanh toán</h2>
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
                                    <th>Tên thể loại</th>
                                    <th>Đơn giá</th>
                                    <th>Số lượng mua</th>
                                    <th>Hình ảnh</th>
                                    <th>Thành tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ sessionScope.lstcart }" var="item" >
                                <tr>
                                	<td>${ item.product.name }</td>
                                	<td>${ item.product.category.name }</td>
                                	<td>$<fmt:formatNumber type="number" >${ item.product.price }</fmt:formatNumber></td>
                                	<td>${ item.quantity }</td>
                                	<td>
                                		<img src="${ pageContext.request.contextPath }/img/${ item.product.image }" width="100px" height="80px">
                                	</td>
                                	<td>$<fmt:formatNumber type="number">${ item.quantity * item.product.price }</fmt:formatNumber></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                                <p class="site-btn">Cảm ơn quý khách</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng tiền tất cả sản phẩm</h5>
                        <ul>
                            <li>Tổng tiền: <span>$<fmt:formatNumber type="number" >${ sessionScope.toltal }</fmt:formatNumber></span></li>
                        </ul>
                        <a href="/pay/confirm" class="primary-btn">Xác nhận thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->
