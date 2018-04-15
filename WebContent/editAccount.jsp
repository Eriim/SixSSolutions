<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Edit Account</title>
</head>
<body>
	<header>
		<div id ="headerTitles">
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
		</div>	
		<ul class="menu-bar">
		  			 <li ><a href="index.jsp">${username}</a></li>
				 	<c:choose>
			    		<c:when test="${Role.role =='Consultant' || Role.role == 'Admin'}">
					 	<li ><a href="createAccount.jsp">Create</a></li>
					 	<li class="active"><a href="AccountsServlet">Accounts</a></li>
				 	</c:when>
				</c:choose>
					<li><a href="documents.jsp">Documents</a></li>
				 <li><a href="LogoutServlet">Log-Out</a></li>
		</ul>
	
	</header>
	<div id="mainBody">
	<h1 class="title">Edit Account</h1>
		<p class="error">${error}</p>
	<form class = "form" action="EditAccountServlet" method = "post">
	
		<label for = "username">Username</label>
		<input type="text" name = "username" value="${username}"><br>
		<label for = "email">Email</label>
		<input type="text" name = "email" value="${email}"><br>
		<label for = "phone">Phone Number</label>
		<input type="text" name = "phonenumber"  value="${phonenumber}">
		<label for = "firstN">First Name</label>
		<input type="text" name = "firstname"  value="${firstname}"><br>
		<label for = "lastN">Last Name</label>
		<input type="text" name = "lastname" value="${lastname}"><br>
		<input type="hidden" type="text" name = "accountID" value="${accountid}">
		<input type = "submit" name = "submit" value = "Save Account Edits" class="sixSBtn">
	</form>
	</div>
		
	<footer>
	
	<div class="address">
	<h3>Contact Us</h3>
	<p>Phone: 1-866-579-7497<br>Fax: 1-888-240-4866<br>Email: info@sixspartners.com<br>Website: www.sixspartners.com</p>
	</div>
	<div class="address">
	<p><br><br><br>&copy; Six S Partners</p>
	</div>
	</footer>
</body>
</html>