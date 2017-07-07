<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<div class=container>
	<div class="page-header">
		<h1>Add product</h1>
		<p class="lead">Here you can add product.</p>
	</div>
	
	<form:form action="${SITE_URL}/admin/productinventory/addProduct" method="post" commandName="product" enctype="multipart/form-data">
	  <div class="form-group">
	    <label for="productId">Product Id</label>&nbsp;&nbsp;&nbsp;&nbsp;<form:errors path="productId" cssStyle="color:red"/>
	    <form:input type="text" name="id" class="form-control" id="productId" placeholder="Product Id" path="productId" />
	  </div>
	  <div class="form-group">
	    <label for="productName">Name</label>&nbsp;&nbsp;&nbsp;&nbsp;<form:errors path="productName" cssStyle="color:red"/>
	    <form:input type="text" name="name" class="form-control" id="productName" placeholder="Product Name" path="productName"/>
	  </div>
	  <div class="form-group">
	    <label>Category</label>
		<form:select path="productCategory" name="category">
	            <form:option value="Instrument" >Instrument</form:option>
	            <form:option value="Record">Record</form:option>
	            <form:option value="Accessory">Accessory</form:option>
	  	</form:select>  
	  </div>
	  
	  <div class="form-group">
	    <label for="productDescription">Description</label>
	    <form:textarea type="text" class="form-control" id="productDescription" placeholder="Product Description" path="productDescription"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="productPrice">Price</label>&nbsp;&nbsp;&nbsp;&nbsp;<form:errors path="productPrice" cssStyle="color:red"/>
	    <form:input type="text" class="form-control" id="productPrice" placeholder="Product Price" path="productPrice"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="productCondition">Condition</label>
	    <form:input type="text" class="form-control" id="productCondition" placeholder="Product Condition" path="productCondition"/>
	  </div>
	  
	  <div class="form-group">
	    <label>Status</label>
	    <label class="radio-inline">
	    	<form:radiobutton path="productStatus" id="inlineRadio1" value="1"/>Active
	    </label>
	    <label class="radio-inline">
	    	<form:radiobutton path="productStatus" id="inlineRadio2" value="0"/>Inactive	
	    </label>
	  </div>
	  
	  <div class="form-group">
	    <label for="productStock">Unit in stock</label>&nbsp;&nbsp;&nbsp;&nbsp;<form:errors path="unitInStock" cssStyle="color:red"/>
	    <form:input type="text" class="form-control" id="productStock" placeholder="Product in Stock" path="unitInStock"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="productManufacturer">Manufacturer</label>
	    <form:input type="text" class="form-control" id="productManufacturer" placeholder="Product Manufacturer" path="productManufacturer"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="productImage">Upload Image</label>
	    <form:input path="productImage" type="file" id="productImage" class="form:input-large"/>
	    <!-- <p class="help-block">Example block-level help text here.</p> -->
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Submit</button> <a href="${SITE_URL}/admin/productinventory" class="btn btn-default">Cancel</a>
	</form:form>
	
</div>	


<%@include file="../includes/footer.jsp" %>