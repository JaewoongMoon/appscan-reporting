/**
 * @ IssueController.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jwmoon.appscan.mapper.IssueMapper;
import com.jwmoon.appscan.mapper.IssueTypeMapper;
import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.service.IssueService;
import com.jwmoon.appscan.service.IssueUrlService;
import com.jwmoon.appscan.util.CommonUtil;
import com.jwmoon.framework.db.AppscanDBContext;
import com.jwmoon.framework.db.AppscanDBContextHolder;
import com.jwmoon.framework.project.Project;
import com.jwmoon.framework.project.ProjectService;

import java.util.Locale;
import java.util.List;
import java.util.Map;
import com.jwmoon.appscan.model.IssueUrl;
import java.util.ArrayList;

/**
 * <pre>
 * com.jwmoon.appscan.controller
 * IssueController.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
@Controller
@RequestMapping("/issue")
public class IssueController {

	
	private static Logger log = (Logger) LoggerFactory.getLogger(IssueController.class);
	
	@Autowired
	IssueService issueService;

    @Autowired
    IssueUrlService issueUrlService;
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
	AppscanDBContextHolder appscanDBContextHolder;
	
	@RequestMapping("/select")
	public @ResponseBody List<Issue> getIssues(){
		return issueService.selectIssues();
	}
	
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest request){
		
		// for DBContext select 
		List<Project> list = projectService.selectProjects();
		request.setAttribute("projects", list);
		
		// get sessionDBContext
		AppscanDBContext sessionDBContext = appscanDBContextHolder.getAppscanDBContext(); 
		if( sessionDBContext != null){
			request.setAttribute("dbSelectIdx", sessionDBContext.intValue());
		}
		
		
		
		return "/issue/index";
	}
	
	@RequestMapping("/getIssueCountBySeverity")
	public @ResponseBody List<Map<String, String>> getIssueCountBySeverity(HttpServletRequest request){
		Locale locale = RequestContextUtils.getLocale(request);
		
		return issueService.getIssueCountBySeverity(locale);
	}
	
	@RequestMapping("/getIssueCountByIssueType")
	public @ResponseBody List<Map<String, String>> getIssueCountByIssueType(HttpServletRequest request){
		Locale locale = RequestContextUtils.getLocale(request);
		
		return issueService.getIssueCountByIssueType();
	}
	
	@RequestMapping("/getIssueUrls")
	public @ResponseBody List<IssueUrl> getIssueUrls(HttpServletRequest request){
		Locale locale = RequestContextUtils.getLocale(request);
		
		return issueUrlService.getIssueUrls();
	}
	
	@RequestMapping("/getIssueUrlCounts")
	public @ResponseBody List<Map<String,String>> getIssueUrlCounts(HttpServletRequest request){
		Locale locale = RequestContextUtils.getLocale(request);
		return issueUrlService.getIssueUrlCounts(locale);
	}  
	
}
