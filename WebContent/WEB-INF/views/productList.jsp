<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp" %>
<div class=container>
	<div class="page-header">
		<h1>All Products</h1>
		<p class="lead">Check out all the awesome products available now.</p>
	</div>
	
	<table class="table table-striped table-hover">
		<tr class="bg-success">
			<th>Photo Thumb</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Condition</th>
			<th>Price</th>
			<th></th>
		</tr>
	
		<c:forEach items="${products}" var="product">
			<tr>
				<td><img src="${SITE_URL}/resources/images/products/${product.productId}.png" height="60px" alt="image" /></td>
				<td>${product.productName}</td>
				<td>${product.productCategory}</td>
				<td>${product.productCondition}</td>
				<td>${product.productPrice} USD</td>
				<td>
					<a href="${SITE_URL}/products/detail/${product.productId}">
						<span class="glyphicon glyphicon-info-sign"></span>
					</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
</div>
<%@include file="includes/footer.jsp"%>

