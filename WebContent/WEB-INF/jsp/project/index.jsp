<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.page.project.title"/></title>
<%
	
%>
<script type="text/javascript">
$(document).ready(function(){
	
});

function goDetail(projectId){
	location.href="<%=request.getContextPath()%>/project/detail?projectId="+projectId;
}
</script>
</head>
<body>
	<form id="detailFrom" method="POST">
	</form>
	<div class="container">
		<table class="table table-striped">
		<tr>
			<th><spring:message code="label.page.project.projectId"/></th>
			<th><spring:message code="label.page.project.projectName"/></th>
			<th><spring:message code="label.page.project.startDate"/></th>
			<th><spring:message code="label.page.project.endDate"/></th>
			<th><spring:message code="label.page.project.dbPath"/></th>
			<th><spring:message code="label.page.project.customerName"/></th>
			<th><spring:message code="label.page.project.projectUrl"/></th>
			<th><spring:message code="label.page.project.note"/></th>
		</tr>
		<c:forEach var="project" items="${list}">
		<tr>
			<td><c:out value="${project.projectId }" /></td>
			<td><a href="javascript:goDetail('${project.projectId}')"><c:out value="${project.projectName }" /></a></td>
			<td><c:out value="${project.startDate}" /></td>
			<td><c:out value="${project.endDate }" /></td>
			<td><c:out value="${project.dbPath }" /></td>
			<td><c:out value="${project.customerName}" /></td>
			<td><c:out value="${project.projectUrl }" /></td>
			<td><c:out value="${project.note }" /></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
