 <%@include file="/WEB-INF/views/includes/header.jsp" %>
<%@include file="/WEB-INF/views/includes/nav.jsp" %>
<div class="container">
	<section class="">
		 <div class="jumbotron">
		 	<h1 class="alert alert-danger">Checkout Cancelled </h1>
		 	<p>Your checkout process is cancelled, you may continue shopping</p>
		 </div>
	</section>
	<section>
		<a href="${SITE_URL}/products" class="btn btn-default">Products</a>
	</section>
</div>
<script src="${SITE_URL}/resources/js/controller.js"></script>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>