/**
 * @ IAppscanDBContextHolder.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.db;

/**
 * <pre>
 * com.jwmoon.framework.db
 * IAppscanDBContextHolder.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 12.
 */
public interface IAppscanDBContextHolder {

	public AppscanDBContext getAppscanDBContext() ;
	
	public void setAppscanDBContext(AppscanDBContext appscanDBContext);
}
