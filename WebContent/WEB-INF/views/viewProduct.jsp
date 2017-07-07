
<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp" %>
<div class=container ng-app="cartApp">
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
			<h1>Product Detail</h1>
			<p class="lead">Here is the detail information of product.</p>
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5">	
			<img src="${SITE_URL}/resources/images/products/${product.productId}.png" alt="image" class="img-responsive" />
		</div>
		<div class="col-md-7">
			<h3>${product.productName}</h3>
			<p>${product.productDescription}</p>
			<p><strong>Manufacturer: </strong>${product.productManufacturer}</p>
			<p><strong>Category: </strong>${product.productCategory}</p>
			<p><strong>Condition: </strong>${product.productCondition}</p>
			<h4>${product.productPrice} USD</h4>
			
			<br/>
			
			<c:set var="role" scope="page" value="${param.role}" />
			<c:set var="url" scope="page" value="/products" />
			<c:if test="${role='admin'}">
				<c:set var="url" scope="page" value="/admin/productinventory" />
			</c:if>
			
			<p ng-controller="cartCtrl">
				<a href="<c:url value='${url}' />" class="btn btn-default">Back</a>
				<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
					<span class="glyphicon glyphicon-shopping-cart"></span>Order Now
				</a>
				<a href="<spring:url value='/customer/cart/' />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
				
			</p>
		</div>
	</div>
	
</div>
<script src="${SITE_URL}/resources/js/controller.js"></script>
<%@include file="includes/footer.jsp" %>