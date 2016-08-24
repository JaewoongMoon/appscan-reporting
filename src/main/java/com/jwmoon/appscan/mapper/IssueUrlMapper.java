
package com.jwmoon.appscan.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.jwmoon.appscan.model.Issue;
import com.jwmoon.appscan.model.IssueType;
import com.jwmoon.appscan.model.IssueUrl;

@Repository
public interface IssueUrlMapper {
	
	List<IssueUrl> selectIssueUrls();

    Integer getIssueUrlCounts(IssueUrl issueUrl);
	
}
