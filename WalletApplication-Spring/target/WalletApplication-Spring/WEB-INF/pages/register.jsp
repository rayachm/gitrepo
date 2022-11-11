<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<hr>
	<div style="float: left; margin-left: 300px;">
		<form action="./registerUser" method="post">
			<table>
				<tr>
					<th colspan="3">Registration form</th>
				</tr>
				<tr>
					<td>FirstName:</td>
					<td><input type="text" name="firstName" size="20"></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName" size="20"></td>
				</tr>
				<tr>
					<td>Address Line1:</td>
					<td><textarea rows="3" cols="20" name="address.addressLine1"></textarea>
					</td>
					<td>
						<div id="erraddressline1" class="errMsg"></div>
					</td>
				</tr>



				<tr>
					<td>Address Line2:</td>
					<td><textarea rows="3" cols="20" name="address.addressLine2"></textarea>
					</td>
					<td>
						<div id="erraddressline2" class="errMsg"></div>
					</td>
				</tr>



				<tr>
					<td>City:</td>
					<td><select name="address.city">
							<option value="Bangalore">Bangalore</option>
							<option value="Hindupur">Hindupur</option>
							<option value="Hyderabad" selected="selected">Hyderabad
							</option>
							<option value="Chennai">Chennai</option>
							<option value="Mumbai">Mumbai</option>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><select name="address.state">
							<option value="Karnataka">Karnataka</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
							<option value="Telangana" selected="selected">Telangana
							</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Maharastra">Maharastra</option>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<td>Pincode:</td>
					<td><input type="number" name="address.pincode" size="20"></td>
				</tr>
				<tr>
					<td>EmailId:</td>
					<td><input type="text" name="emailId" size="20"></td>
				</tr>
				<tr>
					<td>ContactNo:</td>
					<td><input type="number" name="contactNo" size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" size="20"></td>
				</tr>
				<tr>
					<td>ConfirmPassword:</td>
					<td><input type="password" name="conPswd" size="20"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" name="gender" value="Male"
						checked="checked">Male <input type="radio" name="gender"
						value="Female">Female <input type="radio" name="gender"
						value="Other">Other</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" value=Register>Register</button>
						<button type="reset" value=Clear>Clear</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
</html>