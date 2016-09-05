/**
 * @ IssueService.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

import com.jwmoon.appscan.controller.IssueController;
import com.jwmoon.appscan.mapper.IssueMapper;
import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.util.CommonUtil;

/**
 * <pre>
 * com.jwmoon.appscan.service
 * IssueService.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 1.
 */
@Service
public class IssueService {

	private static Logger log = (Logger) LoggerFactory.getLogger(IssueController.class);
	
	@Autowired
	IssueMapper issueMapper;

	@Autowired
	MessageSource messageSource;
	
	public @ResponseBody List<Issue> selectIssues(){
		return issueMapper.selectIssues();
	}
	
	public List<Map<String, String>> getIssueCountBySeverity(Locale locale){
		
        //String msg = CommonUtil.getLocaleMessage(request, "label.issue.severity.high");
		String high = messageSource.getMessage("label.issue.severity.high", null, locale);
		String medium = messageSource.getMessage("label.issue.severity.medium", null, locale);
		String low = messageSource.getMessage("label.issue.severity.low", null, locale);
		String info = messageSource.getMessage("label.issue.severity.info", null, locale);
		
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("severity", "3");
        m1.put("severityName", high);
        m1.put("count", "0");
        
        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("severity", "2");
        m2.put("severityName", medium);
        m2.put("count", "0");

        Map<String, String> m3 = new HashMap<String, String>();
        m3.put("severity", "1");
        m3.put("severityName", low);
        m3.put("count", "0");

        Map<String, String> m4 = new HashMap<String, String>();
        m4.put("severity", "0");
        m4.put("severityName", info);
        m4.put("count", "0");
        
        List<Map<String, String>> source = issueMapper.getIssueCountBySeverity();
        
        for (Map<String, String> item : source){
        	String severity = String.valueOf(item.get("SEVERITY"));
        	String count = String.valueOf(item.get("COUNT"));
        	if(severity.equals("3")){
        		m1.put("count", count);
        	}else if(severity.equals("2")){
        		m2.put("count", count);
        	}else if(severity.equals("1")){
        		m3.put("count", count);
        	}else if(severity.equals("0")){
        		m4.put("count", count);
        	}
        }
        
        result.add(m1);
        result.add(m2);
        result.add(m3);
        result.add(m4);
        
		return result;
	}
	
	public List<Map<String, String>> getIssueCountByIssueType(Issue issue){
		return issueMapper.getIssueCountByIssueType(issue);
	}
	
	
}
