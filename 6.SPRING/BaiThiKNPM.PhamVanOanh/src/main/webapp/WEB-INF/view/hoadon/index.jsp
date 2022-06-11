<%@ include file="/WEB-INF/taglib/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Gia Di Management Application</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet">
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand">Invoice Management Application</a>
				<form:form class="d-flex" action="${contextPath}/hoadon?page=${param.page}"
					method="GET">
					<input type="hidden" name="page" value="${param.page}">
					<input name="text" value="${fn:trim(param.text)}"
						class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form:form>
			</div>
		</nav>
	</header>
	<main class="container-fluid">
		<a href="${contextPath}/hoadon/add"
			class="btn btn-primary btn-sm mt-3 mb-3"> <i
			class="far fa-address-book"></i> Add Invoice
		</a>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th><a href="#">SoHoaDon</a></th>
					<th><a href="#">NgayLap</a></th>
					<th><a href="#">VAT</a></th>
					<th><a href="#">NguoiLap</a></th>
					<th><a href="#">TongTien</a></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${invoices}" var="invoice">
					<tr>
						<td>${invoice.soHoaDon}</td>
						<td>${invoice.ngayLap}</td>
						<td>${invoice.VAT}</td>
						<td>${invoice.nguoiLap}</td>
						<td>${invoice.tongTien}</td>
						<td><a href="${contextPath}/hoadon/update?id=${invoice.soHoaDon}" class="btn btn-info btn-sm">Update</a> 
						<a
							href="${contextPath}/hoadon/delete?id=${invoice.soHoaDon}" class="btn btn-danger btn-sm"
							onclick="if(!confirm('Are you sure you want to delete this invoice ?')) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav class="float-end">
			<ul class="pagination">
				<c:if test="${currentPage!=1 }">
				<li class="page-item"><a
					href="${contextPath}/customer?page=${currentPage-1}"
					aria-label="Previous" class="page-link"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				</c:if>
				<c:forEach var="page" begin="1" end="${totalPages}">
					<li class="page-item"><c:choose>
							<c:when test="${currentPage==page }">
								<a href="${contextPath}/hoadon?page=${page}" class="page-link bg-warning">${page}</a>
							</c:when>
							<c:otherwise><a href="${contextPath}/hoadon?page=${page}" class="page-link">${page}</a></c:otherwise>
						</c:choose> 
					</li>
				</c:forEach>
				<c:if test="${currentPage!=totalPages}">
				<li class="page-item">
				<a href="${contextPath}/hoadon?page=${currentPage+1}" aria-label="Next"
					class="page-link"> <span aria-hidden="true">&raquo;</span>
				</a></li>
				</c:if>
			</ul>
		</nav>
	</main>
	<footer class="bg-light fixed-bottom py-3 text-center">
		<div class="container-fluid">
			<span class="text-muted">Quan Ly Hoa Don &#129392;
				01.06.2022</span>
		</div>
	</footer>
</body>
</html>