<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="style.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Client Account</title>
</head>
<body>
	<div class="mainHeader">
		<p><img class="headerIcon" src="images/phone-icon.png" alt="headerIcon" height="12px" width="12px" style="float: left;" />+1.866.579.7497</p> 
		<p><img class="headerIcon" src="images/fax.png" alt="headerIcon" height="12px" width="12px" style="float: left;" />+1.888.240.4866</p>
		<p><img class="headerIcon" src="images/mail.png" alt="headerIcon" height="12px" width="12px" style="float: left;" /><a href="mailto:info@sixspartners.com" style="color:white;">info@sixspartners.com</a></p>
	</div>
	
	<header>	 
			 <ul class="menu-bar">
				 <li><a href="index.jsp">${username}</a></li>
				 <img class="mainLogo" src="images/SixSLogo.png" alt="PageLogo" style="float: left; margin-left: 5px;">
				 	<c:choose>
			    		<c:when test="${Role.role =='Consultant' || Role.role == 'Admin'}">
					 	<li  class="active"><a href="createAccount.jsp">Create</a></li>
					 	<li ><a href="AccountsServlet">Accounts</a></li>
				 	</c:when>
				</c:choose>
				<li><a href="documents.jsp">Documents</a></li>
				 <li><a href="LogoutServlet">Log-Out</a></li>
			</li>
			</ul>
	</header>
	
	<div class="postHeader">
		<p>Change Readiness Assessment and Organizational Tool</p>
	</div>
	
	<div id="mainBody">
	<h1 class="title">Create Client Account: ${name}</h1>
		<p class="error">${error}</p>
	<form class = "form" action="CreateClientServlet" method = "post">
		<label for = "companyName">Company Name</label>
		<input type="text" name = "companyName" value=${companyName}><br>
		<label for = "country">Country</label>
		<select name="country">
			<option value="${country}">${country}</option>
			<option value="CAN">CAN</option>
			<option value="USA">USA</option>			
		</select><br>
		<label for = "provinceState">Province/State</label>
		<select name="provinceState">
		<option value="${provinceState}">${provinceState}</option>
			<optgroup label="U.S. States/Territories">
				<option value="AK">Alaska</option>
				<option value="AL">Alabama</option>
				<option value="AR">Arkansas</option>
				<option value="AZ">Arizona</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DC">District of Columbia</option>
				<option value="DE">Delaware</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="IA">Iowa</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="MA">Massachusetts</option>
				<option value="MD">Maryland</option>
				<option value="ME">Maine</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MO">Missouri</option>
				<option value="MS">Mississippi</option>
				<option value="MT">Montana</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="NE">Nebraska</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NV">Nevada</option>
				<option value="NY">New York</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="PR">Puerto Rico</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VA">Virginia</option>
				<option value="VT">Vermont</option>
				<option value="WA">Washington</option>
				<option value="WI">Wisconsin</option>
				<option value="WV">West Virginia</option>
				<option value="WY">Wyoming</option>
			</optgroup>
			<optgroup label="Canadian Provinces">
				<option value="AB">Alberta</option>
				<option value="BC">British Columbia</option>
				<option value="MB">Manitoba</option>
				<option value="NB">New Brunswick</option>
				<option value="NF">Newfoundland</option>
				<option value="NT">Northwest Territories</option>
				<option value="NS">Nova Scotia</option>
				<option value="NU">Nunavut</option>
				<option value="ON">Ontario</option>
				<option value="PE">Prince Edward Island</option>
				<option value="QC">Quebec</option>
				<option value="SK">Saskatchewan</option>
				<option value="YT">Yukon Territory</option>
			</optgroup>
		</select><br>
		<label for = "address">Address</label>
		<input input class="InputClientAcc" type="text" name = "address" value="${address}">
		<label for = "postalZipCode">Postal Code</label>
		<input input class="InputClientAcc" type="text" name = "postalZipCode" value="${postalZipCode}"><br>
		<label for = "shippingAddress">Shipping Address</label>
		<input input class="InputClientAcc"type="text" name = "shippingAddress" value="${shippingAddress}"><br>
		<input type = "submit" name = "submit" value = "Create Client" class="sixSBtn">
	</form>
	</div>
		
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
	
	<footer>
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
	</footer>
	<div class="postFooter">
		<p><b>Copyright Six S. Parnters - All Rights Reserved</b><p>
	</div>
	
</body>
</html>