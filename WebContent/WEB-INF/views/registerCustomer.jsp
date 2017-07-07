<%@include file="includes/header.jsp"%>
<div class=container>
	<div class="page-header">
		<h1>Register</h1>
		<p class="lead">Please fill in your information below.</p>
	</div>
	
	<form:form action="${SITE_URL}/register" method="post" commandName="customer">
	<h3>Basic Info</h3>
	  <div class="form-group">
	    <label for="name">Name</label><form:errors path="customerName" cssStyle="color:#ff0000" />
	    <form:input class="form-control" id="name" placeholder="Name" path="customerName" />
	  </div>
	  <div class="form-group">
	    <label for="email">Email</label><span style="color:#ff0000">${emailMsg}</span><form:errors path="customerEmail" cssStyle="color:#ff0000" />
	    <form:input type="email" class="form-control" id="email" placeholder="Email" path="customerEmail" />
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone number</label>
	    <form:input type="text" class="form-control" id="phoneNo" placeholder="Phone Number" path="customerPhone" />
	  </div>
	  <div class="form-group">
	    <label for="username">Username</label><span style="color:#ff0000">${usernameMsg}</span><form:errors path="username" cssStyle="color:#ff0000" />
	    <form:input class="form-control" id="username" placeholder="Usename" path="username" />
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label><form:errors path="password" cssStyle="color:#ff0000" />
	    <form:password class="form-control" id="password" placeholder="Password" path="password" />
	  </div>
	  
	  <h3>Billing Address</h3>
	  <div class="form-group">
	    <label for="billingStreet">Street Name</label>
	    <form:input class="form-control" id="billingStreet" placeholder="Billing Address" path="billingAddress.streetName" />
	  </div>
	  <div class="form-group">
	    <label for="billingApartmentNumber">Apartment Number</label>
	    <form:input class="form-control" id="billingApartmentNumber" placeholder="Billing Apartment Number" path="billingAddress.apartmentNumber" />
	  </div>
	  <div class="form-group">
	    <label for="billingCity">City</label>
	    <form:input class="form-control" id="billingCity" placeholder="City" path="billingAddress.city" />
	  </div>
	  <div class="form-group">
	    <label for="billingState">State</label>
	    <form:input class="form-control" id="billingState" placeholder="State" path="billingAddress.state" />
	  </div>
	  <div class="form-group">
	    <label for="billingCountry">Country</label>
	    <form:input class="form-control" id="billingCountry" placeholder="Country" path="billingAddress.country" />
	  </div>
	  <div class="form-group">
	    <label for="billingZip">Zip Code</label>
	    <form:input class="form-control" id="billingZip" placeholder="Zip Code" path="billingAddress.zipCode" />
	  </div>
	  
	  <h3>Shipping Address</h3>
	  <div class="form-group">
	    <label for="shippingStreet">Street Name</label>
	    <form:input class="form-control" id="shippingStreet" placeholder="Shipping Street" path="shippingAddress.streetName" />
	  </div>
	  <div class="form-group">
	    <label for="shippingApartmentNumber">Apartment Number</label>
	    <form:input class="form-control" id="shippingApartmentNumber" placeholder="Shipping Apartment Number" path="shippingAddress.apartmentNumber" />
	  </div>
	  <div class="form-group">
	    <label for="shippingCity">City</label>
	    <form:input class="form-control" id="shippingCity" placeholder="City" path="shippingAddress.city" />
	  </div>
	  <div class="form-group">
	    <label for="shippingState">State</label>
	    <form:input class="form-control" id="shippingState" placeholder="State" path="shippingAddress.state" />
	  </div>
	  <div class="form-group">
	    <label for="shippingCountry">Country</label>
	    <form:input class="form-control" id="shippingCountry" placeholder="Country" path="shippingAddress.country" />
	  </div>
	  <div class="form-group">
	    <label for="shippingZip">Zip Code</label>
	    <form:input class="form-control" id="shippingZip" placeholder="Zip Code" path="shippingAddress.zipCode" />
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Submit</button> <a href="${SITE_URL}" class="btn btn-default">Cancel</a>
	</form:form>
	
</div>	
<%@include file="includes/footer.jsp"%>
