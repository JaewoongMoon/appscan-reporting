/**
 * @ DBContext.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.db;

/**
 * <pre>
 * com.jwmoon.framework.db
 * AppScanDBContext.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 8. 10.
 */
public enum AppscanDBContext {

	JINROH(1),
	ELSWORD(2);
	
	private final int value;
	
	AppscanDBContext(int value){
		this.value = value;
	}
	
	public int intValue(){
		return value;
	}
	
	
	public static AppscanDBContext valueOf(int value){
		switch(value){
		case 1: return JINROH;
		case 2: return ELSWORD;
		default: throw new AssertionError("Unkown value: " + value);
		}
	}
}
