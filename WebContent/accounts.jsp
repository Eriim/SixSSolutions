<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<script>
	
	function deleteAlert(){
			
			var list = document.getElementsByClassName("callAlert");
			
			for(var i = 0; i < list.length; i++)
				{
					list[i].addEventListener("click",function(){
						var answer = confirm("Are you sure you want to delete this account?!")
						if (answer) {
						    return true;
						}
						else {
						    return false
						}
					});
				
				}
		}

</script>
</head>
<body>
	<header>
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
			
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
		</div>
	</header>
			<p>${message}</p>
	
	<div class="mainBody">
			
			<h3>All clients on portal:</h3>
		<c:choose>
			
		    <c:when test="${clients.isEmpty()}">
		    		<p>No clients in database!</p>
					
			</c:when>    
	    	<c:otherwise>
	    		
				
	    		<table>
	    				<tr>
	    					<th>Name</th>
	    					<th>Email</th>
	    					<th>Phone Number</th>
	    					<th>Company Name</th>
	    					<th>Address</th>
	    					<th>Postal/Zip Code</th>
	    					<th>Shipping Address</th>
	    					<th>Province/State</th>
	    					<th>Country</th>
	    				</tr>
	    			<c:forEach items="${clients}" var="client">
	    				<tr>
	    					<td>${client.account.firstnamecontact} ${client.account.lastnamecontact}</td>
	    					<td>${client.account.email}</td>
	    					<td>${client.account.phonenumber}</td>
	    					<td>${client.companyname}</td>
	    					<td>${client.address}</td>
	    					<td>${client.postalzipcode}</td>
	    					<td>${client.shippingaddress}</td>
	    					<td>${client.provincestate.name}</td>
	    					<td>${client.country.country}</td>
	    					<td><a href="DeleteServlet?accountID=<c:out value="${client.account.accountid}"></c:out>" class="callAlert">
	    					Delete Account</a></td>
	    					<td><a href="EditAccountServlet?accountID=<c:out value="${client.account.accountid}"></c:out>" >
	    					Edit Account</a></td>
	    					<td><form action="LoadClientSurveyServlet" method="post">
	    					<input type="hidden" value = "${client.account.accountid}" name="accountid" >
	    					<input type="submit" value="View Surveys" >
	    					</form>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    	</c:otherwise>
	    	
		</c:choose>
		<h3>All consultants on portal:</h3>
		<c:choose>
			
		    <c:when test="${consultants.isEmpty()}">
		    		<p>No consultants in database!</p>
					
			</c:when>    
	    	<c:otherwise>
	    			
			
	    		<table>
	    				<tr>
	    					<th>Name</th>
	    					<th>Email</th>
	    					<th>Phone Number</th>
	    					<th>Work Phone Number</th>
	    				</tr>
	    			<c:forEach items="${consultants}" var="consultant">
	    				<tr>
	    					<td>${consultant.account.firstnamecontact} ${consultant.account.lastnamecontact}</td>
	    					<td>${consultant.account.email}</td>
	    					<td>${consultant.account.phonenumber}</td>
	    					<td>${consultant.workphone}</td>
	    					<td><a href="DeleteServlet?accountID=<c:out value="${consultant.account.accountid}"></c:out>" class="callAlert">
	    					Delete Account</a></td>
	    					<td><a href="EditAccountServlet?accountID=<c:out value="${consultant.account.accountid}"></c:out>">
	    					Edit Account</a></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    	</c:otherwise>
	    	
		</c:choose>
		<h3>All admins on portal:</h3>
		<c:choose>
			
		    <c:when test="${admins.isEmpty()}">
		    		<p>No admins in database! (This shouldn't happen)</p>
					
			</c:when>    
	    	<c:otherwise>
				
	    		<table>
	    				<tr>
	    					<th>Name</th>
	    					<th>Email</th>
	    					<th>Phone Number</th>
	    					<th>Work Phone Number</th>
	    				</tr>
	    			<c:forEach items="${admins}" var="admin">
	    				<tr>
	    					<td>${admin.account.firstnamecontact} ${admin.account.lastnamecontact}</td>
	    					<td>${admin.account.email}</td>
	    					<td>${admin.account.phonenumber}</td>
	    					<td>${admin.workphone}</td>
	    					<td><a href="DeleteServlet?accountID=<c:out value="${admin.account.accountid}"></c:out>"  class="callAlert">
	    					Delete Account</a></td>
	    					<td><a href="EditAccountServlet?accountID=<c:out value="${admin.account.accountid}"></c:out>" >
	    					Edit Account</a></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    	</c:otherwise>
	    	
		</c:choose>
	
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
	
	<script>
		deleteAlert();
	</script>
	
</body>
</html>