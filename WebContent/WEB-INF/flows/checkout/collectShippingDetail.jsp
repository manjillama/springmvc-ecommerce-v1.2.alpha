<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class=container>
	<div class="page-header">
		<h1>Customer</h1>
		<p class="lead">Customer Details</p>
	</div>
	
	<form:form commandName="order" class="form-horizontal">
	  
	  <h3>Shipping Address</h3>
	  <div class="form-group">
	    <label for="shippingStreet">Street Name</label>
	    <form:input class="form-control" id="shippingStreet" placeholder="Billing Address" path="cart.customer.shippingAddress.streetName" />
	  </div>
	  <div class="form-group">
	    <label for="shippingApartmentNumber">Apartment Number</label>
	    <form:input class="form-control" id="shippingApartmentNumber" placeholder="Billing Apartment Number" path="cart.customer.shippingAddress.apartmentNumber" />
	  </div>
	  <div class="form-group">
	    <label for="shippingCity">City</label>
	    <form:input class="form-control" id="shippingCity" placeholder="City" path="cart.customer.shippingAddress.city" />
	  </div>
	  <div class="form-group">
	    <label for="shippingState">State</label>
	    <form:input class="form-control" id="shippingState" placeholder="State" path="cart.customer.shippingAddress.state" />
	  </div>
	  <div class="form-group">
	    <label for="shippingCountry">Country</label>
	    <form:input class="form-control" id="shippingCountry" placeholder="Country" path="cart.customer.shippingAddress.country" />
	  </div>
	  <div class="form-group">
	    <label for="shippingZip">Zip Code</label>
	    <form:input class="form-control" id="shippingZip" placeholder="Zip Code" path="cart.customer.shippingAddress.zipCode" />
	  </div>
	  
	  <input type="hidden" name="_flowExecutionKey" />
	  
	  <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
	  <input type="submit" class="btn btn-warning" name="_eventId_shippingDetailCollected" value="Proceed" />
	  <button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
	</form:form>
	
</div>	
<%@include file="/WEB-INF/views/includes/footer.jsp"%>
