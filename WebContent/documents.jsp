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
	<header>
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
			
			<ul class="menu-bar">
				 <li class="active"><a href="index.jsp">${username}</a></li>
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
				<li><a href="documents.jsp">Documents</a></li>
				 <li><a href="LogoutServlet">Log-Out</a></li>
			</li>
			</ul>
		</div>
	</header>
	
	
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