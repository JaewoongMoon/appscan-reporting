
package com.jwmoon.appscan.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.jwmoon.appscan.model.IssueType;

@Repository
public interface IssueTypeMapper {
	
	/**
	 * Get Issue Types from database.
	 * @param condition userId in map
	 * @return IssueType entity
	 */
	List<IssueType> selectIssueTypes();
}
