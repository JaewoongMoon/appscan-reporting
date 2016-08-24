<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript">

$.i18n.init({
	lng : locale(),
	debug: true,
	useLocaleStorage: false,
	localStorageExpirationTime : 86400000, // in ms, default 1 week
	ns : {
		namespaces : ['navigation', 'chart'],
		defaultNs : 'chart'
	},
	resStore : {
		"ko" : {
			"navigation" : {
				"test" : "테스트"
			}, 
			"chart" : {
				"cntBySeverity" : "중요도별 건수",
				"cnt" : "건수",
				"cntByIssueType" : "문제타입별 건수",
				"percentage" : "비율",
				"percentageByIssueUrl" : "취약한 URL 과 취약하지 않은 URL"
			}
		},
		"ja" : {
			"navigation" : {
				"test" : "テスト"
			}, 
			"chart" : {
				"cntBySeverity" : "重要度別件数",
				"cnt" : "件数",
				"cntByIssueType" : "問題タイプ別のセキュリティー上の問題",
				"percentage" : "比率",
				"percentageByIssueUrl" : "脆弱性あるURLと脆弱性ないURL"
			}
		}
	},
	//resGetPath : '<%=request.getContextPath() %>/js/locales/translation.json',
	//"backend": { "loadPath": "/locales/translation.json"}*/
	}, function () {
		$(".chart1").i18n();
	});
	
	// i18n.options.resStore.ko.chart.cntBySeverity 와 같은 식으로 접근해서 데이터를 사용가능하긴 함. 
	function i18nMessage(ns, key){
		return i18n.options.resStore[locale()][ns][key];
	}
	function locale(){
		if (navigator.language != null){
			return navigator.language; 
		}else if (navigator.browserLanguage != null){
			return navigator.browserLanguage;
		}else if (navigator.systemLanguage != null){
			return navigator.systemLanguage;
		}else{
			return "ja"; //default
		}
	};
</script>
