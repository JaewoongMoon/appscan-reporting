/**
 * @ CommonUtil.java $version 2015-6-26
 * 
 * Copyright 2015 NHN ST Corp. All rights Reserved. 
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.appscan.util;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * CommonUtil
 * 
 * @author nhnst
 */
public class CommonUtil {

	public static final String DEFAULT_PATTERN_YYYYMMDD = "yyyy/MM/dd";

	@Autowired
	
	
	private CommonUtil() {
	}
	
	/**
	 * @Method 	: getLocalFromRequest
	 * @brief	: request로부터 Locale 객체를 얻는다. 
	 * @author	: 문재웅(jwmoon@nhn-techorus.com)
	 * @Date	: 2016. 8. 1.
	 * @param request
	 * @return
	 */
	public static Locale getLocalFromRequest(HttpServletRequest request){
		//WebApplicationContext ac = RequestContextUtils.getWebApplicationContext(request);
		return RequestContextUtils.getLocale(request);
	}

	/**
	 * Get message
	 * 
	 * @param request HttpServletRequest
	 * @param args Object[]
	 * @param code String
	 * @return String
	 */
	public static String getLocaleMessage(HttpServletRequest request, Object[] args, String code) {
		// 꼭 request 를 사용해서만 Context를 얻어야 하는가? 다른 방법은 없는가?
		WebApplicationContext ac = RequestContextUtils.getWebApplicationContext(request);
		return ac.getMessage(code, args, RequestContextUtils.getLocale(request));
	}

	/**
	 * Get message
	 * 
	 * @param request HttpServletRequest
	 * @param arg Object
	 * @param code String
	 * @return String
	 */
	public static String getLocaleMessage(HttpServletRequest request, Object arg, String code) {
		if (arg == null) {
			return getLocaleMessage(request, null, code);
		} else {
			return getLocaleMessage(request, new Object[] { arg }, code);
		}
	}

	/**
	 * Get message
	 * 
	 * @param request HttpServletRequest
	 * @param code String
	 * @return String
	 */
	public static String getLocaleMessage(HttpServletRequest request, String code) {
		return getLocaleMessage(request, null, code);
	}

	/**
	 * デフォルト格式で日付をフォーマットする
	 * 
	 * @param date Date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return formatDate(date, DEFAULT_PATTERN_YYYYMMDD);
	}

	/**
	 * 日付をフォーマットする
	 * 
	 * @param date Date
	 * @param pattern String
	 * @return String
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			return null;
		} else {
			return DateFormatUtils.format(date, pattern);
		}
	}
}