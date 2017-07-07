<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp" %>
<div class=container>
	<div class="page-header">
		<h1>Customer Management Page</h1>
		<p class="lead">This is the customer management page.</p>
	</div>
	
	<table class="table table-striped table-hover">
		<tr class="bg-success">
			<th>Name</th>
			<th>Email</th>
			<th>Phone No</th>
			<th>Username</th>
			<th>Enabled</th>
		</tr>
	
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customerName}</td>
				<td>${customer.customerEmail}</td>
				<td>${customer.customerPhone}</td>
				<td>${customer.username}</td>
				<td>
				<c:choose>
						<c:when test="${customer.enabled==true}">
							<span class="label label-success">Active</span>
						</c:when>
						<c:otherwise>
							<span class="label label-danger">Inactive</span>
						</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
<%@include file="../includes/footer.jsp"%>

