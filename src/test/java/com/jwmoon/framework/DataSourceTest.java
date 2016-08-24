package com.jwmoon.framework;
/**
 * @ MessageSourceTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.apache.commons.dbcp.BasicDataSource;
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
import com.jwmoon.framework.db.AppscanDBRoutingDataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import javax.sql.DataSource;

/**
 * <pre>
 * 
 * MessageSourceTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class DataSourceTest {

	private static final Logger log = Logger.getLogger(DataSourceTest.class);
	/*
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	BasicDataSource dataSource2;
	*/
	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;
	
	@Autowired
	IssueMapper issueMapper;
	
	@Autowired
	AppscanDBRoutingDataSource dataSource;
	
	/*
	@Test
	public void loadTest(){
		assertThat(dataSource, is(notNullValue()));
		assertThat(dataSource2, is(notNullValue()));
		assertThat(sqlSessionFactory, is(notNullValue()));
	}
	*/
	
	/**
	 * @Method 	: changeConnectionTest
	 * @brief	: dataSource의 url을 동적으로 변경하는 것이 가능한지 테스트하는 것이 목적이다. 
	 * @author	: 문재웅(jwmoon@nhn-techorus.com)
	 * @Date	: 2016. 8. 9.
	 */
	@Test
	public void changeDataSourceURLTest(){
		// 테스트 방법 : 이슈의 개수를 비교해서 변경이 되는지 확인한다. 
		// url1 은 이슈 개수가 129개 , url2 는 170개이다. 
		String url1 = "jdbc:firebirdsql:localhost/3050:D:/resultdb/alpha-jinroh/jinroh-RESULTSDB2.FDB?encoding=UTF-8";
		String url2 = "jdbc:firebirdsql:localhost/3050:D:/resultdb/elsword/elsword-RESULTSDB.FDB?encoding=UTF-8";
		
		// 1. dataSource의 setUrl을 이용한 방법 테스트 
		//최초 설정은 url1으로 되어있음.
		/*
		int cnt = issueMapper.selectIssues().size(); 
		assertThat(cnt, is(129));
		
		dataSource.setUrl(url2);
		sqlSessionFactory.setDataSource(dataSource);
		int cnt2 = issueMapper.selectIssues().size(); 
		assertThat(cnt2, not(170));
		 */
		/*
		dataSource.setUrl(url1);
		int cnt1 = issueMapper.selectIssues().size(); 
		assertThat(cnt1, is(129));
		*/
		
		// 2. Connection을 새로 생성하는 방법 테스트
		/*
		dataSource.setConnectionProperties("[serverName=jdbc:firebirdsql:localhost/3050:D:/resultdb/elsword/elsword-RESULTSDB.FDB?encoding=UTF-8;]");
		log.info("=== URL : " + dataSource.getUrl());
		*/
		// 커넥션을 새로 생성하고 재설정해주는 작업을 하고 싶은데....방법이 없음.
		// 1) JDBC만을 사용해서 프로그래밍하면 가능하나, 이렇게 하면 오픈소스 커넥션 풀 관리 DataSource인 
		// org.apache.commons.dbcp.BasicDataSource 를 사용할 수 없다. 즉, 커넥션 풀 관리 기능을 포기해야 한다. 
		// 2) 프레임워크에는 그런 기능을 제공하지 않는데, 이유는 웹 어플리케이션이 동작하는 중에 dataSource가 바라보는 곳이 
		// 막 바뀌면 사용자가 여러명이 될 경우 혼란이 초래되기 때문인 것 같다. 예를들어 사용자A는 DB1 을 보겠다고 설정했는데,
		// 사용자 B는 DB2를 보고 싶다고 하는 경우 각 사용자 입장에서는 선택한대로 제대로 보여지지 않는 문제가 발생할 수 있다.
		// 따라서, DataSource를 여러개를 등록해두고, 사용자의 요청에 맞게 보여주는 것이 최선의 방법인 것 같다.
		// 참고로, DataSource가 FDB파일이 늘어나는 것에 맞게 동적으로 늘어나야 하는 경우라면 
		// 별도 이벤트 리스너 클래스를 만들어서 늘어난 만큼 스프링에 동적으로 등록해주도록 해야할 것 같다.
		// 일단은 XML 파일에 여러 개의 DataSource를 등록해두는 쪽으로 개발을 진행하도록 하자. 
		// 이에 관해서는 여러개의 DataSource를 관리해주는 스프링의 Dynamic DataSource Routing 라는 기능이 있다고 하니 
		// 이 쪽을 연구해보자. (https://spring.io/blog/2007/01/23/dynamic-datasource-routing/)
		
	}
	
	/**
	 * @Method 	: changeDataSourceTest
	 * @brief	: dataSource의 URL을 동적으로 변경하는 것이 불가능하므로, 
	 *				DataSource를 여러 개 등록해두고 동적으로 바꿔가면서 사용할 수 있는지 테스트를 해보자.
	 *			 
	 * @author	: 문재웅(jwmoon@nhn-techorus.com)
	 * @Date	: 2016. 8. 9.
	 */
	@Test
	public void changeDataSourceTest(){
		/* ThreadLocal 범위의 테스트는 성공하였음. 
		AppscanDBContextHolder.setAppscanDBContext(AppscanDBContext.JINROH);
		int cnt = issueMapper.selectIssues().size(); 
		assertThat(cnt, is(129));

		AppscanDBContextHolder.setAppscanDBContext(AppscanDBContext.ELSWORD);
		int cnt2 = issueMapper.selectIssues().size(); 
		assertThat(cnt2, is(170));
		*/
		
		// 세션범위에서 동작하도록 만들고 싶음. 
		// 일단 강제로 바꿀 수 있는 테스트.. 동작하지 않음. 
		log.info("============== Class : " + dataSource.getClass());
		//dataSource = (AppscanDBRoutingDataSource)dataSource; //캐스팅
		//dataSource.resolveSpecifiedLookupKey();
		//dataSource.resolveSpecifiedLookupKey(AppscanDBContext.JINROH);
		int cnt = issueMapper.selectIssues().size(); 
		assertThat(cnt, is(129));
		
		//dataSource.resolveSpecifiedLookupKey(AppscanDBContext.ELSWORD);
		int cnt2 = issueMapper.selectIssues().size(); 
		assertThat(cnt2, is(170));
	}
}
