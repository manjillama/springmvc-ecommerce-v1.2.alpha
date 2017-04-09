<%@ include file="includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>

<div class="container">
	<h2>Login with Username and Password</h2>
	<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
	  <div class="form-group">

		<c:if test="${not empty error}">
			<div class="error" style="color:red;">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
	    <label for="username">Username</label>
	    <input type="text" name="username" class="form-control" id="username" placeholder="Username">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
	  </div>
	  
	  <button type="submit" class="btn btn-default">Submit</button>
	  
	  <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
	</form>
</div>

<%@ include file="includes/footer.jsp"%>