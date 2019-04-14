<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manger category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css"
	rel='stylesheet' type='text/css' />

</head>
<body>
	
	<%
		String error = "";
		if (request.getParameter("error") != null){
			error = (String) request.getParameter("error");
		}
		
	%>


	<jsp:include page="header.jsp"></jsp:include>


	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Category Information</h3>
			<form action="/Shop/ManagerCategoryServlet" method="post">
				<table width="95%">
					<tr>
						<td style="float: right"><b>Category names:</b></td>
						<td><input type="text" class="sedang" name="nameCategory"><%=error%></td>
					</tr>
					<tr><td></td><td>
						<input type="hidden" name="command" value="insert">
						<input type="submit" class="button" value="Save">
						</td>
					</tr>
				</table>
			</form>
		</div>


		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>