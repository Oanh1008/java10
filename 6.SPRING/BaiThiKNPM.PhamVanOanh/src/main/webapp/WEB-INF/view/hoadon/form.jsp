<%@ include file="/WEB-INF/taglib/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Customer</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h3 class="h4 mt-4 mb-4">Save Invoice</h3>
		<hr>
		<form:form action="save"  method="POST" modelAttribute="invoice">
			<form:hidden path="soHoaDon"/>
			<div class="form-group row mt-4 mb-4">
				<label for="firstName" class="col-sm-2 col-form-label">NgayLap:</label>
				<div class="col-sm-4">
					<form:input class="form-control"  id="ngayLap" path="ngayLap"  type="date"/>
				</div>
			</div>
			<div class="form-group row mt-4 mb-4">
				<label for="lastName" class="col-sm-2 col-form-label">VAT:</label>
				<div class="col-sm-4">
					<form:input class="form-control"  id="VAT" path="VAT" type="number"/>
				</div>
			</div>
			<div class="form-group row mt-4 mb-4">
				<label for="email" class="col-sm-2 col-form-label">NguoiLap:</label>
				<div class="col-sm-4">
					<form:input class="form-control" id="nguoiLap" path="nguoiLap"/>
				</div>
			</div>
			<div class="form-group row mt-4 mb-4">
				<label for="email" class="col-sm-2 col-form-label">TongTien:</label>
				<div class="col-sm-4">
					<form:input class="form-control" id="tongTien" path="tongTien" type="number"/>
				</div>
			</div>
			<button type="submit" class="btn btn-info col-1">Save</button>
		</form:form>
		<hr>
		<a href="${contextPath}/hoadon">Back to Invoice List</a>
		<footer class="bg-light fixed-bottom py-3 text-center">
			<div class="container-fluid">
				<span class="text-muted">Quan Ly Hoa Don &#129392;  09.01.2022</span>
			</div>
		</footer>
	</div>
</body>
</html>