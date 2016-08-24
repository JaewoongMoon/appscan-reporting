/**
 * @ ProjectController.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * com.jwmoon.appscan.controller
 * ProjectController.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

	
	private static Logger log = (Logger) LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
    
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest request){
		List<Project> list = projectService.selectProjects();
		request.setAttribute("list", list);
		return "/project/index";
	}
	
	@RequestMapping("/selectJson")
	public @ResponseBody List<Project> getProjects(){
		return projectService.selectProjects();
	}
	
	@RequestMapping("/detail")
	public String getProjectDetail(HttpServletRequest request){
		String projectId = request.getParameter("projectId");
		Project project = new Project();
		project.setProjectId(Integer.parseInt(projectId));
		
		project = projectService.getProjectDetail(project);
		request.setAttribute("project", project);
		return "/project/detail";
	}

    @RequestMapping("/update")
    public String updateProject(@ModelAttribute("project") Project project, BindingResult bingdingResult){
        log.info("projectName:" + project.getProjectName());
        
        return "/project/detail";
    }
	
}
