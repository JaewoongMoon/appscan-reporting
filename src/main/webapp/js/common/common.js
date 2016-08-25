/**
 * 
 */
var baseUrl = "http://localhost:8080/appscan-reporting"; //추후 수정요. 서버에 맞게 바뀌도록. 


/*
var jsMessage = function () {
	$.ajax({
		url: baseUrl + "/js/locales/translation.json",
		success: function(data){
			console.log(data);
			return data;
		}
	})
}
*/
// menu bar active 속성
$(document).ready(function(){
	$('a[href="' + this.location.pathname + '"]').parents('li,ul').addClass('active');
});



function ChartSample(chartOption, dataUrl, parseFunc) {
	
	var jsonPath = baseUrl + dataUrl;
		
	$.ajaxSetup({
		cache : false
	});

	$.getJSON(jsonPath, function(data) {
		
		setChartData(chartOption, getRefinedData(data, parseFunc)); 
		drawChart(chartOption);
		
	}).error(function(jqXHR, textStatus, errorThrown) {
		alert("error occured!\nStatus : " + textStatus + "\nError : " + errorThrown);
	});
	
	function getRefinedData(data, refineFunc){
		return $.map(data, refineFunc);
	}
	
	function setChartData(chartOption, chartData){
		chartOption.series[0].data = chartData;
	}
	
	function drawChart(options){
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
