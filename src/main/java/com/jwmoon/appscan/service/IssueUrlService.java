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
import com.jwmoon.appscan.mapper.IssueUrlMapper;
import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.util.CommonUtil;
import com.jwmoon.appscan.model.IssueUrl;



@Service
public class IssueUrlService{
        
    private static Logger log = (Logger) LoggerFactory.getLogger(IssueController.class);
	
	@Autowired
	IssueUrlMapper issueUrlMapper;

	@Autowired
	MessageSource messageSource;
	
       public List<IssueUrl> getIssueUrls(){
           return issueUrlMapper.selectIssueUrls();
       }

    public List<Map<String, String>> getIssueUrlCounts(Locale locale){

        IssueUrl issueUrl = new IssueUrl();
        issueUrl.setNIssues("1");
        int issueCnt = issueUrlMapper.getIssueUrlCounts(issueUrl);
        issueUrl.setNIssues("0");
        int nonIssueCnt = issueUrlMapper.getIssueUrlCounts(issueUrl);
        int totalCnt = issueCnt + nonIssueCnt;

        // calculate percentage
        Double issuePercent = ( (double)issueCnt / (double)totalCnt ) * 100;
        Double nonIssuePercent = ( (double)nonIssueCnt / (double)totalCnt) * 100;

        // 취약한 URL 정보 
        Map<String,String> item = new HashMap<String, String>();
        String label1 = messageSource.getMessage("label.issue.vulnerableUrl", null, locale);
        item.put("name", label1);
        item.put("cnt", String.valueOf(issueCnt));
        item.put("percent", String.valueOf(Math.ceil(issuePercent)));

        // 취약하지 않은 URL 정보 
        Map<String,String> item2 = new HashMap<String, String>();
        String label2 = messageSource.getMessage("label.issue.nonVulnerableUrl", null, locale);
        item2.put("name", label2);
        item2.put("cnt", String.valueOf(nonIssueCnt));
        item2.put("percent", String.valueOf(Math.floor(nonIssuePercent)));

	List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        result.add(item);
        result.add(item2);

        return result;  
    } 
    
}

