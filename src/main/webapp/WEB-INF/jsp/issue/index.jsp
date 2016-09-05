<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.page.issue.title"/></title>
<%
	
%>
<script type="text/javascript">
$(document).ready(function(){
	 // select db context
	$("#db-select").change(function(){
		console.log($("#db-select option:selected").val());
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/changeDBContext",
			data : {"dbNum" : $("#db-select option:selected").val()}
		}).done(function(){
			//location.reload();	
			$("#form").submit();
		});
		
	});
	drawChart1();
	drawChart2();
    drawChart3();
  
     $.getJSON("<%=request.getContextPath()%>/issue/getIssueUrls", 
    		 function(json){
    	 //$("#table1")
    	 var id = "#table1";
    	 //console.log(json);
    	 $(id).append('<tbody>');
    	 $.each( json, function( i, item ) {
    		 $(id).append('<tr><td>' + item.fullPath + '</td>' + '<td>' + item.nissues + '</td>' + '<td>' + item.nremediations + '</td>' + '</tr>');
    	 });
    	 $(id).append('</tbody>');
     });



	 $.getJSON("<%=request.getContextPath()%>/issue/getIssueCountByIssueTypeAndSeverity?severity=1", 
    		   function(json){

    			   var id = "#table-severity-1";
    			   $(id).append('<tbody>');
    			   $.each( json, function( i, item ) {
    				   $(id).append('<tr><td></td>' + '<td>' + item.NAME + '</td>' + '<td>' + item.CNT + '</td>' + '</tr>');
    			   });
    			   $(id).append('</tbody>');
			   });
     
})

var drawChart1 = function (){
	
	var options = {
		credits : {
			enabled : false
		},
		chart : {
			height : 600,
			type : "column",
			renderTo: "graph1"
		},
		title : {
			text : i18nMessage("chart", "cntBySeverity")
		},
		subtitle : {
			text : ''
		},
		plotOptions : {
		},
		xAxis: {
        	categories: true
    	},
		series : [{
			name : i18nMessage("chart", "cnt"),
			colorByPoint : true,
			dataLabels : {
					enabled : true,
					format : '<b>{point.y}</b>'
					},
			colors : ["#ff0000", "#ff6600", "#ffcc00", "#666699", "#006995"]
		}]
	};
	
	new ChartSample(options, "/issue/getIssueCountBySeverity", function(item, i){
            
		return [[item.severityName, parseInt(item.count)]];
	});
	
};

var drawChart2 = function (){
	
	var options = {
			credits : {
				enabled : false
			},
			chart : {
				height : 600,
				type : "bar",
				renderTo: "graph2"
			},
			title : {
				text : i18nMessage("chart", "cntByIssueType")
			},
			subtitle : {
				text : ''
			},
			plotOptions : {
			},
			xAxis: {
	        	categories: true
	    	},
			series : [{
				name : i18nMessage("chart", "cnt"),
				dataLabels : {
						enabled : true,
						format : '<b>{point.y}</b>'
						}
			}]
		};
	
	new ChartSample(options, "/issue/getIssueCountByIssueType", function(item, i){
		return [[item.NAME, parseInt(item.CNT)]];
	});
	
};

	
 var drawChart3 = function (){
     
     var options = {
	 credits : {
	     enabled : false
	 },
	 chart : {
	     height : 600,
	     type : "pie",
	     renderTo: "graph3"
	 },
	 title : {
	     text : i18nMessage("chart", "percentageByIssueUrl")
	 },
	 subtitle : {
	     text : ''
	 },
	 plotOptions : {
             pie : {
                 allowPointSelect: true,
                 cursor: 'pointer',
                 dataLabels: {
                     enabled: true
                 },
                },
             showInLegend: true
	 },
	 xAxis: {
	     categories: true
	 },
	 series : [{
	     name : i18nMessage("chart", "percentage"),
	     dataLabels : {
		 enabled : true,
		 format : '<b>{point.name}</b>: {point.percentage:.1f} %'
	     }
	 }]
     };
     
     new ChartSample(options, "/issue/getIssueUrlCounts", function(item, i){
	 return [[item.name, parseInt(item.percent)]]; 
     });
     
 };

</script>
</head>
<body>
	<div class="container">
		<form id="form" method="POST" action="<%=request.getContextPath()%>/issue/index">
			<input type="hidden" value="<c:out value="${dbSelectIdx}"/>"/>
		<spring:message code="label.page.issue.projectselect"/>
		<select id="db-select" name="db-select">
			<c:forEach var="project" items="${projects}">
			<option value="${project.projectId}" <c:if test="${dbSelectIdx eq project.projectId}">selected</c:if>>
			<c:out value="${project.projectName}" /></option>
			</c:forEach>
		</select>
		</form>
		<div id="graph1">
		
		</div>
		
		<div id="graph2">
		
		</div>
		<div id="graph3">
		
		</div>
    <table id="table1" class="table">
        <thead>
            <tr>
                <th>URL</th>
                <th><spring:message code="label.issue.name"/></th>
                <th><spring:message code="label.issueType.name"/></th>
            </tr>
        </thead>
    </table>

	<table id="table-severity-1" class="table">
		<thead>
			<tr>
                <th>URL</th>
                <th><spring:message code="label.issue.name"/></th>
                <th><spring:message code="label.issueType.name"/></th>
			</tr>
		</thead>
	</table>
       <!-- i18n 테스트 : 추후 필요시 사용   
		<div class="chart1">
			<ul>
			<li data-i18n="chart:cntBySeverity"></li>
			<li data-i18n="chart:cnt"></li>
			</ul>
			<ul>
				<li data-i18n="navigation:test"></li>
			</ul>
		</div>
		-->
	</div>
</body>
</html>
