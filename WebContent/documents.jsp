<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="wrapper">
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
					 	<li ><a href="createAccount.jsp">Create</a></li>
					 	<li ><a href="AccountsServlet">Accounts</a></li>
				 	</c:when>
				</c:choose>
				 	<c:choose>
			    	<c:when test="${Role.role == 'Client'}">
						<li><a href="DisplaySurvey">Surveys</a></li>
					</c:when>
				</c:choose>
				<li class="active"><a href="documents.jsp">Documents</a></li>
				 <li><a href="LogoutServlet">Log-Out</a></li>
			</li>
			</ul>
	</header>
	
	<div class="postHeader">
		<p>Change Readiness Assessment and Organizational Tool</p>
	</div>
	
	<div class="mainBody">
		<h1>Six S Solutions Change Readiness Documentation</h1>
		<h3>Prepare Stage:</h3>
		
		<p><a href="Documents/1.1.a_ProjectInfoGatheringDocument.pdf">Project Info Gathering</a></p>
		<p><a href="Documents/1.1.b_EndUserDemographicInventory.pdf">End User Demographic Inventory</a></p>
		<p><a href="Documents/1.1.c_ImpactAssessmentWorkbook.pdf">Impact Assessment Workbook</a></p>
		<p><a href="Documents/1.1.d_BenefitsByAudienceMappingTool.pdf">Benefits By Audience Mapping Tool</a></p>
		<p><a href="Documents/1.1.e_StakeholderAnalysisPlanner.pptx.pdf">Stakeholder Analysis Planner</a></p>
		<p><a href="Documents/1.1.f_AwarenessMeasurementSurvey.pdf">Awareness Measurement Survey</a></p>
		<p><a href="Documents/1.1.g_ResistanceAndRiskAnalysis.pdf">Resistance and Risk Analysis</a></p>
		<p><a href="Documents/1.1.h_TrainingAndLearningPlanner.pdf">Training and Learning Planner</a></p>
		<p><a href="Documents/1.1.i_ExternalAudiencesImpactWorkbook.pdf">External Audiences Impact Workbook</a></p>
		<p><a href="Documents/1.1.j_CommunicationsOrganizerTool.pdf">Communications Organizer Tool</a></p>
		<p><a href="Documents/1.1.k_CommunicationsDeploymentPlanner.pdf">Communications Deployment Planner</a></p>
		<p><a href="Documents/1.1.l_ITGlossary.pdf">IT Glossary</a></p>
		<p><a href="Documents/1.2.a_NoElephants.pdf">No Elephants</a></p>
		<p><a href="Documents/1.2.b_The3Es.docx.pdf">The 3 E's</a></p>
		<p><a href="Documents/1.2.c_BasinOfTrust.docx.pdf">Basin of Trust</a></p>
		<p><a href="Documents/1.2.d_FightOrFlight.docx.pdf">Fight or Flight</a></p>
		<p><a href="Documents/1.2.e_RumorResponder.pdf">Rumor Responder</a></p>
		
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
	</div>
	
</body>
</html>