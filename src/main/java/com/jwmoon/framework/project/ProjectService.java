/**
 * @ ProjectService.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.project;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * com.jwmoon.appscan.service
 * ProjectService.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 1.
 */
@Service
public class ProjectService {

	private static Logger log = (Logger) LoggerFactory.getLogger(ProjectService.class);
	
	@Autowired
	ProjectMapper projectMapper;

	/*
	@Autowired
	MessageSource messageSource;
	*/
	
	public List<Project> selectProjects(){
		log.info("프로젝트 리스트를 조회합니다...");
		return projectMapper.selectProjects();
	}
	
	public Project getProjectDetail(Project project){
		log.info("프로젝트 Detail을 조회합니다...");
		return projectMapper.getProjectDetail(project);
	}

}
