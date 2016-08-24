/**
 * @ AppscanDbContextHolder.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.db;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.util.Assert;

/**
 * <pre>
 * com.jwmoon.framework.db
 * AppscanDBContextHolder.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 10.
 */
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AppscanDBContextHolder implements IAppscanDBContextHolder, Serializable{
	
	private static final long serialVersionUID = 2394429217885377352L;
	
	private AppscanDBContext appscanDBContext = AppscanDBContext.JINROH; // default

	public AppscanDBContext getAppscanDBContext() {
		return appscanDBContext;
	}

	public void setAppscanDBContext(AppscanDBContext appscanDBContext) {
		this.appscanDBContext = appscanDBContext;
	}
}
