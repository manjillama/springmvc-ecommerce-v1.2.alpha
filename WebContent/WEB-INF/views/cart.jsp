 <%@include file="includes/header.jsp" %>
<%@include file="includes/nav.jsp" %>
<div class="container">
	<section class="">
		 <div class="jumbotron">
		 	<h1>Cart</h1>
		 	<p>All the selected products in your shopping cart.</p>
		 </div>
	</section>
	<section ng-app="cartApp">
		<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				<a class="btn btn-warning pull-right" href="${SITE_URL}/order/${cartId}"><span class="glyphicon glyphicon-shopping-cart"></span>Checkout</a>
			</div>
			
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr ng-repeat="item in cart.cartItems">
					<td>{{item.product.productName}}</td>
					<td>{{item.product.productPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrice}}</td>
					<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
						<span class="glyphicon glyphicon-remove"></span>remove
					</a></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{calGrandTotal()}}</th>
					<th></th>
				</tr>
				
			</table>
			
			<a href="${SITE_URL}/products" class="btn btn-default">Products</a>
		</div>
	</section>
</div>
<script src="${SITE_URL}/resources/js/controller.js"></script>
<%@include file="includes/footer.jsp" %>