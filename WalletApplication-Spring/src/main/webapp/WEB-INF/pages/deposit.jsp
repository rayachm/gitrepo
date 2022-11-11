<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Purple Admin</title>
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


					<li class="nav-item"><a class="nav-link"
						href="./TPage"> <span class="menu-title">Transaction</span>
						<i class="mdi mdi-contacts menu-icon"></i></a></li>


					<li class="nav-item"><a class="nav-link"
						href="./TDPage"> <span class="menu-title">Transaction Particular Date</span>
						<i class="mdi mdi-contacts menu-icon"></i></a></li>
				</ul>
			</nav>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">						
							 Deposit
						</h3>
						<nav aria-label="breadcrumb"></nav>
					</div>

					<!-- Main content Create Account Form -->
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">Deposit</h4>							

							<form class="form-sample" action="./DepositeAmtFunc"
								method="post" modelAttribute="accountcreation">
								<div class="row">
									<div class="col-md-6">
										<input type="hidden" name="customerId" value=${custId}>
										<label class="col-sm-3 col-form-label">Account Type</label>
										<div class="form-group row">
											<div class="col-sm-9">
												<select class="form-control" name="atype">
													<option value="SAVINGS" selected="selected">Saving</option>
													<option value="CURRENT">Current</option>
													<option value="LOAN">Loan</option>
													<option value="SALARY">Salary</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<label class="col-sm-3 col-form-label">Options</label>
										<div class="form-group row">
											<div class="col-sm-9">
												<select class="form-control" name="tType">
													<option value="DEBIT" selected="selected">Deposit</option>
													<!-- <option value="CREDIT">Withdraw</option>-->
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label class="col-sm-4 col-form-label">Amount</label>
										<div class="form-group row">
											<div class="col-sm-9">
												<input type="number" name="balance" size="20"
													class="form-control">
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<label class="col-sm-4 col-form-label"></label>
										<div class="form-group row">
											<div class="col-sm-9">
												<button type="submit" class="btn btn-primary btn-fw" style="background: #1F3BB3 !important;"
													value=Register>Submit</button>
											</div>
										</div>
									</div>
								</div>
							</form>
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

</body>
</html>