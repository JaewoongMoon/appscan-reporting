/**
 * @ AppscanFdbRoutingDataSource.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.db;

import javax.inject.Provider;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.jwmoon.appscan.controller.IssueController;

/**
 * <pre>
 * com.jwmoon.framework.db
 * AppscanDBRoutingDataSource.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 10.
 */
public class AppscanDBRoutingDataSource extends AbstractRoutingDataSource{

	private static Logger log = (Logger) LoggerFactory.getLogger(AppscanDBRoutingDataSource.class);
	/*
	private AppscanDBContext dbContext = AppscanDBContext.JINROH; // Default
	
	public void setAppscanDBContext(AppscanDBContext dbContext){
		this.dbContext = dbContext;
	}*/
	
	
	//Provider<AppscanDBContextHolder> appscanDBContextHolderProvider;
	@Autowired
	AppscanDBContextHolder appscanDBContextHolder;
	
	/*
	public void setAppscanDBContextHolder(AppscanDBContextHolder appscanDBContextHolder) {
		this.appscanDBContextHolder = appscanDBContextHolder;
	}*/



	@Override
	protected Object determineCurrentLookupKey() {
		if(appscanDBContextHolder == null){
			return AppscanDBContext.JINROH;
		}
		return appscanDBContextHolder.getAppscanDBContext();
	}
}
