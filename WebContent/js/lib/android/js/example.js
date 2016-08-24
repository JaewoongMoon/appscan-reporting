var selectedChartType;

function initControl() {

	selectedChartType = $("#selChartType").val();
}


function printData() {

	 alert("Hello");
	// initControl();

	// drawChart(selectedChartType);
	
	
	drawChart("pie");

}


function pieColors() {
	var colors = [], base = Highcharts.getOptions().colors[0], i;
	for (i = 0; i < 10; i += 1) {
		colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
	}
	return colors;
}

function drawChart(type) {

	var options = {

		credits : {
			enabled : false
		},

		chart : {

			renderTo : 'dvChart',
			type : type
		},
		title : {
			text : 'New Users Info'
		},
		subtitle : {
			text : 'User'
		},
//		xAxis : {
//			categories : [],
//			type : 'datetime'
//		},
//		yAxis : {
//			min : 0,
//			title : {
//				text : 'counter'
//			}
//		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
			}
		},
		series : [{
			name : 'NEW_ACC_CNT'
		}, {
			name : 'NEW_CUSTOMER_CNT'

		}]
	};
	

//	options.xAxis.categories = day;
//	options.xAxis.tickInterval = parseInt(day.length / 3);

	
	if (type == "pie") {
		alert("pie");
		
		var data1 = [['Firefox', 45.0], ['IE', 26.8], ['Safari', 8.5], ['Opera', 6.2], ['Others', 0.7]];
		var data2 = [['Firefox', 45.0], ['IE', 26.8], ['Safari', 8.5], ['Opera', 6.2], ['Others', 0.7]];
		

		options.series[0].name = "New User Counter";
		alert( options.series[0].name );
		
		options.series[0].data = data1;
		alert( options.series[0].data );

		options.series[0].dataLabels = {
			enabled : true,
			format : '<b>{point.y}</b>'
		};
		options.series[0].colors = pieColors();
		alert( options.series[0].colors );
		alert("pie end");

	} else {

		options.series[0].name = "�ű԰�����";
		options.series[0].data = data1;
		options.series[1].name = "�ű԰?��";
		options.series[1].data = data2;
		options.series[0].dataLabels = {
			enabled : true,
			format : '<b>{point.y}</b>'
		};
		options.series[1].dataLabels = {
			enabled : true,
			format : '<b>{point.y}</b>'
		};
	}

	new Highcharts.Chart(options);
}