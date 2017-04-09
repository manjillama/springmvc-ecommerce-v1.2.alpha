<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp" %>
<div class=container>
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
		</div>
	</div>
	
</div>
<%@include file="includes/footer.jsp" %>