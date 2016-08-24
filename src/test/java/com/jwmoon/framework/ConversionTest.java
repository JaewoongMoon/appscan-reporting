package com.jwmoon.framework;
/**
 * @ MessageSourceTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwmoon.appscan.mapper.IssueMapper;
import com.jwmoon.appscan.util.CodeTranslator;
import com.jwmoon.framework.db.AppscanDBContext;
import com.jwmoon.framework.db.AppscanDBContextHolder;
import com.jwmoon.framework.project.Project;
import com.jwmoon.framework.project.ProjectService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Locale;

/**
 * <pre>
 * 
 * ConversionTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class ConversionTest {

	private static final Logger log = Logger.getLogger(ConversionTest.class);
	
	@Autowired
	ProjectService projectService;
	
	/**
	 * @Method 	: dateFormatterTest
	 * @brief	: @DateTimeFormat 애노테이션의 기능을 테스트하는 것이 목적임. 
	 *			 
	 * @author	: 문재웅(jwmoon@nhn-techorus.com)
	 * @Date	: 2016. 8. 17.
	 */
	@Test
	public void dateFormatterTest(){
        List<Project> list = projectService.selectProjects();
        log.info("============= dateFormatterTest: 프로젝트 리스트를 가져왔습니다.");
        for(Project project : list){
        	log.info("프로젝트 명 :" + project.getProjectName());
        	log.info("시작일자 : " + project.getStartDate());
        }
	//	assertThat(cnt2, is(170));
	}
}
