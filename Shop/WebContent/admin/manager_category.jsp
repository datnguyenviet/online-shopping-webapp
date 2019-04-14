<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dao.CategoryDAO"%>
<%@ page import="model.Category" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />




</head>
<body>

	<%
		CategoryDAO categoryDAO = new CategoryDAO();
		ArrayList<Category> listCategory = categoryDAO.getListCategory();
	
	%>

	<jsp:include page="header.jsp"></jsp:include>


	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">

			<h3>Category Management</h3>
			<a href="${root}/admin/insert_category.jsp">Adding Category</a>
			
			<table class="data">
			
				<tr class="data">
					<th class="data" width="30px">No</th>
					<th class="data">Category ID</th>
					<th class="data">Category Name</th>
					<th class="data" width="90px">Option</th>
				</tr>
				<% 
				
				int count = 0; 
				for (Category category: listCategory) { 
					count++; 
				
				%>
				
				<tr class="data">
					<td class="data" width="30px"><%=count%></td>
					<td class="data"><%= category.getCategoryID() %></td>
					<td class="data"><%= category.getCategoryName() %></td>
					<td class="data" width="90px">
						<center>
							<a href="${root}/admin/update_category.jsp?command=update&category_id=<%=category.getCategoryID()%>">Edit</a>&nbsp;&nbsp; | &nbsp;&nbsp;
							<a href="${root}/ManagerCategoryServlet?command=delete&category_id=<%=category.getCategoryID()%>">Delete></a>
						</center>
					</td>
				</tr>
				<% } %>
				
			</table>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>


	</div>

</body>
</html>