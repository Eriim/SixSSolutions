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

	<div class="mainHeader">
		<p><img class="headerIcon" src="images/phone-icon.png" alt="headerIcon" height="12px" width="12px" style="float: left;" />+1.866.579.7497</p> 
		<p><img class="headerIcon" src="images/fax.png" alt="headerIcon" height="12px" width="12px" style="float: left;" />+1.888.240.4866</p>
		<p><img class="headerIcon" src="images/mail.png" alt="headerIcon" height="12px" width="12px" style="float: left;" /><a href="mailto:info@sixspartners.com" style="color:white;">info@sixspartners.com</a></p>
	</div>
	
	<header>		
			<ul class="menu-bar">
					 <li ><a href="index.jsp">${username}</a></li>
					 <img class="mainLogo" src="images/SixSLogo.png" alt="PageLogo" style="float: left; margin-left: 5px;">
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
	
	<div class="postHeader">
		<p>Change Readiness Assessment and Organizational Tool</p>
	</div>
	
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
	    					<input type="submit" value="View Surveys" class="sixSBtn">
	    					</form></td>
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
	    					<c:choose>		
			   					 <c:when test="${consultant.account.accountid != 1}">
			    					<td><a href="DeleteServlet?accountID=<c:out value="${consultant.account.accountid}"></c:out>" class="callAlert">
			    					Delete Account</a></td>
		    					</c:when>
	    					</c:choose>
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
	    				<c:choose>		
		   					 <c:when test="${admin.account.accountid != 1}">
		    					<td><a href="DeleteServlet?accountID=<c:out value="${admin.account.accountid}"></c:out>"  class="callAlert">
		    					Delete Account</a></td>
	    					</c:when>
	    				</c:choose>
	    					<td><a href="EditAccountServlet?accountID=<c:out value="${admin.account.accountid}"></c:out>" >
	    					Edit Account</a></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    	</c:otherwise>
		</c:choose>
	</div>
	
	
	
	<footer>
	<div class="preFooterContainer">
		<ul class="preFooter">
		   	 <li><a href="https://sixspartners.com/who-are-we/">Who Are We?</a></li>
			 <li><a href="https://sixspartners.com/services/">Service</a></li>
			 <li><a href="https://sixspartners.com/products/">Products</a></li>
			 <li><a href="https://sixspartners.com/industries/">Industries</a></li>
			 <li><a href="https://sixspartners.com/education/">Education</a></li>
			 <li><a href="https://sixspartners.com/our-clients/">Our Clients</a></li>
			 <li><a href="https://sixspartners.com/events/">Events</a></li>
		</ul>
	</div>
	<div class="container">
		<div>
			<span style="float: left; width:20%">
				<img class="footerIcon" src="images/location.png" alt="locatonIcon" height="20px" width="20px" style="float: left;"/>
			</span>
			<span style="float: right; width:80%">
			<p class="footHeader"><b>Headquarters Address:</b></p>
			<p>554 Parkside Drive</p>
			<p>Waterloo, Ontario, Canada</p>
			<p>N2L 5Z4</p>
			</span>
		</div>
		<div class="span_2 column">
			<span style="float: left; width:"20%">
				<img class="footerIcon" src="images/location.png" alt="locatonIcon" height="20px" width="20px" style="float: left;" />
			</span>
			<span style="float: right;" width:"80%">
			<p class="footHeader"><b>US Mailing Address:</b></p>
			<p>PO Box 213</p>
			<p>Wind Gap, PA</p>
			<p>18091</p>
			</span>
		</div>
		<div class="span_3 column">
			<span style="float: left; width:"20%;">
				<img class="footerIcon" src="images/location.png" alt="locatonIcon" height="20px" width="20px" style="float: left;" />
			</span>
			<span style="float: right; width:"80%">
			<p class="footHeader"><b>Canadian Mailing Address:</b></p>
			<p>510 Innsbruck Place</p>
			<p>Waterloo, Ontario, Canada</p>
			<p>N2V 2N9</p>
			</span>
		</div>
		<div class="span_4 column">
			<span style="float: left; width:"20%;">
				<img class="footerIcon" src="images/phone-icon.png" alt="locatonIcon" height="20px" width="20px" style="float: left;" />
			</span>
			<p class="footHeader"><b>Phone: +1.866.579.7497</b></p>
			<span style="float: left; width:"20%;">
				<img class="footerIcon" src="images/fax.png" alt="locatonIcon" height="20px" width="20px" style="float: left;" />
			</span>
			<p><b>Fax: +1.888.240.4866</b></p>
			<span style="float: left; width:"10%;">
				<img class="footerIcon" src="images/mail.png" alt="locatonIcon" height="20px" width="20px"/>
			</span>
			<p><b>Email: <a href="mailto:info@sixspartners.com" style="color:white;">info@sixspartners.com</a></b></p>
			<span style="float: left; width:"10%;">
				<img class="footerIcon" src="images/domain.png" alt="locatonIcon" height="20px" width="20px" />
			</span>
			<p><b>Website:<a href="https://sixspartners.com/" style="color:white;"> www.sixspartners.com</a></b></p>
		</div>
	</div>
	<div class="postFooter">
		<p><b>Copyright Six S. Parnters - All Rights Reserved</b><p>
	</div>
	</footer>
	
	
	<script>
		deleteAlert();
	</script>
	
</body>
</html>