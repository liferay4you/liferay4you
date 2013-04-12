<%@ include file="../header/basic-header.jsp" %>

<h2>Create account</h2>

<!-- ********** NEW ACCOUNT ********** -->
<c:if test="${view.type == 0}">
	<form action="<%=Mappings.CREATE_ACCOUNT%>" method="post">
		<div>
			<p>User Mail: <input type="text" name="<%=CreateAccountForm.USER_MAIL%>"/> </p>
			<p>Password: <input type="password" name="<%=CreateAccountForm.USER_PASSWORD%>"/> </p>
			<p>Repeat Password: <input type="password" name="<%=CreateAccountForm.USER_PASSWORD_REPEAT%>"/> </p>
			<p>
				<input type="submit"/>
			</p>		
		</div>
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