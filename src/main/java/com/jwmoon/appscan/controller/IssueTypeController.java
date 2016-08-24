/**
 * @ IssueController.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwmoon.appscan.mapper.IssueMapper;
import com.jwmoon.appscan.mapper.IssueTypeMapper;
import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.model.IssueType;

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
@RequestMapping("/issueType")
public class IssueTypeController {
	
	@Autowired
	IssueTypeMapper issueTypeMapper;
	
	
	@RequestMapping("/select")
	public @ResponseBody List<IssueType> getIssueTypes(){
		return issueTypeMapper.selectIssueTypes();
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "index";
	}
		
}
