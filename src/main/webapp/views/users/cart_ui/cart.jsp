<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${ pageContext.request.contextPath }/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Giỏ hàng</h2>
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
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Sản phẩm</th>
                                    <th>Giá tiền</th>
                                    <th>Số lượng</th>
                                    <th>Thành tiền</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ sessionScope.lstcart }" var="item" >
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img src="img/cart/cart-1.jpg" alt="">
                                        <h5>${ item.product.name }</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                       $<fmt:formatNumber type="number" >${ item.product.price }</fmt:formatNumber>
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="input-group quantity">
                                        	<c:if test="${ item.quantity >= 1 }">
	                                        	<form action="/cart/updateDown/${ item.product.id }" method="POST">
		                                        	<div class="input-group-btn">
		                                        		<button class="btn btn-sm btn-danger btn-plus">-</button>
		                                        	</div>
	                                        	</form>
                                        	</c:if>
                                                <input type="text" disabled="disabled" class=" form-control form-control-sm border-0 text-center" value="${ item.quantity }">
                                              <c:if test="${ item.quantity < item.product.quantity }">
	                                              <form action="/cart/updateUp/${ item.product.id }" method="POST">
		                                              <div class="input-group-btn">
		                                        		<button class="btn btn-sm btn-info btn-plus">+</button>
		                                        	 </div>
	                                        	 </form>
                                        	 </c:if>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        $<fmt:formatNumber type="number">${ item.quantity * item.product.price }</fmt:formatNumber>
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <a href="/cart/delete/${ item.product.id }" ><span class="icon_close"></span></a>
                                    </td>
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
                            <h5>Discount Codes</h5>
                                <a href="/home" class="site-btn">Tiếp tục mua hàng</a>
                                <a href="/cart/clear" class="site-btn">Xóa trắng giỏ hàng</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng tiền tất cả sản phẩm</h5>
                        <ul>
                            <li>Tổng tiền: <span>$<fmt:formatNumber type="number">${ toltal }</fmt:formatNumber></span></li>
                        </ul>
                        <a href="/pay/home" class="primary-btn">Thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->
