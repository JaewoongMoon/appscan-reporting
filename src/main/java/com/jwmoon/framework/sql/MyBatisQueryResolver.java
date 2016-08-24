/**
 * @ MyBatisQueryResolver.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jwmoon.framework.sql;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016/02/10
 */
public class MyBatisQueryResolver implements QueryResolver {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	public String getQuery(String queryId, Object paramObject){
		SqlSession session = sqlSessionFactory.openSession();
		String query = resolveQuery(session, queryId, paramObject);
		session.close();
		return query;
	}
	
	
	
	 private String resolveQuery(SqlSession sqlSession, String queryId , Object sqlParam){
		 	
			BoundSql boundSql = sqlSession.getConfiguration().getMappedStatement(queryId).getSqlSource().getBoundSql(sqlParam);
			
			String sql = boundSql.getSql();
			//System.out.println("바운드 되기전 SQL : " + sql);
			
			Object paramObj = boundSql.getParameterObject();

			if(paramObj != null){  
				List<ParameterMapping> paramMapping = boundSql.getParameterMappings();
				
				Class<? extends Object> paramClass = paramObj.getClass();
				
				for(ParameterMapping mapping : paramMapping){
					String propValue = mapping.getProperty();
					try {
						Field field = paramClass.getDeclaredField(propValue);
						field.setAccessible(true);  //멤버 변수가 private일 경우  
						
						Class<?> javaType = mapping.getJavaType();
						
						if(String.class == javaType){
							sql = sql.replaceFirst("\\?", "'" + field.get(paramObj) + "'");
						}else{
							sql = sql.replaceFirst("\\?", "'" + field.get(paramObj).toString() + "'");
						}
						
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			return sql; 
		}
}
