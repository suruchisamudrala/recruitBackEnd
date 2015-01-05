<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head><title>Current vacancies</title></head>
  <body>
    <h1>Following jobs have been uploaded in the database</h1>
    <table>
  		<c:forEach items="${jobList}" var="item">
  		<tr>
    		<td>Title</td>
    		<td></td>
    		<td><c:out value="${item.getTitle()}" /></td>
        	<td></td>
    		<td>Location</td>
    		<td></td>
    		<td><c:out value="${item.getLoc()}" /></td>
    	</tr>
    	<tr>
    		<td>Salary</td>
    		<td></td>
    		<td><c:out value="${item.getSalary()}" /></td>
    		<td></td>
    		<td>Line Manager</td>
    		<td></td>
    		<td><c:out value="${item.getManager()}" /></td>
    	</tr>
    	<tr>
    		<td>Band</td>
    		<td></td>
    		<td><c:out value="${item.getBand()}" /></td>
    		<td></td>
    		<td>Directorate</td>
    		<td></td>
    		<td><c:out value="${item.getDirectorate()}" /></td>
    	</tr>
    	<tr>
    		<td>Deadline</td>
    		<td></td>
    		<td><c:out value="${item.getDeadline()}" /></td>
    		<td></td>
    		<td>Assign Key Words</td>
    		<td></td>
    		<td><c:out value="${item.getKeywords()}" /></td>
    	</tr>
    	<tr>
    		<td>Basic Profile</td>
    		<td></td>
    		<td><c:out value="${item.getProfile()}" /></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    	</tr>
    	<tr>
    		<td colspan='3'>Detailed Job Description upload file</td>
    		<td></td>
    		<td><a href="${pageContext.servletContext.contextPath }/PdfServlet?id=${item.getJobId()}">See detailed Job Description here</a></td>
    		<td></td>
    		<td></td>
    	</tr>
  		</c:forEach>
	</table>   	
   </body>
  </html>