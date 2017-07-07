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
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="${SITE_URL}"><img src="${SITE_URL}/resources/images/manjil_logo.png" height="25" style="margin-top:-3px"/></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="${SITE_URL}/products">Products</a></li>
              </ul>
              <ul class="nav navbar-nav pull-right">
              	<c:if test="${pageContext.request.userPrincipal.name !=null}">
              		<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
              		<li><a href="javascript:formSubmit()">Logout</a></li>
              		<sec:authorize access="hasRole('ROLE_USER')">
	              		<li><a href="${SITE_URL}/customer/cart">Cart</a></li>
	              	</sec:authorize>
	              	
	              	<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${SITE_URL}/admin">Admin</a></li>
					</sec:authorize>
              	</c:if>
              	<c:if test="${pageContext.request.userPrincipal.name == null}">
	              	<li><a href="${SITE_URL}/login">Login</a></li>
	              	<li><a href="${SITE_URL}/register">Register</a></li>
	            </c:if>
              </ul>
            </div>
          </div>
        </nav>

      </div>
