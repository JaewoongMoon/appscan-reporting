/*
 * 1) json 파일 get 2) .getJSON 함수는 비동기 AJAX 통신이기 때문에 .getJSON 함수 내에서 차트를 그리고 테이블을
 * 바인딩해야 한다. 3) 에러가 발생 시 catch하여 alert.
 */

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


function readJson(jsonPath, id, firstTitle, secondTitle) {
	$.getJSON(jsonPath, function(json) {
		
		$(id).html('');
		
		$(id).append('<thead>');
	 	$(id).append('<tr> <th>#</th> ' + firstTitle + secondTitle + ' </tr>');
	 	$(id).append('<tbody>');
	 	
	 	var counter = 0;
	 	$.each( json, function( key, value ) {
	 		counter = counter + 1;
	 		$(id).append('<tr><td>' + counter + '</td>' + '<td>' + key + '</td>' + '<td>' + value + '</td>' + '</tr>');
	 	});	
	 	
	 	$(id).append('</tbody>');
	});
}


function bindData() {
	
	binDataJson('pie', 'container1', "data/resultDicFunction.json");
	binDataJson('line', 'container2', "data/resultDicFunction.json");
	binDataJson('pie', 'container3', "data/resultDicArg.json");
	binDataJson('column', 'container4', "data/resultDicArg.json");
	binDataJson('pie', 'container5', "data/resultDicAsset.json");
	binDataJson('column', 'container6', "data/resultDicAsset.json");
	
	readJson("data/resultPermission.json", "#permission", '<th>Andoird Permission</th>', '<th>Counter</th> ');
	readJson("data/resultOpenSSL.json", "#openSSL", '<th>FILE</th>', '<th>STRING</th> ');
	readJson("data/resultDeviceInfo.json", "#deviceInfo", '<th>Device Name</th>', '<th>Wifi</th> ');
	readJson("data/resultApkInfo.json", "#apkInfo", '<th>Activity Name</th>', '<th>Package Name</th> ');
	
}

function calcData(data, acc_cnt) {

	$.each(data, function(i, item) {
		acc_cnt.push( [i, parseInt(item)] );
	});
}

/*
 * 차트를 그리기 위해 차트 옵션 정보를 정의하고 전역변수인 day, acc_cnt, customer_cnt Array를 차트에 바인딩한다.
 */
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
		options.title.text = "Api Function";
		options.subtitle.text = "";
		options.series[0].data = acc_cnt;
		options.series[0].colors = pieColors();
		options.series[0].name = "";
		options.chart.renderTo = render;
		
		new Highcharts.Chart(options);
	}
	
	if (render == "container2") {
		options.chart.type = type;
		options.title.text = "Api Function";
		options.subtitle.text = "";
		options.series[0].name = "Function Count";
		options.series[0].data = acc_cnt;
		options.series[0].colors = pieColors();
		options.chart.renderTo = render;
		
		options.series[0].dataLabels = {
		enabled : true,
		format : '<b>{point.y}</b>'
		};
		
		new Highcharts.Chart(options);
	}
	
	if (render == "container3") {
		options.chart.type = type;
		options.title.text = "Api argument type";
		options.subtitle.text = "Function Name";
		options.series[0].data = acc_cnt;
		options.series[0].colors = pieColors();
		options.chart.renderTo = render;
		
		new Highcharts.Chart(options);
	} 	 
	
	if (render == "container4") {
		options.chart.type = type;
		options.title.text = "Api argument type";
		options.subtitle.text = "";
		options.series[0].name = "Function Count";
		options.series[0].data = acc_cnt;

		options.series[0].dataLabels = {
		enabled : true,
		format : '<b>{point.y}</b>'
		};
		
		options.chart.renderTo = render;
		
		new Highcharts.Chart(options);
	}
	if (render == "container5") {
		options.chart.type = type;
		options.title.text = "App asset type";
		options.subtitle.text = "";
		options.series[0].data = acc_cnt;
		options.series[0].colors = pieColors();
		options.chart.renderTo = render;
		
		new Highcharts.Chart(options);
	} 	 
	
	if (render == "container6") {
		options.chart.type = type;
		options.title.text = "App asset type";
		options.subtitle.text = "";
		options.series[0].name = "Function Count";
		options.series[0].data = acc_cnt;

		options.series[0].dataLabels = {
		enabled : true,
		format : '<b>{point.y}</b>'
		};

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
