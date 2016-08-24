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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwmoon.appscan.util.CodeTranslator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Locale;

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
public class MessageSourceTest {

	private static final Logger log = Logger.getLogger(MessageSourceTest.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Test
	public void loadTest(){
		assertThat(messageSource, is(notNullValue()));
	}
	
	@Test
	public void localeTest(){
		String high = messageSource.getMessage("label.issue.severity.high", null, Locale.KOREA);
		assertThat(high, is("고"));
	}

}
