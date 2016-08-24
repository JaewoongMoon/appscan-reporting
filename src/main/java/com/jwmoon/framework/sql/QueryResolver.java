/**
 * @ QueryResolver.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.sql;


/**
 * <pre>
 * oz.uds.pnpSecure.service.sql.base
 * QueryResolver.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016/02/10
 */
public interface QueryResolver {

	public String getQuery(String queryId, Object paramObject);
}
