<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.page.project.title"/></title>
<%
	
%>
<script type="text/javascript">
$(document).ready(function(){
	$("button.btn-default").click(function(){
		location.href="<%=request.getContextPath()%>/project/index";
	});
	$("button.btn-primary").click(function(){
		document.projectForm.action = "<%=request.getContextPath()%>/project/update";
		document.projectForm.submit();
	});
});
</script>
</head>
<body>
	<div class="container">
	<sf:errors element="p" />
	   <sf:form name="projectForm" modelAttribute="project" method="POST" >
		<table class="table table-striped">
		<tbody>
		<tr>
			<th><spring:message code="label.page.project.projectId"/></th>
			<td><input type="text" name="projectId" value="${project.projectId}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.projectName"/></th>
			<td><input type="text" name="projectName" value="${project.projectName}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.startDate"/></th>
			<td><input type="text" name="startDate" value="${project.startDate}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.endDate"/></th>
			<td><input type="text" name="endDate" value="<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd" />" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.dbPath"/></th>
			<td><input type="text" name="dbPath" value="${project.dbPath}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.customerName"/></th>
			<td><input type="text" name="customerName" value="${project.customerName}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.projectUrl"/></th>
			<td><input type="text" name="projectUrl" value="${project.projectUrl}" class="col-sm-10"/></td>
		</tr>
		<tr>
			<th><spring:message code="label.page.project.note"/></th>
			<td><input type="text" name="note" value="${project.note}" class="col-sm-10"/></td>
		</tr>
		
		</tbody>
	  </table>
	  <div class="text-center">
	  	<button type="button" class="btn btn-primary"><spring:message code="label.button.modify"/></button>
	  	<button type="button" class="btn btn-default"><spring:message code="label.button.moveback"/></button>
	  </div>
	</sf:form>
	</div>
</body>
</html>
