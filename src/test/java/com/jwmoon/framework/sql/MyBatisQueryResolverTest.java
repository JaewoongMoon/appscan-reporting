package com.jwmoon.framework.sql;
/**
 * @ MyBatisQueryResolverTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwmoon.appscan.util.CodeTranslator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * <pre>
 * 
 * MyBatisQueryResolverTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class MyBatisQueryResolverTest {

	private static final Logger log = Logger.getLogger(MyBatisQueryResolverTest.class);
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private QueryResolver queryResolver;
	
	@Test
	public void loadTest(){
		assertThat(sqlSessionFactory, is(notNullValue()));
		assertThat(queryResolver, is(notNullValue()));
	}
	
	@Test
	public void getQueryTest(){
		String query = queryResolver.getQuery("selectIssues", new Object());
		//log.info(CodeTranslator.queryToModel(query));
	}
	
	@Test
	public void queryTest(){
		String query = queryResolver.getQuery("selectIssueUrls", new Object());
		String translated = CodeTranslator.queryToModel(query); 
		log.info(translated);
	}
}
