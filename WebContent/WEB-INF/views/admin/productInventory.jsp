<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp" %>
<div class=container>
	<div class="page-header">
		<h1>Product Inventory Page</h1>
		<p class="lead">This is the product inventory page.</p>
	</div>
	
	<table class="table table-striped table-hover">
		<tr class="bg-success">
			<th>Photo Thumb</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Condition</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
	
		<c:forEach items="${products}" var="product">
			<tr>
				<td><img src="${SITE_URL}/resources/images/products/${product.productId}.png" alt="image" style="max-height:60px" /></td>
				<td>${product.productName}</td>
				<td>${product.productCategory}</td>
				<td>${product.productCondition}</td>
				<td>$ ${product.productPrice}</td>
				<td>
					<a href="${SITE_URL}/products/detail/${product.productId}" class="btn btn-primary btn-xs">
						<span class="glyphicon glyphicon-info-sign"></span>
					</a>
					<a href="${SITE_URL}/admin/productinventory/editproduct/${product.productId}" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>
					</a>
					<a href="${SITE_URL}/admin/productinventory/deleteproduct/${product.productId}" class="btn btn-danger btn-xs" onclick="return confirm('Are you sure to delete?')">
						<span class="glyphicon glyphicon-trash"></span>
					</a>
				</td>
				
				<%-- <td>
				<c:choose>
						<c:when test="${product.productStatus==true}">
							<span class="label label-success">Active</span>
						</c:when>
						<c:otherwise>
							<span class="label label-danger">Inactive</span>
						</c:otherwise>
				</c:choose>
				</td> --%>
			</tr>
		</c:forEach>
		
	</table>
	<a href="${SITE_URL}/admin/productinventory/addProduct" class="btn btn-primary">Add Product</a>
</div>
<%@include file="../includes/footer.jsp"%>

