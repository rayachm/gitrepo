<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Transactions</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="../assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="../assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet" href="../assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="../assets/images/favicon.ico" />
</head>
<body>
	<div class="container-scroller">

		<!-- partial:partials/_navbar.html -->
		<nav
			class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo" href="index.html">
				<i class="mdi mdi-wallet menu-icon"></i>
				<span class="title">Wallet Application</span>
				
				<imgsrc="../assets/images/logo-mini.svg" alt="logo" /></a>
			</div>
			<div class="navbar-menu-wrapper d-flex align-items-stretch">
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="mdi mdi-menu"></span>
				</button>

				<ul class="navbar-nav navbar-nav-right">
					<li class="nav-item nav-profile dropdown">
						<div class="nav-profile-text">
							<p class="mb-1 text-black">${userName}</p>
						</div>
					</li>
					

					<li class="nav-item nav-logout d-none d-lg-block"><a
						class="nav-link" href="./login"> <i class="mdi mdi-power"></i>
					</a></li>
					
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="mdi mdi-menu"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">

					<li class="nav-item"><a class="nav-link" href="./Homepage">
							<span class="menu-title">Dashboard</span> <i
							class="mdi mdi-home menu-icon"></i>
					</a></li>

					<li class="nav-item"><a class="nav-link"
						href="./createAccpage"> <span class="menu-title">Create
								Account</span> <i class="mdi mdi-contacts menu-icon"></i>
					</a></li>

					<li class="nav-item"><a class="nav-link"
						href="./depositWithdrawMoneypage"> <span class="menu-title">Deposit</span>
							<i class="mdi mdi-contacts menu-icon"></i></a></li>

					<li class="nav-item"><a class="nav-link"
						href="./WithdrawMoneypage"> <span class="menu-title">Withdraw</span>
							<i class="mdi mdi-contacts menu-icon"></i></a></li>

					<li class="nav-item"><a class="nav-link"
						href="./transferMoneyPage"> <span class="menu-title">Fund Transfer</span>
							<i class="mdi mdi-contacts menu-icon"></i></a></li>


					<li class="nav-item"><a class="nav-link" href="./TPage"> <span
							class="menu-title">Transaction</span> <i
							class="mdi mdi-contacts menu-icon"></i></a></li>


					<li class="nav-item"><a class="nav-link" href="./TDPage">
							<span class="menu-title">Transaction Particular Date</span> <i
							class="mdi mdi-contacts menu-icon"></i>
					</a></li>
				</ul>
			</nav>


			<div class="main-panel">
				<div class="content-wrapper">
					<div class="card">
						<div class="card-body">

							</table>
							<h4 class="card-title">TransactionTable</h4>
							<p class="card-description"></p>
							<c:if test="${transactions ne null }">
								<table id="example" class="table table-striped">
									<tr>
										<th>Transaction ID</th>
										<th>Transaction Amount</th>
										<th>Transaction Date</th>
										<th>Transaction Type</th>
										<th>Account Number</th>
									</tr>
									<c:forEach items="${transactions}" var="transaction">
										<tr>
											<td>${transaction.transactionId}</td>
											<td>${transaction.transactionAmount}</td>
											<td>${transaction.transactionDate}</td>
											<td>${transaction.transactionType}</td>
											<td>${transaction.account.accountNumber}</td>


										</tr>

									</c:forEach>

								</table>

							</c:if>
						</div>
					</div>
				</div>




				<!-- partial:partials/_footer.html -->
				
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->


	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="../assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="../assets/vendors/chart.js/Chart.min.js"></script>
	<script src="../assets/js/jquery.cookie.js" type="text/javascript"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="../assets/js/off-canvas.js"></script>
	<script src="../assets/js/hoverable-collapse.js"></script>
	<script src="../assets/js/misc.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page -->
	<script src="../assets/js/dashboard.js"></script>
	<script src="../assets/js/todolist.js"></script>
	<!-- End custom js for this page -->

	<script>
		var minDate, maxDate;

		// Custom filtering function which will search data in column four between two values
		$.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
			var min = minDate.val();
			var max = maxDate.val();
			var date = new Date(data[4]);

			if ((min === null && max === null) || (min === null && date <= max)
					|| (min <= date && max === null)
					|| (min <= date && date <= max)) {
				return true;
			}
			return false;
		});

		$(document).ready(function() {
			// Create date inputs
			minDate = new DateTime($('#min'), {
				format : 'MMMM Do YYYY'
			});
			maxDate = new DateTime($('#max'), {
				format : 'MMMM Do YYYY'
			});

			// DataTables initialisation
			var table = $('#example').DataTable();

			// Refilter the table
			$('#min, #max').on('change', function() {
				table.draw();
			});
		});
	</script>
</body>
</html>