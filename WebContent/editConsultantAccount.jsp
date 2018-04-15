<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Consultant Account</title>
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
			</li>
			</ul>
	
	</header>
	<div id="mainBody">
	<h1 class="title">Edit Consultant Account: ${name}</h1>
		<p class="error">${error}</p>
	
	
	<form class = "form" action="EditConsultantServlet" method = "post">
		
		<input type="hidden" name = "accountid" value="${accountid}"><br>
		<label for = "workPhone">Work Phone</label>
		<input type="text" name = "workPhone" value="${workphone}"><br>
	
			<c:choose>
			    	<c:when test="${admin == false}">
					 	<label for = "isAdmin">Admin</label>
						<input type="radio" name = "isAdmin" value="true">Yes<br>
				 	</c:when>
			</c:choose>
		<input type = "submit" name = "submit" value = "Save Consultant" class="sixSBtn">
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