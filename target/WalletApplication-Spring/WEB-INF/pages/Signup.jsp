<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
  </head>

<body>
	
	<div class="container-scroller">
		<div class="container-fluidpage-body-wrapperfull-page-wrapper">
			<div class="container" style="width: 30rem;">
			<div class = "card-body">
			
			<div class= "content-wrapperd-flexalign-items-centerauth">

				<div class="rowflex-grow">

					<div class="col-lg-4mx-auto">

						<div class="auth-form-lighttext-leftp-5">

							<div class="brand-logo">
							</div>

							<h4>Signing up here!</h4>

							<h6 class="font-weight-light">It's just a short process</h6>
							<form class= "pt-3" action= "./registerUser" method="post">

								<div class="form-group">
									<input type= "text" name= "firstName" class= "form-control
										form-control-lg" id= "exampleInputUsername1" placeholder="FirstName">
								</div>

								<div class="form-group">
									<input type= "text" name= "lastName" class= "form-control
										form-control-lg" id= "exampleInputlastName" placeholder="LastName">
								</div>

								<div class="form-group">
									<input type= "text" name= "emailId" class= "form-control
										form-control-lg" id= "exampleInputemailId" placeholder="Email">
								</div>

								<div class="form-group">
									<input type= "number" name= "contactNo" class=
										"form-control form-control-lg" id=
										"exampleInputcontactNo" placeholder="ContactNumber">
								</div>

								<div class="form-group">
									<input type= "text" name= "address.addressLine1" class=
										"form-control form-control-lg" id=
										"exampleInputadd1" placeholder="Address Line 1">
								</div>

								<div class="form-group">
									<input type= "text" name= "address.addressLine2" class="form-control form-control-lg" id="exampleInputadd2" placeholder="Address Line 2">
								</div>
								
								<div class="form-group">
									<select name= "address.city" class= "form-control
										form-control-lg" id="exampleFormControlSelect2">
										<option>City</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Hyderabd">Hyderabd</option>
										<option value="Bangalore">Bangalore</option>
									</select>
								</div>
							
								<div class="form-group">
									<select name= "address.state" class= "form-control
										form-control-lg" id="exampleFormControlSelect2">
										<option>State</option>
										<option value="Maharashtra">Maharashtra</option>
										<option value="Telangana">Telangana</option>
										<option value="Karnataka">Karnataka</option>
									</select>
								</div>
								<div class="form-group">
									<input type= "text" name= "address.pincode" class= "form-control
										form-control-lg" id= "exampleInputUsername1" placeholder="Pincode">
								</div>

								<div class="form-group">
									<input type= "password" name= "password" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Password">
								</div>
									<div class="form-group">
									<input type= "password" name= "conPswd" class="form-control form-control-lg" id="exampleInputUsername1" placeholder="Confirm Password">
								</div>
							

								<div class="form-group">
									<input type= "radio" name= "gender" value="Male">&nbsp;Male
									<input type= "radio" name= "gender" value="Female">&nbsp;Female
									<input type= "radio" name= "gender" value="Other">&nbsp;Other
								</div>

								<div class="mt-3">

									<button class= "btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn
										font-weight-medium auth-form-btn" type= "submit" name="register">Register</button>

								</div>

								<div class="text-centermt-4font-weight-light">
									Already have an account? <a href= "./login" class="text-primary">Login</a>
								</div>
							</form>
							
						</div>

					</div>

				</div>

			</div>
			<!-- content-wrapper ends -->

		</div>

		<!-- page-body-wrapper ends -->

	</div>
	</div>
	</div>

    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <!-- endinject -->

</body>

</html>
"
