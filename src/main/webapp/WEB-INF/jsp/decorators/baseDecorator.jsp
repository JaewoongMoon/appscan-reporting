<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/includes/meta.jsp" %>
<title>App Scan : <decorator:title/></title>
<%@ include file="/WEB-INF/jsp/includes/js.jsp" %>
<%@ include file="/WEB-INF/jsp/includes/style.jsp" %>
<decorator:head/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
<%@ include file="/WEB-INF/jsp/includes/navigation.jsp" %>
	
<decorator:body/>

<%@ include file="/WEB-INF/jsp/includes/footer.jsp" %>
<%@ include file="/WEB-INF/jsp/includes/footerJs.jsp" %>
</body>
</html>