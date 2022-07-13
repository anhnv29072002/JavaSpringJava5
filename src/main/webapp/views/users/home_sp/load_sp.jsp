<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<section class="featured spad">
        <div class="container">
	<div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Featured Product</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".oranges">Oranges</li>
                            <li data-filter=".fresh-meat">Fresh Meat</li>
                            <li data-filter=".vegetables">Vegetables</li>
                            <li data-filter=".fastfood">Fastfood</li>
                        </ul>
                    </div>
                </div>
     </div>
	<div class="row featured__filter">
            	<c:forEach items="${ lstproduct.content }" var="item" >
            	<c:if test="${ item.quantity > 0 }">
	                <div class="col-lg-3 col-md-3 col-sm-3 mix oranges fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${ pageContext.request.contextPath }/img/${ item.image }">
	                            <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="/cart/add/${ item.id }"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="#">${ item.name }</a></h6>
	                            <h5>$<fmt:formatNumber>${ item.price }</fmt:formatNumber></h5>
	                        </div>
	                    </div>
	                </div>
	                </c:if>
                 </c:forEach>
            </div>
           	<div class="col-12 d-flex justify-content-end">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${ lstproduct.number > 0  }">
						<li class="page-item"><a class="page-link" href="/home?page=${ lstproduct.number-1 }">Previous</a></li>
						</c:if>
						<c:if test="${ lstproduct.number == 0  }">
										  		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						</c:if>
						<li class="page-item"><a class="page-link" href="#">${ (lstproduct.number + 1) }  / ${ lstproduct.getTotalPages() } </a></li>
						<c:if test="${ lstproduct.number < lstproduct.getTotalPages() -1 }">
						<li class="page-item"><a class="page-link" href="/home?page=${ lstproduct.number+1 }">Next</a></li>
						</c:if>
						<c:if test="${ lstproduct.number >= lstproduct.getTotalPages() - 1 }">
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
	</section>