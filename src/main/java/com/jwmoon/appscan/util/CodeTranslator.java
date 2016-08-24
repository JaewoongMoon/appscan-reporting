/**
 * @ CodeTranslator.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.util;

/**
 * <pre>
 * com.jwmoon.appscan.util
 * CodeTranslator.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 29.
 */
public class CodeTranslator {

	public static String queryToModel(String query){
		// => private String fileId;
		String translated = query.replaceAll("SELECT", "")
				.replaceAll("a.* as","private String")
				.replaceAll(",", ";")
				.replaceAll("FROM * a", ""); 
			
		//System.out.println(translated);
		return translated;
	}
	
}
