<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<div class=container>
	<div class="page-header">
		<h1>Order</h1>
		<p class="lead">Order Confirmation</p>
	</div>
	
	<div class="row">
		<form:form commandName="order" class="form-horizontal">
		<div class="well col-sm-10 col-sm-offset-1">
	  		<h3>Shipping Address</h3>
			  
			  <div class="text-center">
			  	<h1>Recipt</h1>
			  </div>
			  <div class="row">
			  	<div class="col-sm-6">
			  		<address>
			  			<strong>Shipping Address</strong><br/>
			  			${order.cart.customer.shippingAddress.streetName}<br/>
			  			${order.cart.customer.shippingAddress.apartmentNumber}<br/>
			  			${order.cart.customer.shippingAddress.city}<br/>
			  			${order.cart.customer.shippingAddress.state}<br/>
			  			${order.cart.customer.shippingAddress.country}, ${order.cart.customer.shippingAddress.zipCode}<br/>
			  			
			  		</address>
			  	</div>
			  	<div class="col-sm-6">
			  		<p>Shipping Date: <fmt:formatDate type="date" value="${now}" /></p>
			  		
			  	</div>
			  </div>
			  <div class="row">
			  	<div class="col-sm-6">
			  		<address>
			  			<strong>Billing Address</strong><br/>
			  			${order.cart.customer.billingAddress.streetName}<br/>
			  			${order.cart.customer.billingAddress.apartmentNumber}<br/>
			  			${order.cart.customer.billingAddress.city}<br/>
			  			${order.cart.customer.billingAddress.state}<br/>
			  			${order.cart.customer.billingAddress.country}, ${order.cart.customer.billingAddress.zipCode}<br/>
			  			
			  		</address>
			  	</div>
			  </div>
			  
			  <div class="row">
			  	<div class="col-sm-12">
			  		<table class="table table-hover">
			  			<tr>
			  				<th>Product</th>
			  				<th>#</th>
			  				<th class="text-center">Price</th>
			  				<th class="text-center">Total</th>
			  			</tr>
			  			<c:forEach var="cartItem" items="${order.cart.cartItems}">
			  				<tr>
			  					<td><em>${cartItem.product.productName}</em></td>
			  					<td><em>${cartItem.quantity}</em></td>
			  					<td><em>${cartItem.product.productPrice}</em></td>
			  					<td><em>${cartItem.totalPrice}</em></td>
			  				</tr>
			  			</c:forEach>
			  			
			  			<tr>
			  				<td></td>
			  				<td></td>
			  				<td class="text-right">Grand Total</td>
			  				<td class="text-center text-danger">
			  					<strong>$ ${order.cart.grandTotal} </strong>
			  				</td>
			  			</tr>
			  		</table>
			  	</div>
			  </div>
			  <input type="hidden" name="_flowExecutionKey" />
			  
			  <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
			  <input type="submit" class="btn btn-warning" name="_eventId_orderConfirmed" value="Submit" />
			  <button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
	  	</div>
	  	</form:form>
	</div>
	
</div>	
<%@include file="/WEB-INF/views/includes/footer.jsp"%>
