<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
  <head><title>Create New Job Form</title></head>
  <body>
    <h1>Please enter below details or upload a PDF to create a new job</h1>
    <div>
    	<h2> ${message} </h2>
    </div>
    <form:form method="POST" action="/recruitBackEnd/createJobForm">
    <table>
    	<tr>
    		<td><form:label path="title">Title</form:label></td>
    		<td></td>
    		<td><form:input path="title" /></td>
        	<td></td>
    		<td><form:label path="loc">Location</form:label></td>
    		<td></td>
    		<td><form:input path="loc" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="salary">Salary</form:label></td>
    		<td></td>
    		<td><form:input path="salary" /></td>
    		<td></td>
    		<td><form:label path="manager">Line Manager</form:label></td>
    		<td></td>
    		<td><form:input path="manager" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="band">Band</form:label></td>
    		<td></td>
    		<td><form:input path="band" /></td>
    		<td></td>
    		<td><form:label path="directorate">Directorate</form:label></td>
    		<td></td>
    		<td><form:input path="directorate" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="deadline">Deadline</form:label></td>
    		<td></td>
    		<td><form:input path="deadline" /></td>
    		<td></td>
    		<td><form:label path="keywords">Assign Key Words</form:label></td>
    		<td></td>
    		<td><form:input path="keywords" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="profile">Basic Profile</form:label></td>
    		<td></td>
    		<td><form:input path="profile" /></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    	</tr>
    	<tr>
    		<td colspan='3'><form:label path="pdfUpldFileName">Upload a file with detailed Job Description</form:label></td>
    		<td></td>
    		<td><form:input path="pdfUpldFileName"/></td>
    		<td></td>
    		<td></td>
    	</tr>
    </table>
    <div>
    	<input type="submit" value="Submit">
    </div>
    
    <div>
    	<a href="recruitBackEnd/jobList">List of uploaded jobs</a>
    </div>
    </form:form>
  </body>
</html>
