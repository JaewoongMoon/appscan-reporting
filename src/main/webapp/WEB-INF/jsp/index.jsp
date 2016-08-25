<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
<title>인덱스</title>
<script type="text/javascript">
$(document).ready(function() {

	bindData();

});
function bindData() {
	var jsonUrl = "http://10.248.90.234:8080/AppScanResult/threatCategoryCount";
	var testUrl = "<%=request.getContextPath()%>/js/lib/android/data/resultDicFunction.json";
	binDataJson('pie', 'container1', jsonUrl);
	
}
function binDataJson(type, render, jsonPath){
	
	$.ajaxSetup({
		cache : false
	});

	$.getJSON(jsonPath, function(data) {
		var acc_cnt = [];
		
		calcData(data, acc_cnt);

		drawChart(type, render, acc_cnt);

	}).error(function(jqXHR, textStatus, errorThrown) {
		alert("error occured!\nStatus : " + textStatus + "\nError : " + errorThrown);
	});
}
function calcData(data, acc_cnt) {

	$.each(data, function(i, item) {
		acc_cnt.push( [item.threatClass, parseInt(item.count)] );
	});
}
function drawChart(type, render, acc_cnt) {

	var options = {

		credits : {
			enabled : false
		},
		chart : {
			height : 300
		},
		title : {
			text : 'SampleTitle'
		},
		subtitle : {
			text : 'SampleSubtitle'
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
			}
		},
		xAxis: {
        categories: true
    	},
		series : [{
			name : 'Sample Series'
		}, 
		]
	};
	
	if (render == "container1") {
		options.chart.type = type;
		options.title.text = "위협분류별 카운트";
		options.subtitle.text = "";
		options.series[0].data = acc_cnt;
		options.series[0].colors = pieColors();
		options.series[0].name = "";
		options.chart.renderTo = render;
		
		new Highcharts.Chart(options);
	}

}
function pieColors() {
	var colors = [], base = Highcharts.getOptions().colors[0], i;
	for ( i = 0; i < 10; i += 1) {
		colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
	}
	return colors;
}

</script>
</head>
<body>
	<div id="container1">
	
	</div>
	<div class="bs-example">
	<table class="table table-striped">
		<tr>
			<th>엔진ID</th>
			<th>이슈명</th>
			<th>invasive</th>
			<th>심각도</th>
			<th>위협분류</th>
			<th>위협분류참고</th>
			<th>복구작업ID</th>
			<th>테스트타입</th>
			<th>shortName</th>
			<th>ID</th>
			<th>cve Id</th>
			<th>cwe Id</th>
		</tr>
		<c:forEach var="issueType" items="${list}">
		<tr>
			<td><c:out value="${issueType.engineId }" /></td>
			<td><c:out value="${issueType.name }" /></td>
			<td><c:out value="${issueType.invasive }" /></td>
			<td><c:out value="${issueType.severity }" /></td>
			<td><c:out value="${issueType.threatClass }" /></td>
			<td><c:out value="${issueType.threatClassReference }" /></td>
			<td><c:out value="${issueType.remediationTypeId }" /></td>
			<td><c:out value="${issueType.testType }" /></td>
			<td><c:out value="${issueType.shortName }" /></td>
			<td><c:out value="${issueType.id }" /></td>
			<td><c:out value="${issueType.cveId }" /></td>
			<td><c:out value="${issueType.cweId }" /></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>