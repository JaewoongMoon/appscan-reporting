
package com.jwmoon.appscan.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.model.IssueType;

@Repository
public interface IssueMapper {
	
	/**
	 * Get Issue Types from database.
	 * @param condition userId in map
	 * @return IssueType entity
	 */
	List<Issue> selectIssues();
	
	List<Map <String, String>> getIssueCountBySeverity();
	
	List<Map <String, String>> getIssueCountByIssueType(Issue issue);
}
