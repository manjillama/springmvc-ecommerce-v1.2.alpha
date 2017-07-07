<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>
<%@page session="true"%>
<div class=container>
	<div class="page-header">
		<h1>Administrator Page</h1>
		<p class="lead">This is administrator page.</p>
	</div>
	
	
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
	
	
	<h3>
		<a href="${SITE_URL}/admin/productinventory">Product Inventory</a>
	</h3>
	<p>Here, you can view, check and modify the product inventory.</p>
	<h3>
		<a href="${SITE_URL}/admin/customer">Customer Management</a>
	</h3>
	<p>Here, you can view, the customer infomation.</p>
</div>	

<%@include file="../includes/footer.jsp"%>