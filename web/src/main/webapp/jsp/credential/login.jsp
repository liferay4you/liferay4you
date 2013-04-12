<%@ include file="../header/basic-header.jsp" %>

<h2>Login</h2>

<!-- ********** Normal Login ********** -->
<c:if test="${view.type == 0}">
	<form action="<%=Mappings.LOGIN%>" method="post">
		<p>User Mail: <input type="text" name="<%=LoginForm.USER_MAIL%>"/> </p>
		<p>Password: <input type="password" name="<%=LoginForm.USER_PASSWORD%>"/> </p>
		<p>
			<input type="submit"/>
		</p>	
	</form>
</c:if>

<!-- ********** SUCCEESS ********** -->
<c:if test="${view.type == 1}">
	<div style="border: 2px solid green; padding: 5px;">${view.message}</div>
</c:if>

<!-- ********** FAIL ********** -->
<c:if test="${view.type == 2}">
	<div style="border: 2px solid red; padding: 5px;">${view.message}</div>
</c:if>

<%@ include file="../footer/basic-footer.jsp" %>