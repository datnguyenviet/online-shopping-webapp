<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/moss-style.css" rel='stylesheet' type='text/css' />

<link rel="stylesheet" type="text/css" href="mos-css/mos-style.css">



</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">

			<h3>Tabel</h3>

			<div class="informasi">ini adalah notifikasi pertanda informasi
			</div>

			<div class="gagal">ini adalah notifikasi pertanda gagal</div>

			<div class="sukses">ini adalah notifikasi pertanda sukses</div>
			
			<table class="data">
			
				<tr class="data">
					<th class="data" width="30px">No</th>
					<th class="data">Category ID</th>
					<th class="data">Category Name</th>
					<th class="data" width="75px">Option</th>
				</tr>
				
				<tr class="data">
					<td class="data" width="30px">1</td>
					<td class="data">Data Anda</td>
					<td class="data">Data Anda</td>
					<td class="data" width="75px">
						<center>
							<a href="#">Edit</a>&nbsp;&nbsp; | &nbsp;&nbsp;
							<a href="#">Delete></a>
						</center>
					</td>
				</tr>
				
			</table>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>


	</div>

</body>
</html>