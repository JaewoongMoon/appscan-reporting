package com.jwmoon.appscan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwmoon.appscan.mapper.IssueTypeMapper;
import com.jwmoon.appscan.model.IssueType;
import com.jwmoon.framework.db.AppscanDBContext;
import com.jwmoon.framework.db.AppscanDBContextHolder;
import com.jwmoon.framework.db.AppscanDBRoutingDataSource;

@Controller
@RequestMapping({"/", "index"})
public class DefaultController{
    
	private static Logger log = (Logger) LoggerFactory.getLogger(DefaultController.class);
	
	@Autowired
	IssueTypeMapper issueTypeMapper;
	
	//@Autowired
	//AppscanDBRoutingDataSource dataSource;
	
	@Autowired
	AppscanDBContextHolder appscanDBContextHolder;
	
	
//	@Value("#{commonprop['common.mail.contact.sendMailPeople']}")
//	private String sendMailPeople;
	
	@RequestMapping("/index")
	public String indexPage(HttpServletRequest request){
		log.info("컨트롤러 실행...");
		log.info("mapper null 여부 : " + (issueTypeMapper == null));
		List<IssueType> list = issueTypeMapper.selectIssueTypes();
		log.info("list 사이즈 : " + list.size());
		
		request.setAttribute("list", list);
		
		return "index";
	}
	
	@RequestMapping("/indexJson")
	public @ResponseBody List<IssueType> getJsonTest(){
		List<IssueType> list = issueTypeMapper.selectIssueTypes();
		
		return list;
	}
	
	@RequestMapping("/threatCategoryCount")
	public @ResponseBody List<Map> getThreatCategoryCount(){
		List<IssueType> list = issueTypeMapper.selectIssueTypes();
		List<Map> resultList = new ArrayList<Map>();
		
		for (IssueType issueType: list){
			Map<String, String> map = new HashMap<String,String>();
			map.put("threatClass", issueType.getThreatClass());
		}
		
		// 더미 데이터
		Map<String, String> map = new HashMap<String,String>();
		map.put("threatClass", "情報漏えい");
		map.put("count", "6");
		
		Map<String, String> map2 = new HashMap<String,String>();
		map2.put("threatClass", "OS コマンド実行");
		map2.put("count", "3");
		
		Map<String, String> map3 = new HashMap<String,String>();
		map3.put("threatClass", "クロスサイト・スクリプティング");
		map3.put("count", "1");
		
		resultList.add(map);
		resultList.add(map2);
		resultList.add(map3);
		return resultList;
	}
	
	@RequestMapping("/viewDBContext")
	public void viewDBContext(HttpServletRequest request){
		log.info("현재 세션 ID : " + request.getSession().getId());
		log.info("현재 DB Context : " + appscanDBContextHolder.getAppscanDBContext());
	}
	
	@RequestMapping("/changeDBContext")
	public  @ResponseBody void changeDBContext(HttpServletRequest request){
		
		String dbContext = request.getParameter("dbNum");
		if(dbContext != null){
			appscanDBContextHolder.setAppscanDBContext(
					AppscanDBContext.valueOf(Integer.parseInt(dbContext)));
		}
		
		log.info("ChnageDBContext to: " + appscanDBContextHolder.getAppscanDBContext());
	} 
}

