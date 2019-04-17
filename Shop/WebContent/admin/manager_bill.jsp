<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.BillDAO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Bill"%>
<%@ page import="dao.UsersDAO" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bill Management</title>
	
		<c:set var="root" value="${pageContext.request.contextPath}"/>
		<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<%
		BillDAO billDAO = new BillDAO();
		ArrayList<Bill> listBill = billDAO.getListBill();
		UsersDAO usersDAO = new UsersDAO();
	%>
	
	<jsp:include page="header.jsp"></jsp:include>


	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">

			<h3>Bill Management</h3>


			<table class="data">
				<tr class="data">
					<th class="data" width="30px">Bill ID</th>
					<th class="data">Customer</th>
					<th class="data">Bill Total</th>
					<th class="data">Payment</th>
					<th class="data">Delivery Address</th>
					<th class="data">Purchase Date</th>
					<th class="data" width="75px">Option</th>
				</tr>
				
				<%for (Bill bill: listBill){ %>
				
				<tr class="data">
					<td class="data" width="30px"><%=bill.getBillID() %></td>
					<td class="data"><%=usersDAO.getUser(bill.getUserID()).getUserEmail()%></td>
					<td class="data"><%=bill.getTotal() %></td>
					<td class="data"><%=bill.getPayment() %></td>
					<td class="data"><%=bill.getAddress() %></td>
					<td class="data"><%=bill.getDate() %></td>
					<td class="data" width="75px">
						<center>
							<a href="#">Complete</a>&nbsp;&nbsp; | &nbsp;&nbsp;
							<a href="#">Cancel</a>
						</center>
					</td>
				</tr>
				<%} %>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>