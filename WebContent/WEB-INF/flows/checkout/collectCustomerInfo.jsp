<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class=container>
	<div class="page-header">
		<h1>Customer</h1>
		<p class="lead">Customer Details</p>
	</div>
	
	<form:form commandName="order" class="form-horizontal">
	<h3>Basic Info</h3>
	  <div class="form-group">
	    <label for="name">Name</label>
	    <form:input class="form-control" id="name" placeholder="Name" path="cart.customer.customerName" />
	  </div>
	  <div class="form-group">
	    <label for="email">Email</label>
	    <form:input type="email" class="form-control" id="email" placeholder="Email" path="cart.customer.customerEmail" />
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone number</label>
	    <form:input type="text" class="form-control" id="phoneNo" placeholder="Phone Number" path="cart.customer.customerPhone" />
	  </div>
	  
	  <h3>Billing Address</h3>
	  <div class="form-group">
	    <label for="billingStreet">Street Name</label>
	    <form:input class="form-control" id="billingStreet" placeholder="Billing Address" path="cart.customer.billingAddress.streetName" />
	  </div>
	  <div class="form-group">
	    <label for="billingApartmentNumber">Apartment Number</label>
	    <form:input class="form-control" id="billingApartmentNumber" placeholder="Billing Apartment Number" path="cart.customer.billingAddress.apartmentNumber" />
	  </div>
	  <div class="form-group">
	    <label for="billingCity">City</label>
	    <form:input class="form-control" id="billingCity" placeholder="City" path="cart.customer.billingAddress.city" />
	  </div>
	  <div class="form-group">
	    <label for="billingState">State</label>
	    <form:input class="form-control" id="billingState" placeholder="State" path="cart.customer.billingAddress.state" />
	  </div>
	  <div class="form-group">
	    <label for="billingCountry">Country</label>
	    <form:input class="form-control" id="billingCountry" placeholder="Country" path="cart.customer.billingAddress.country" />
	  </div>
	  <div class="form-group">
	    <label for="billingZip">Zip Code</label>
	    <form:input class="form-control" id="billingZip" placeholder="Zip Code" path="cart.customer.billingAddress.zipCode" />
	  </div>
	  
	  <input type="hidden" name="_flowExecutionKey" />
	  
	  <input type="submit" class="btn btn-warning" name="_eventId_customerInfoCollected" value="Proceed" />
	  <button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
	</form:form>
	
</div>	
<%@include file="/WEB-INF/views/includes/footer.jsp"%>
